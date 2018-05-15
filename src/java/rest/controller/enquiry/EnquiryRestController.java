/*
return "\n{\"sn\": \""+sn+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"title\": \""+title+"\",\"description\": \""+description+"\",\"officer\": \""+officer+"\",\"date\": \""+date+"\"}";
*/

package rest.controller.enquiry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.controller.ApiBaseController;

@RestController
public class EnquiryRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.enquiry.DaoEnquiry da=new dao.enquiry.DaoImpEnquiry(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/enquiry/enquiry", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",da.getAll("from Enquiry"));
}
    
@RequestMapping(value = "api/enquiry/enquiry", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.enquiry.Enquiry obj=new model.enquiry.Enquiry();
/*obj.setSn(map.get("sn").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setTitle(map.get("title").toString());
obj.setDescription(map.get("description").toString());
obj.setOfficer(map.get("officer").toString());
obj.setDate(map.get("date").toString());
*/

 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Enquiry"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/enquiry/enquiry/{sn}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String sn) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.enquiry.Enquiry obj=new model.enquiry.Enquiry();
/*obj.setSn(map.get("sn").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setTitle(map.get("title").toString());
obj.setDescription(map.get("description").toString());
obj.setOfficer(map.get("officer").toString());
obj.setDate(map.get("date").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Enquiry"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/enquiry/enquiry/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM enquiry WHERE SN IN "+ sn +" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Enquiry"));else 
return json.respondWithError(msg);
}
}
