/*
return "\n{\"id\": \""+id+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"pan\": \""+pan+"\",\"bikesId\": \""+bikesId+"\",\"payment\": \""+payment+"\",\"dueAmount\": \""+dueAmount+"\",\"invoice\": \""+invoice+"\"}";
*/

package rest.controller.customer;

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
public class CustomersRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.customer.DaoCustomers da=new dao.customer.DaoImpCustomers(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/customer/customers", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",da.getAll("from Customers"));
}
    
@RequestMapping(value = "api/customer/customers", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.customer.Customers obj=new model.customer.Customers();
/*obj.setId(map.get("id").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setPan(map.get("pan").toString());
obj.setBikesId(map.get("bikesId").toString());
obj.setPayment(map.get("payment").toString());
obj.setDueAmount(map.get("dueAmount").toString());
obj.setInvoice(map.get("invoice").toString());
*/

 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Customers"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/customer/customers/{id}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String id) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.customer.Customers obj=new model.customer.Customers();
/*obj.setId(map.get("id").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setPan(map.get("pan").toString());
obj.setBikesId(map.get("bikesId").toString());
obj.setPayment(map.get("payment").toString());
obj.setDueAmount(map.get("dueAmount").toString());
obj.setInvoice(map.get("invoice").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Customers"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/customer/customers/{id}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String id){
 id=id.replaceAll("\"", "'");
String sql="DELETE FROM customers WHERE ID IN "+id+" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Customers"));else 
return json.respondWithError(msg);
}
}
