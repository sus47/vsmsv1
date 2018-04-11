/*
return "\n{\"sn\": \""+sn+"\",\"cusId\": \""+cusId+"\",\"cusName\": \""+cusName+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"orgType\": \""+orgType+"\",\"cusType\": \""+cusType+"\",\"serviceBill\": \""+serviceBill+"\",\"panNo\": \""+panNo+"\",\"serviceTimes\": \""+serviceTimes+"\",\"serviceType\": \""+serviceType+"\",\"invoice\": \""+invoice+"\",\"bikeId\": \""+bikeId+"\",\"quantity\": \""+quantity+"\",\"discount\": \""+discount+"\",\"totalSp\": \""+totalSp+"\",\"vat\": \""+vat+"\",\"netTotal\": \""+netTotal+"\",\"advance\": \""+advance+"\",\"due\": \""+due+"\",\"createdDate\": \""+createdDate+"\"}";
*/

package rest.controller.bills;

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
public class BillsRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.bills.DaoBills da=new dao.bills.DaoImpBills(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/bills/bills", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",da.getAll("from Bills"));
}
    
@RequestMapping(value = "api/bills/bills", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.bills.Bills obj=new model.bills.Bills();
/*obj.setSn(map.get("sn").toString());
obj.setCusId(map.get("cusId").toString());
obj.setCusName(map.get("cusName").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setOrgType(map.get("orgType").toString());
obj.setCusType(map.get("cusType").toString());
obj.setServiceBill(map.get("serviceBill").toString());
obj.setPanNo(map.get("panNo").toString());
obj.setServiceTimes(map.get("serviceTimes").toString());
obj.setServiceType(map.get("serviceType").toString());
obj.setInvoice(map.get("invoice").toString());
obj.setBikeId(map.get("bikeId").toString());
obj.setQuantity(map.get("quantity").toString());
obj.setDiscount(map.get("discount").toString());
obj.setTotalSp(map.get("totalSp").toString());
obj.setVat(map.get("vat").toString());
obj.setNetTotal(map.get("netTotal").toString());
obj.setAdvance(map.get("advance").toString());
obj.setDue(map.get("due").toString());
obj.setCreatedDate(map.get("createdDate").toString());
*/

 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Bills"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/bills/bills/{sn}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String sn) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.bills.Bills obj=new model.bills.Bills();
/*obj.setSn(map.get("sn").toString());
obj.setCusId(map.get("cusId").toString());
obj.setCusName(map.get("cusName").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setOrgType(map.get("orgType").toString());
obj.setCusType(map.get("cusType").toString());
obj.setServiceBill(map.get("serviceBill").toString());
obj.setPanNo(map.get("panNo").toString());
obj.setServiceTimes(map.get("serviceTimes").toString());
obj.setServiceType(map.get("serviceType").toString());
obj.setInvoice(map.get("invoice").toString());
obj.setBikeId(map.get("bikeId").toString());
obj.setQuantity(map.get("quantity").toString());
obj.setDiscount(map.get("discount").toString());
obj.setTotalSp(map.get("totalSp").toString());
obj.setVat(map.get("vat").toString());
obj.setNetTotal(map.get("netTotal").toString());
obj.setAdvance(map.get("advance").toString());
obj.setDue(map.get("due").toString());
obj.setCreatedDate(map.get("createdDate").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Bills"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/bills/bills/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM BillsWHERE sn IN "+sn+" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Bills"));else 
return json.respondWithError(msg);
}
}
