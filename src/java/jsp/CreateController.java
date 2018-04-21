/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import java.io.File;
import java.io.FileOutputStream;
import static jsp.Create.getCLassName;

/**
 *
 * @author MS
 */
public class CreateController {
 
CreateController(String packName,String controllerName,String tabName)
{
String url=packName+"/"+controllerName;
String daoName="dao."+packName.replace("/", ".").toLowerCase()+".Dao"+controllerName;
String daoImpName="dao."+packName.replace("/", ".").toLowerCase()+".DaoImp"+controllerName;
tabName=getCLassName(tabName);
 
   
String write="\n" +
"package controller."+packName.replace("/", ".").toLowerCase()+";\n\n" +
"import org.springframework.stereotype.Controller;\n" +
"import org.springframework.ui.ModelMap;\n" +
"import org.springframework.web.bind.annotation.ModelAttribute;\n" +
"import org.springframework.web.bind.annotation.RequestMapping;\n" +
"import org.springframework.web.bind.annotation.RequestMethod;\n"
+ "import org.springframework.web.bind.annotation.RequestParam;\n\n"+
"@Controller\n" +
"public class "+controllerName+"Controller {\n" +
"@RequestMapping(value=\""+url+"\",method = RequestMethod.GET)\n" +
"public String doGet(ModelMap map)\n" +
"{\n"+
 " "+daoName+" da=new "+daoImpName+"(); \n" +
 "map.put(\"Record\",da.getAll(\"from "+tabName+"\"));\n" +  
"return \""+url+"\";  \n" +
"}\n" +
"@RequestMapping(value=\""+url+"\",method = RequestMethod.POST)\n" +
"public String doSave(@ModelAttribute model."+packName.replace("/", ".").toLowerCase()+"."+tabName+" obj,ModelMap map,@RequestParam String Action)\n" +
"{\n"+daoName+" da=new "+daoImpName+"(); \n" +
" if(Action.equalsIgnoreCase(\"Save\"))\n" +
"{"+
 "\n map.addAttribute(\"msg\", da.save(obj));\n"+
  "}else if(Action.equalsIgnoreCase(\"Update\"))\n" +
"{\n"+
 "map.addAttribute(\"msg\", da.update(obj));\n"+
"}else if(Action.equalsIgnoreCase(\"Delete\"))\n" +
"{\n"+
 " map.addAttribute(\"msg\", da.delete(obj));\n"+
"}\n"+
 "map.put(\"Record\",da.getAll(\"from "+tabName+"\"));\n" + 
"return \""+url+"\";  \n" +
"}\n" +
"}\n" +
"";
// System.out.println(packName); 
  
//System.out.println("src/java/controller/"+packName.replace("/", ".").toLowerCase()); 
File file=new File("src/java/controller/"+packName.replace("/", ".").toLowerCase());
try{
if(!file.exists())
{
try
{
file.mkdirs();
}catch(Exception e){System.out.println(e);}
}

FileOutputStream out=new FileOutputStream("src/java/controller/"+packName.toLowerCase()+"/"+controllerName+"Controller.java");
for(int k=0;k< write.length();k++)
out.write(write.charAt(k));
out.close();
}catch(Exception e){System.out.println(e.getMessage());}

}   
}
