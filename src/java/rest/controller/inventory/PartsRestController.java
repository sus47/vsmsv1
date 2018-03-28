/*
return "\n{\"sn\": \""+sn+"\",\"partsNumber\": \""+partsNumber+"\",\"name\": \""+name+"\",\"bikeId\": \""+bikeId+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"status\": \""+status+"\",\"entryDate\": \""+entryDate+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
*/

package rest.controller.inventory;

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
public class PartsRestController {
   Map<String, Object> map = new HashMap<String, Object>();
ObjectMapper mapper = new ObjectMapper();  
dao.inventory.DaoParts da=new dao.inventory.DaoImpParts(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/inventory/parts", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",da.getAll("from Parts"));
}
    
@RequestMapping(value = "api/inventory/parts", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doSave(@RequestBody String jcson) throws IOException
{
 
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.inventory.Parts obj=new model.inventory.Parts();
/*obj.setSn(map.get("sn").toString());
obj.setPartsNumber(map.get("partsNumber").toString());
obj.setName(map.get("name").toString());
obj.setBikeId(map.get("bikeId").toString());
obj.setCostPrice(map.get("costPrice").toString());
obj.setSellingPrice(map.get("sellingPrice").toString());
obj.setQuantity(map.get("quantity").toString());
obj.setStatus(map.get("status").toString());
obj.setEntryDate(map.get("entryDate").toString());
obj.setCreatedDate(map.get("createdDate").toString());
obj.setUpdatedDate(map.get("updatedDate").toString());
*/

 msg=da.save(obj);
if(msg.equalsIgnoreCase("Saved"))
{
return json.respondWithMessage("Success",da.getAll(" from Parts"));
}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/inventory/parts/{sn}", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestBody String jcson,@PathVariable String sn) throws IOException
{
try{
 map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});

model.inventory.Parts obj=new model.inventory.Parts();
/*obj.setSn(map.get("sn").toString());
obj.setPartsNumber(map.get("partsNumber").toString());
obj.setName(map.get("name").toString());
obj.setBikeId(map.get("bikeId").toString());
obj.setCostPrice(map.get("costPrice").toString());
obj.setSellingPrice(map.get("sellingPrice").toString());
obj.setQuantity(map.get("quantity").toString());
obj.setStatus(map.get("status").toString());
obj.setEntryDate(map.get("entryDate").toString());
obj.setCreatedDate(map.get("createdDate").toString());
obj.setUpdatedDate(map.get("updatedDate").toString());
*/
 msg=da.update(obj);
if(msg.equalsIgnoreCase("Updated"))
{
return json.respondWithMessage("Updated successfully",da.getAll(" from Parts"));
}
}catch(Exception e){msg=e.getMessage()+" "+jcson;}
return json.respondWithError(msg);
}

@RequestMapping(value = "api/inventory/parts/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM parts WHERE SN IN "+sn+" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from Parts"));else 
return json.respondWithError(msg);
}
}
