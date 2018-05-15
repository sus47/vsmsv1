/*
return "\n{\"sn\": \""+sn+"\",\"model\": \""+model+"\",\"color\": \""+color+"\",\"engineNumber\": \""+engineNumber+"\",\"chasisNumber\": \""+chasisNumber+"\",\"regNo\": \""+regNo+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"entryDate\": \""+entryDate+"\",\"status\": \""+status+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
 */
package rest.controller.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jsp.DB;
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
public class BikesRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.inventory.DaoBikes da = new dao.inventory.DaoImpBikes();
    ApiBaseController json = new ApiBaseController();
    String msg = "";
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/inventory/bikes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", gson.toJson(da.getAll("from Bikes")));
    }

    @RequestMapping(value = "api/bike/exec", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String excelUpload(@RequestBody String jcson) throws IOException {
        System.out.println("inside api");
        String jsonDataArray[] = JsonDataToStringArray.get(jcson);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = objectMapper.readValue(jsonDataArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
        });
        System.out.println(list);
        model.inventory.Bikes obj = new model.inventory.Bikes();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            try {
                Map map = (Map) list.get(i);
<<<<<<< HEAD
                try {
                    obj.setModel(map.get("model").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setColor(map.get("color").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setEngineNumber(map.get("engineNumber").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setChasisNumber(map.get("chasisNumber").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setRegNo(map.get("regNo").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
                } catch (Exception e) {
                }
                try {
                    obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
                } catch (Exception e) {
                }
                try {
                    obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
                } catch (Exception e) {
                }
                try {
                    obj.setEntryDate(map.get("entryDate").toString());
                } catch (Exception e) {
                }
                try {
                    obj.setCreatedDate(new Date());
                } catch (Exception e) {
                }
=======
                try{obj.setModel(map.get("model").toString());}catch(Exception e){}
                try{obj.setColor(map.get("color").toString());}catch(Exception e){}
                try{obj.setEngineNumber(map.get("engineNumber").toString());}catch(Exception e){}
                try{obj.setChasisNumber(map.get("chasisNumber").toString());}catch(Exception e){}
                try{obj.setRegNo(map.get("regNo").toString());}catch(Exception e){}
                try{obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));}catch(Exception e){}
                try{obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));}catch(Exception e){}
                try{obj.setQuantity(Convert.toInt(map.get("quantity").toString()));}catch(Exception e){}
                try{obj.setEntryDate(map.get("entryDate").toString());}catch(Exception e){}
                try{obj.setCreatedDate(new Date());}catch(Exception e){}
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
//                try{obj.setUpdatedDate(new Date());}catch(Exception e){}
//                try{obj.setStatus("0");}catch(Exception e){}
                System.out.println(obj);
                msg = da.save(obj);
            } catch (Exception e) {
                msg = e.getMessage();
                return json.respondWithError(msg);
            }
        }

        System.out.println("message is" + msg);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Obtained Successfully", gson.toJson(da.getAll(" from Bikes")));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/bikes", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });

        model.inventory.Bikes obj = new model.inventory.Bikes();
//obj.setSn(Convert.toInt(map.get("sn").toString()));
        obj.setModel(map.get("model").toString());
        obj.setColor(map.get("color").toString());
        obj.setEngineNumber(map.get("engineNumber").toString());
        obj.setChasisNumber(map.get("chasisNumber").toString());
        obj.setRegNo(map.get("regNo").toString());
        obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
        obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
        obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
        obj.setEntryDate(map.get("entryDate").toString());
//        obj.setStatus(map.get("status").toString());
        obj.setCreatedDate(new Date());
        obj.setUpdatedDate(null);

        msg = da.save(obj);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Obtained Successfully", gson.toJson(da.getAll(" from Bikes")));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/bikes/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson, @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.inventory.Bikes obj = new model.inventory.Bikes();
            obj.setSn(Convert.toInt(sn));
            obj.setModel(map.get("model").toString());
            obj.setColor(map.get("color").toString());
            obj.setEngineNumber(map.get("engineNumber").toString());
            obj.setChasisNumber(map.get("chasisNumber").toString());
            obj.setRegNo(map.get("regNo").toString());
            obj.setCostPrice(Convert.toFloat(map.get("costPrice").toString()));
            obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
<<<<<<< HEAD
            obj.setSellingPrice(Convert.toFloat(map.get("sellingPrice").toString()));
=======
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
            obj.setEntryDate(map.get("entryDate").toString());
            obj.setUpdatedDate(new Date());

            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Bike Updated successfully", gson.toJson(da.getAll(" from Bikes")));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/inventory/bikes/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM bikes WHERE SN IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Bike Deleted successfully", gson.toJson(da.getAll(" from Bikes")));
        } else {
            return json.respondWithError(msg);
        }
    }
}
