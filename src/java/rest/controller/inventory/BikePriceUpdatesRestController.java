/*
return "\n{\"sn\": \""+sn+"\",\"bikeId\": \""+bikeId+"\",\"oldPrice\": \""+oldPrice+"\",\"newPrice\": \""+newPrice+"\",\"updatedDate\": \""+updatedDate+"\"}";
 */
package rest.controller.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import dao.General;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
public class BikePriceUpdatesRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.inventory.DaoBikePriceUpdates da = new dao.inventory.DaoImpBikePriceUpdates();
    ApiBaseController json = new ApiBaseController();
    String msg = "";
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/inventory/bikepriceupdates", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {
        System.out.println(jcson);
        String bikeId = "", oldPrice = "", newPrice = "";
        String sql = "", updateSql = "";
        try{
        String jcsonArray[] = cvt.ConvertJsonArrayToString.convert(jcson);

        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(jcsonArray[0], new TypeReference<Map<String, String>>() {
        });
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
        });
        System.out.println(list);
        System.out.println("size of list is: "+list.size());

        for (int i = 0; i < list.size(); i++) {
            sql = "insert into bike_price_updates (BIKE_ID, NEW_PRICE, OLD_PRICE, UPDATED_DATE) values";
            updateSql = "UPDATE bikes SET ";

            Object object = list.get(i);
            System.out.println(object);
            try {
                Map row = (Map) object;

                try {
                    bikeId = row.get("sn").toString();
                    System.out.println(bikeId);
                } catch (Exception e) {
                }
                try {
                    oldPrice = row.get("oldPrice").toString();
                    System.out.println(oldPrice);
                } catch (Exception e) {
                }
                try {
                    newPrice = row.get("newPrice").toString();
                    System.out.println(newPrice);
                } catch (Exception e) {
                }

            } catch (Exception Ex) {
            }
            sql += " (" + bikeId + "," + newPrice + "," + oldPrice + ", now())";
            updateSql += "SELLING_PRICE=" + newPrice + ", UPDATED_DATE= now() WHERE SN = " + bikeId + "";
            System.out.println(sql);

            msg = General.update(sql);
            System.out.println(msg);
            msg = General.update(updateSql);
            System.out.println(msg);
        }
        }catch(Exception e){
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
        if (msg.indexOf("Updated") > 0) {
            msg.replaceAll("updated", "saved");
            return json.respondWithMessage("Success", gson.toJson(da.getAll(" from BikePriceUpdates")));
        }
        return json.respondWithError(msg);
    }

}
