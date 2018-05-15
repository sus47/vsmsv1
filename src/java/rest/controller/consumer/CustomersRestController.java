/*
return "\n{\"id\": \""+id+"\",\"cusId\": \""+cusId+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"pan\": \""+pan+"\",\"bikesId\": \""+bikesId+"\",\"partsId\": \""+partsId+"\",\"invoice\": \""+invoice+"\",\"createdDate\": \""+createdDate+"\"}";
 */
package rest.controller.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
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
public class CustomersRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.consumer.DaoCustomers da = new dao.consumer.DaoImpCustomers();
    ApiBaseController json = new ApiBaseController();
    String msg = "";

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/consumer/customer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", gson.toJson(da.getAll("from Customers")));
    }

    @RequestMapping(value = "api/customer/exc", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String excelUpload(@RequestBody String jcson) throws IOException {
        System.out.println("inside api");
        String jsonDataArray[] = JsonDataToStringArray.get(jcson);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = objectMapper.readValue(jsonDataArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
        });
        System.out.println(list);
        model.consumer.Customers obj = new model.consumer.Customers();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            try {
                Map map = (Map) list.get(i);
                String cusType = "";
                cusType = map.get("customerType").toString();
                int pan = 0;
                if (cusType.equalsIgnoreCase("P")) {
                    try {
                        obj.setPan(pan);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {
                    try {
                        obj.setPan(Convert.toInt(map.get("panNumber").toString()));
                    } catch (Exception ex) {
                        return json.respondWithError(ex.getMessage());
                    }
                }
                obj.setCustomerType(cusType);
                obj.setCustomerId(map.get("customerId").toString());
                obj.setName(map.get("name").toString());
                obj.setAddress(map.get("address").toString());
                obj.setPhone(map.get("phone").toString());
                Date date = new Date();
                obj.setCreatedDate(date);

                msg = da.save(obj);
                
            } catch (Exception e) {
            }

        }
        System.out.println("message is"+msg);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Success", da.getAll(" from Customers"));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/consumer/customer", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });
        model.consumer.Customers obj = new model.consumer.Customers();
        String cusType = "";
        cusType = map.get("customerType").toString();
        int pan = 0;
        if (cusType == "P") {
            try {
                obj.setPan(pan);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            try {
                obj.setPan(Convert.toInt(map.get("panNumber").toString()));
            } catch (Exception ex) {

            }
        }
        obj.setCustomerType(cusType);
        obj.setCustomerId(map.get("customerId").toString());
        obj.setName(map.get("name").toString());
        obj.setAddress(map.get("address").toString());
        obj.setPhone(map.get("phone").toString());
        Date date = new Date();
        obj.setCreatedDate(date);

        msg = da.save(obj);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Success", da.getAll(" from Customers"));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/consumer/customer/{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson, @PathVariable String id) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.consumer.Customers obj = new model.consumer.Customers();
            /*obj.setId(map.get("id").toString());
obj.setCusId(map.get("cusId").toString());
obj.setName(map.get("name").toString());
obj.setAddress(map.get("address").toString());
obj.setPhone(map.get("phone").toString());
obj.setPan(map.get("pan").toString());
obj.setBikesId(map.get("bikesId").toString());
obj.setPartsId(map.get("partsId").toString());
obj.setInvoice(map.get("invoice").toString());
obj.setCreatedDate(map.get("createdDate").toString());
             */
            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Updated successfully", da.getAll(" from Customers"));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/consumer/customer/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String id) {
        id = id.replaceAll("\"", "'");
        String sql = "DELETE FROM customers WHERE ID IN " + id + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", da.getAll(" from Customers"));
        } else {
            return json.respondWithError(msg);
        }
    }
}
