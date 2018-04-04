/*
return "\n{\"sn\": \""+sn+"\",\"partsId\": \""+partsId+"\",\"oldPrice\": \""+oldPrice+"\",\"newPrice\": \""+newPrice+"\",\"updatedDate\": \""+updatedDate+"\"}";
 */
package rest.controller.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.General;
import java.io.IOException;
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
public class PartsPriceUpdatesRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.inventory.DaoPartsPriceUpdates da = new dao.inventory.DaoImpPartsPriceUpdates();
    ApiBaseController json = new ApiBaseController();
    String msg = "";
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/inventory/partspriceupdates", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", gson.toJson(da.getAll("from PartsPriceUpdates")));
    }

    @RequestMapping(value = "api/inventory/partspriceupdates", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {
        dao.inventory.DaoParts da = new dao.inventory.DaoImpParts();
        String partId = "", oldPrice = "", newPrice = "";
        String sql = "", updateSql = "";
        try{
        String jcsonArray[] = cvt.ConvertJsonArrayToString.convert(jcson);

        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(jcsonArray[0], new TypeReference<Map<String, String>>() {
        });
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = objectMapper.readValue(jcsonArray[0], new com.fasterxml.jackson.core.type.TypeReference<List>() {
        });
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            sql = "insert into parts_price_updates (PARTS_ID, NEW_PRICE, OLD_PRICE, UPDATED_DATE) values";
            updateSql = "UPDATE parts SET ";

            Object object = list.get(i);
            System.out.println(object);
            try {
                Map row = (Map) object;

                try {
                    partId = row.get("sn").toString();
                    System.out.println(partId);
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
            sql += " (" + partId + "," + newPrice + "," + oldPrice + ", now())";
            updateSql += "SELLING_PRICE=" + newPrice + ", UPDATED_DATE= now() WHERE SN = " + partId + "";
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
            return json.respondWithMessage("Success", gson.toJson(da.getAll(" from PartsPriceUpdates")));
        }
        return json.respondWithError(msg);
    }

}
