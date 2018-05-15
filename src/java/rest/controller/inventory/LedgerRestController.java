/*
return "\n{\"sn\": \""+sn+"\",\"cusId\": \""+cusId+"\",\"staffId\": \""+staffId+"\",\"description\": \""+description+"\",\"debit\": \""+debit+"\",\"credit\": \""+credit+"\",\"createdDate\": \""+createdDate+"\"}";
*/

package rest.controller.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DB;
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
public class LedgerRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.inventory.DaoLedger da=new dao.inventory.DaoImpLedger(); 
ApiBaseController json=new ApiBaseController();
DB db = new DB();
String msg="";
GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
@RequestMapping(value = "api/inventory/ledger", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
    String sql ="SELECT SN sn,IFNULL(CUS_ID,STAFF_ID) AS customerId, IFNULL(GET_CUSTOMER_NAME(CUS_ID),GET_STAFF_NAME(STAFF_ID)) AS customerName,DESCRIPTION description, DEBIT debit, CREDIT credit FROM ledger"; 
    List list = db.getRecord(sql);
    return json.respondWithMessage("Success", gson.toJson(list));
//return json.respondWithMessage("Success",da.getAll("from Ledger"));
}
    
@RequestMapping(value = "api/inventory/ledger", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.inventory.Ledger obj=new model.inventory.Ledger();
/*obj.setSn(map.get("sn").toString());*/
obj.setCusId(map.get("customerId").toString());
obj.setStaffId(map.get("staffId").toString());
obj.setDescription(map.get("description").toString());
obj.setDebit(Convert.toFloat(map.get("debit").toString()));
obj.setCredit(Convert.toFloat(map.get("credit").toString()));
obj.setCreatedDate(Convert.toDate(map.get("date").toString()));

 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Ledger"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/inventory/ledger/{sn}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String sn) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.inventory.Ledger obj=new model.inventory.Ledger();
/*obj.setSn(map.get("sn").toString());
obj.setCusId(map.get("cusId").toString());
obj.setStaffId(map.get("staffId").toString());
obj.setDescription(map.get("description").toString());
obj.setDebit(map.get("debit").toString());
obj.setCredit(map.get("credit").toString());
obj.setCreatedDate(map.get("createdDate").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Ledger"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/inventory/ledger/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM Ledger WHERE SN IN "+sn+" ";
    System.out.println(sql);
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Ledger"));else 
return json.respondWithError(msg);
}
}
