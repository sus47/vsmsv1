
package jsp;

import java.io.File;
import java.io.FileOutputStream;
import static jsp.Create.getCLassName;
import static jsp.Create.td;

public class CreateRestController {
    
CreateRestController(String packName,String controllerName,String tabName,String[] td)
{
    packName=packName.toLowerCase();
String url="api/"+packName+"/"+controllerName.toLowerCase();
String daoName="dao."+packName.replace("/", ".").toLowerCase()+".Dao"+controllerName;
String daoImpName="dao."+packName.replace("/", ".").toLowerCase()+".DaoImp"+controllerName;
tabName=getCLassName(tabName);

 String temp="/*\nreturn \"\\n{";
for(int k=0;k< td.length;k++)temp+="\\\""+td[k]+"\\\": \\\"\"+"+td[k]+"+\"\\\",";
temp=temp.substring(0, temp.length()-1);
 temp+="}\";\n*/";
 String objMap="\n " +
"map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});\n" +
"\nmodel."+packName+"."+controllerName+" obj=new model."+packName+"."+controllerName+"();\n/*";
 String settter;
   for(int i=0;i<td.length;i++)
   {
       settter="set"+td[i].substring(0, 1).toUpperCase()+td[i].substring(1,td[i].length());
    objMap+="obj."+settter+"(map.get(\""+td[i]+"\").toString());\n";
   }
   objMap+="*/\n";
String write=temp+"\n" +
"\n" +
"package rest.controller."+packName+";\n" +
"\n" +
"import java.io.IOException;\n" +
"import java.util.HashMap;\n" +
"import java.util.Map;\n" +
"import model.assign.CourseGroup;\n" +
"import org.codehaus.jackson.map.ObjectMapper;\n" +
"import org.codehaus.jackson.type.TypeReference;\n" +
"import org.springframework.ui.Model;\n" +
"import org.springframework.web.bind.annotation.ModelAttribute;\n" +
"import org.springframework.web.bind.annotation.PathVariable;\n" +
"import org.springframework.web.bind.annotation.RequestBody;\n" +
"import org.springframework.web.bind.annotation.RequestMapping;\n" +
"import org.springframework.web.bind.annotation.RequestMethod;\n" +
"import org.springframework.web.bind.annotation.RequestParam;\n" +
"import org.springframework.web.bind.annotation.ResponseBody;\n" +
"import org.springframework.web.bind.annotation.RestController;\n" +
"import rest.controller.ApiBaseController;\n" +
"\n" +
"@RestController\n" +
"public class "+controllerName+"RestController {\n" +
"   Map<String, Object> map = new HashMap<String, Object>();\n" +
"ObjectMapper mapper = new ObjectMapper();  \n" +
""+daoName+" da=new "+daoImpName+"(); \n" +
"ApiBaseController json=new ApiBaseController();\n" +
"String msg=\"\";\n" +
"\n" +
"@RequestMapping(value = \""+url+"\", method = RequestMethod.GET, produces = \"application/json\")\n" +
"@ResponseBody\n" +
"public String index()\n" +
"{\n" +
"return json.respondWithMessage(\"Success\",da.getAll(\"from "+controllerName+"\"));\n" +
"}\n" +
"    \n" +
"@RequestMapping(value = \""+url+"\", method = RequestMethod.POST, produces = \"application/json\")\n" +
"@ResponseBody\n" +
"public String doSave(@RequestBody String jcson) throws IOException\n" +
"{\n "+
objMap+ "\n msg=da.save(obj);\n" +
"if(msg.equalsIgnoreCase(\"Saved\"))\n" +
"{\n" +
"return json.respondWithMessage(\"Success\",da.getAll(\" from "+controllerName+"\"));\n" +
"}\n" +
"return json.respondWithError(msg);\n" +
"}\n" +
"\n" +
"@RequestMapping(value = \""+url+"/{"+td[0]+"}\", method = RequestMethod.PUT, produces = \"application/json\")\n" +
"@ResponseBody\n" +
"public String doUpdate(@RequestBody String jcson,@PathVariable String "+td[0]+") throws IOException\n" +
"{\ntry{" +objMap+
" msg=da.update(obj);\n" +
"if(msg.equalsIgnoreCase(\"Updated\"))\n" +
"{\n" +
"return json.respondWithMessage(\"Updated successfully\",da.getAll(\" from "+controllerName+"\"));\n" +
"}\n}catch(Exception e){msg=e.getMessage()+\" \"+jcson;}\n" +
"return json.respondWithError(msg);\n" +
"}\n" +
"\n" +
"@RequestMapping(value = \""+url+"/{"+td[0]+"}\", method = RequestMethod.DELETE, produces = \"application/json\")\n" +
"@ResponseBody\n" +
"public String doDelete(@PathVariable String "+td[0]+")" +
"{\n "+td[0]+"="+td[0]+".replaceAll(\"\\\"\", \"'\");\n"
        + "String sql=\"DELETE FROM "+ controllerName+"WHERE "+td[0]+" IN \"+"+td[0]+"+\" \";\n" +
"msg=da.delete(sql);\n" +
"if(msg.indexOf(\"Record Deleted\")>=0)\n" +
"return json.respondWithMessage(\"Record Deleted successfully\",da.getAll(\" from "+controllerName+"\"));" +
"else \n" +
"return json.respondWithError(msg);\n" +
"}\n" +
"}\n" +
"";
// System.out.println(packName); 
//    System.out.println(write);
////System.out.println("src/java/controller/"+packName.replace("/", ".").toLowerCase()); 
File file=new File("src/java/rest/controller/"+packName.replace("/", ".").toLowerCase());
try{
if(!file.exists())
{
try
{
file.mkdirs();
}catch(Exception e){System.out.println(e);}
}

FileOutputStream out=new FileOutputStream("src/java/rest/controller/"+packName.toLowerCase()+"/"+controllerName+"RestController.java");
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
out.close();
}catch(Exception e){System.out.println(e.getMessage());}

}
//    public static void main(String[] args) {
//      String  tabName="subject_para_com";
//String fileName="SubjectParaCom";
//String packageName="Assign";
////        new CreateRestController(packageName, fileName, tabName);
//    }
}
