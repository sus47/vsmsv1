
package jsp;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Create 
{
  static  String  url,userName,password;
  static String[] th,td;
public static void main(String[] args) 
{
url="jdbc:mysql://localhost:3306/vsms";
userName="system";
password="manager";
String tabName,fileName,packageName;


tabName="ledger";
fileName="Ledger";
packageName="inventory";


new Create(tabName, fileName,packageName);

//System.out.print("<bean id=\""+fileName+"\" class=\"controller."+packageName.toLowerCase()+"."+fileName+"Controller\"/>");
//System.out.print(" \n\n <prop key=\""+packageName+"/"+fileName+".shsp\">"+fileName+"</prop>\n\n\n");
System.out.println("<mapping class=\"model."+packageName.toLowerCase()+"."+fileName+"\"/>\n\n\n");
System.exit(0);
}

public Create(String tabName,String javaFile,String packName)
{
  

createDao(packName, javaFile, tabName);
new CreateController(packName, javaFile, tabName);
createJsp(packName,javaFile,tabName);
new CreateRestController(packName, javaFile, tabName,td);

}

  static void createDao(String packName,String javaFile,String modelName)
  {
 modelName=(getCLassName(modelName));

 String write="\n" +
"package dao."+packName.replace("/", ".").toLowerCase()+";"+
"\nimport java.util.List;\n"+
 "import model."+packName.replace("/", ".").toLowerCase()+".*;\n" + 
 " public interface  Dao"+javaFile+" {\n" +
 " public String save("+modelName+" obj);\n" +
 " public String update("+modelName+" obj);\n" +
 " public String delete("+modelName+" obj);\n"+
 "public String delete(String sql);\n"+
 "public List<"+modelName+"> getAll(String hql);\n"+
"public List getRecord(String sql);\n"+
"}\n" ;
// System.out.println(packName); 

//System.out.println("src/java/dao/"+packName.toLowerCase()); 
File file=new File("src/java/dao/"+packName.toLowerCase());
try{
if(!file.exists())file.mkdirs();
FileOutputStream out=new FileOutputStream("src/java/dao/"+packName.toLowerCase()+"/Dao"+javaFile+".java");
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
write="package dao."+packName.replace("/", ".").toLowerCase()+";\n" +
"import java.util.List;\n"+
"import org.hibernate.Session;\n"+
"import org.hibernate.Session;\n" +
"import org.hibernate.Transaction;\n"+
"import org.hibernate.Query;\n" +
"import java.util.LinkedList;\n"+
"import model."+packName.replace("/", ".").toLowerCase()+".*;\n" +
"public class DaoImp"+javaFile+" implements Dao"+javaFile+"{\n" +
"@Override\n" +
"public List<"+modelName+"> getAll(String hql) {\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"return session.createQuery(hql).list();\n" +
"}\n"+
 "@Override\n" +
"public String save("+modelName+" obj) {\n" +
"String msg=\"Saved\";\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"Transaction tr=session.beginTransaction();\ntry{\n" +
"session.save(obj);\n" +
"tr.commit(); \n" +
"}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}\n" +
"return msg;\n" +
"}\n"+
"@Override\n" +
"public String update("+modelName+"  obj) {\n" +
"String msg=\"Updated\";\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"Transaction tr=session.beginTransaction();\n try{\n" +
"session.update(obj);\n" +
"tr.commit(); \n" +
"}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}\n" +
"return msg;\n" +
"}\n"+
"@Override\n" +
"public String delete("+modelName+" obj) \n" +
"{\n" +
"String msg=\"Delete\";\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"Transaction tr=session.beginTransaction();try{\n  " +
"session.delete(obj);\n" +
"tr.commit(); \n" +
"}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}\n" +
"return msg;\n" +
"}\n@Override\n" +
"public String delete(String sql) {\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"Transaction tr=session.beginTransaction();\nString msg=\"\";\n"+
 "try{ \n" +
"int count= session.createSQLQuery(sql).executeUpdate();\n" +
"tr.commit();\n" +
"return msg=count+\" Record Deleted\";\n" +
"}catch(Exception e){ tr.rollback();msg=model.ExMsg.get(e); }\n" +
"return msg;\n" +
"    }\n\n"+
"@Override\n" +
"public List getRecord(String sql)\n" +
"{\n" +
"List list=new LinkedList();\n" +
"Session session=model.HibernateUtil.getSessionFactory().openSession();\n" +
"try{ \n" +
" list=session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();\n" +
"}catch(Exception e){ list.add(0, model.ExMsg.get(e));}\n" +
"return list;\n" +
"}\n" +
"}";

out=new FileOutputStream("src/java/dao/"+packName+"/DaoImp"+javaFile+".java");
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
out.close();
}catch(Exception e){System.out.println(e.getMessage());}


  }

static void createJsp(String packageName,String fileName,String tabName)
{

String write,filePath="web/WEB-INF/jsp/"+packageName;
//    System.out.println(filePath);
File file=new File(filePath);

try{
if(!file.exists())
{
   file.mkdirs();   
}
  FileOutputStream out=new FileOutputStream(filePath+"/"+fileName+".jsp");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(url,userName,password);
Statement st=con.createStatement();
ResultSet rs;
ResultSetMetaData md;
try{
    write=
    "<%@include file=\"../login/header.jsp\" %>\n "
    + "<center><h3><label><u>"+fileName+"</u></label></h3></center>"
    + "\n<form method='POST'> \n<div class=\"row\">\n";
    for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
    
rs=st.executeQuery("SELECT * FROM "+tabName);
md=rs.getMetaData();
int col=md.getColumnCount();
th=new String[col];
td=new String[col];
String temp,colName,lable;
char c;
for(int i=1;i<=col;i++)
{
colName=md.getColumnName(i);



if(colName.indexOf("_")>0)
{
temp=colName;
colName="";
lable="";
for(int j=0;j<temp.length();j++)
{
c=temp.charAt(j);
if(c=='_')
{
j++;
c=temp.charAt(j);
colName+=String.valueOf(c).toUpperCase();
lable+=" "+String.valueOf(c).toUpperCase();
continue;
}else{

colName+=String.valueOf(c).toLowerCase();

if(j==0)lable+=String.valueOf(c).toUpperCase();
else lable+=String.valueOf(c).toLowerCase();

}

}

}else{
colName=colName.toLowerCase();
lable="";

for(int j=0;j<colName.length();j++)
{
c=colName.charAt(j);
if(j==0)lable+=String.valueOf(c).toUpperCase();
else lable+=String.valueOf(c).toLowerCase();
}
} 

td[i-1]=colName;
th[i-1]=lable;

write=
"<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>\n" +
"<label>"+lable+"</label>\n" +
"<input type='text' name='"+colName+"' id='"+colName+"'  class='form-control'/>\n" +
"</div>\n";
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
}
write=
"<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>\n" +
"  \n  <label id='ActionMSG'>&nbsp;</label><br>  ${msg}\n<input type='submit' name='Action' id='Action' value='Save' class='btn btn-success'/>\n" +
"</div>\n" +
"</div>\n" +
"</form>";
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));

write=" <br><br><br>\n" +
" <div class='row'>\n" +
"<table class='table table-striped table-hover table-bordered' id='dataTable'>\n<tr>\n";

for(int k=0;k< th.length;k++)
write+="<th>"+th[k]+"</th>\n";
write+="<th>Action</th>\n</tr>";
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));

write=" \n<c:forEach  var=\"rst\" items=\"${Record}\" varStatus=\"i\" >\n "
+ "<tr> \n";
for(int k=0;k< td.length;k++)
write+="<td>${rst."+td[k]+"}</td>\n";
write+="<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>\n";
write+=" </tr>\n </c:forEach>\n  </table>\n" +
"</div> <script>\n" +
"function edit(sn){\nvar id = [" ;
 temp="";
for(int k=0;k< td.length;k++)temp+="'"+td[k]+"',";
temp=temp.substring(0, temp.length()-1);
write+=temp+"];\nfor( var i=0;i<id.length;i++)\n"
        + "document.getElementById(id[i]).value=document.getElementById(\"dataTable\").rows[sn].cells.item(i).innerHTML;\n" +
"document.getElementById('Action').value='Update';\ndocument.getElementById('ActionMSG').innerHTML='&nbsp;';\ndocument.getElementById('Action').focus();\n" +
"}\nfunction recordDelete(sn){\nvar id = ["+
        temp+"];\nfor( var i=0;i<id.length;i++)\n"
        + "document.getElementById(id[i]).value=document.getElementById(\"dataTable\").rows[sn].cells.item(i).innerHTML;\n" +
         "document.getElementById('Action').value='Delete'; \ndocument.getElementById('ActionMSG').innerHTML='Are You Sure';\ndocument.getElementById('Action').focus();\n}" +
"</script>\n<%@include file=\"../login/footer.jsp\" %>\n" ;
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));


 temp="\n\n\n<%--\nreturn \"\\n{";
for(int k=0;k< td.length;k++)temp+="\\\""+td[k]+"\\\": \\\"\"+"+td[k]+"+\"\\\",";
temp=temp.substring(0, temp.length()-1);
 temp+="}\";\n--%>";
   
 write=temp;
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));

}catch(Exception e){System.out.println(e.getMessage());}
con.close();
out.close();

}catch(Exception e){System.out.println(e.getMessage());}
}
   

  static String getCLassName(String colName)
{
 String temp;
 char c;
if(colName.indexOf("_")>0)
{
temp=colName;
colName="";   
for(int j=0;j<temp.length();j++)
{
c=temp.charAt(j);
 if(j==0)colName=String.valueOf(c).toUpperCase();
  else if(c=='_')
{
j++;
c=temp.charAt(j);
colName+=String.valueOf(c).toUpperCase();
  continue;
}else{
colName+=String.valueOf(c).toLowerCase();
  }

}

}else{
  temp=colName;
colName="";   
for(int j=0;j<temp.length();j++)
{
c=temp.charAt(j);
if(j==0)colName=String.valueOf(c).toUpperCase();
else colName+=String.valueOf(c).toLowerCase();
}
}

return colName;
}
  
  
  

}
