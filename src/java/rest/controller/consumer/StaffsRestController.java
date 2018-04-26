/*
return "\n{\"sn\": \""+sn+"\",\"staffId\": \""+staffId+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"joinedDate\": \""+joinedDate+"\",\"salary\": \""+salary+"\",\"attendance\": \""+attendance+"\",\"credit\": \""+credit+"\",\"createdDate\": \""+createdDate+"\",\"post\": \""+post+"\",\"type\": \""+type+"\"}";
*/

package rest.controller.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import java.io.IOException;
import java.util.Date;
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
public class StaffsRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.consumer.DaoStaffs da=new dao.consumer.DaoImpStaffs(); 
ApiBaseController json=new ApiBaseController();
String msg="", sql="";
GsonBuilder gsonBuilder = new GsonBuilder();
Gson gson = gsonBuilder.create();
@RequestMapping(value = "api/consumer/staff", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",gson.toJson(da.getAll("from Staffs")));
}
  
@RequestMapping(value="api/staff/attendance", method = RequestMethod.POST, produces="application/json")
@ResponseBody
public String attendance(@RequestBody String jcson) throws IOException
{
    map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});
    
    return json.respondWithMessage("Success");
}

@RequestMapping(value = "api/consumer/staff", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.consumer.Staffs obj=new model.consumer.Staffs();
/*obj.setSn(map.get("sn").toString());*/
obj.setStaffId(map.get("staffId").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setJoinedDate(Convert.toDate(map.get("joinedDate").toString()));
obj.setSalary(Convert.toFloat(map.get("salary").toString()));
//obj.setAttendance(Convert.toInt(map.get("attendance").toString()));
//obj.setCredit(Convert.toFloat(map.get("credit").toString()));
Date  date = new Date();
obj.setCreatedDate(date);
obj.setPost(map.get("post").toString());
obj.setType(map.get("staffType").toString());


 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Staffs"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/consumer/staff/{sn}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String sn) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.consumer.Staffs obj=new model.consumer.Staffs();
/*obj.setSn(map.get("sn").toString());
obj.setStaffId(map.get("staffId").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setJoinedDate(map.get("joinedDate").toString());
obj.setSalary(map.get("salary").toString());
obj.setAttendance(map.get("attendance").toString());
obj.setCredit(map.get("credit").toString());
obj.setCreatedDate(map.get("createdDate").toString());
obj.setPost(map.get("post").toString());
obj.setType(map.get("type").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Staffs"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/consumer/staff/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM StaffsWHERE sn IN "+sn+" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Staffs"));else 
return json.respondWithError(msg);
}
}
