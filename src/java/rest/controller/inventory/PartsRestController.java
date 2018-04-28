/*
return "\n{\"sn\": \""+sn+"\",\"partsNumber\": \""+partsNumber+"\",\"name\": \""+name+"\",\"bikeId\": \""+bikeId+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"status\": \""+status+"\",\"entryDate\": \""+entryDate+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
 */
package rest.controller.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import dao.General;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.JsonDataToStringArray;
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
    dao.inventory.DaoParts da = new dao.inventory.DaoImpParts();
    ApiBaseController json = new ApiBaseController();
    String msg = "";

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/inventory/parts", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        String sql = "SELECT SN sn, BIKE_ID bikeId, COST_PRICE costPrice, CREATED_DATE createdDate, ENTRY_DATE entryDate, NAME name, PARTS_NUMBER partsNumber, QUANTITY quantity, SELLING_PRICE sellingPrice, STATUS status,GET_BIKE_NAME(BIKE_ID) AS bikeName FROM parts";
        String msg = "";
        List list = null;
        list = da.getRecord(sql);
        return json.respondWithMessage("Obtained Successfully", gson.toJson(list));
    }

    @RequestMapping(value = "api/parts/exc", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String excelUpload(@RequestBody String jcson) throws IOException {
        System.out.println("inside parts api");
        String jsonDataArray[] = JsonDataToStringArray.get(jcson);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = objectMapper.readValue(jsonDataArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
        });
        System.out.println(list);
        model.inventory.Parts obj = new model.inventory.Parts();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            try {
                Map map = (Map) list.get(i);
                /*obj.setSn(map.get("sn").toString());*/
                obj.setPartsNumber(map.get("partsNumber").toString());
                obj.setName(map.get("name").toString());
                obj.setThreshold(Convert.toInt(map.get("threshold").toString()));
                obj.setBikeId(Convert.toInt(map.get("bikeId").toString()));
                obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
                obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
                obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
//                obj.setStatus(map.get("status").toString());
                obj.setEntryDate(map.get("entryDate").toString());
                Date date = new Date();
                obj.setCreatedDate(date);
//obj.setUpdatedDate(map.get("updatedDate").toString());

                msg = da.save(obj);
            } catch (Exception e) {
                msg = e.getMessage();
                return json.respondWithError(msg);
            }
        }
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Inserted Successfully", gson.toJson(da.getAll(" from Parts")));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/parts", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });

        model.inventory.Parts obj = new model.inventory.Parts();
        /*obj.setSn(map.get("sn").toString());*/
        obj.setPartsNumber(map.get("partsNumber").toString());
        obj.setName(map.get("name").toString());
        obj.setThreshold(Convert.toInt(map.get("threshold").toString()));
        obj.setBikeId(Convert.toInt(map.get("bikeId").toString()));
        obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
        obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
        obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
//        obj.setStatus(map.get("status").toString());
        obj.setEntryDate(map.get("entryDate").toString());
        Date date = new Date();
        obj.setCreatedDate(date);
//obj.setUpdatedDate(map.get("updatedDate").toString());

        msg = da.save(obj);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Inserted Successfully", gson.toJson(da.getAll(" from Parts")));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/parts/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson, @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.inventory.Parts obj = new model.inventory.Parts();
            obj.setSn(Convert.toInt(sn));
            obj.setPartsNumber(map.get("partsNumber").toString());
            obj.setName(map.get("name").toString());
            obj.setBikeId(Convert.toInt(map.get("bikeId").toString()));
            obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
//obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
            obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
//obj.setStatus(map.get("status").toString());
            obj.setEntryDate(map.get("entryDate").toString());
//obj.setCreatedDate(map.get("createdDate").toString());
            Date date = new Date();
            obj.setUpdatedDate(date);

            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Parts Updated successfully", gson.toJson(da.getAll(" from Parts")));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/parts/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM parts WHERE SN IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Parts Deleted successfully", gson.toJson(da.getAll(" from Parts")));
        } else {
            return json.respondWithError(msg);
        }
    }
}
