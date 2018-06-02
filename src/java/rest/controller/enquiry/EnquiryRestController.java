/*
return "\n{\"sn\": \""+sn+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"title\": \""+title+"\",\"description\": \""+description+"\",\"officer\": \""+officer+"\",\"date\": \""+date+"\"}";
 */
package rest.controller.enquiry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import dao.General;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
public class EnquiryRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.enquiry.DaoEnquiry da = new dao.enquiry.DaoImpEnquiry();
    ApiBaseController json = new ApiBaseController();
    String msg = "";
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/enquiry/enquiry", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", gson.toJson(da.getAll("from Enquiry")));
    }

    @RequestMapping(value = "api/report/daily_report", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getReportOne() {
        Double labourCharge = 0.0;
        String sql = "SELECT ITEM_NAME itemSold, SELLING_PRICE sellingPrice,PURCHASE_PRICE purchasePrice,PROFIT profit FROM daily_sales_report WHERE CREATED_DATE = DATE_FORMAT(now(), \"%Y-%m-%d\");";
        List list = new DB().getRecord(sql);
        System.out.println(list);
        sql = "SELECT SUM(LABOUR_CHARGE) labourCharge FROM daily_sales_report WHERE CREATED_DATE = DATE_FORMAT(now(), '%Y-%m-%d')";
        List lC = new DB().getRecord(sql);
        Map mapper = (Map) lC.get(0);
        try {
            labourCharge = Convert.toDouble(mapper.get("labourCharge").toString());
        } catch (Exception e) {

        }
        System.out.println(list);
        return json.respondWithMessage("Success", gson.toJson(list) + ",\"labourCharge\":" + labourCharge);
    }

    @RequestMapping(value = "api/report/monthly_report", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getTimelyReport(HttpServletRequest request) throws ParseException {
        SimpleDateFormat ind = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat oud = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = ind.parse(request.getParameter("fromDate"));
        String outFromDate = oud.format(fromDate);
        Date toDate = ind.parse(request.getParameter("toDate"));
        String outToDate = oud.format(toDate);
        String sql = "SELECT ITEM_NAME itemSold, SELLING_PRICE sellingPrice,PURCHASE_PRICE purchasePrice,PROFIT profit FROM daily_sales_report WHERE CREATED_DATE BETWEEN '" + outFromDate + "' AND '" + outToDate + "'";
        System.out.println(sql);
        List list = new DB().getRecord(sql);
        System.out.println(list);
        sql = "SELECT SUM(LABOUR_CHARGE) labourCharge FROM daily_sales_report WHERE CREATED_DATE BETWEEN '" + outFromDate + "' AND '" + outToDate + "'";
        List lC = new DB().getRecord(sql);
        Map mapper = (Map) lC.get(0);
        Double labourCharge = Convert.toDouble(mapper.get("labourCharge").toString());
        System.out.println(list);
        return json.respondWithMessage("Success", gson.toJson(list) + ",\"labourCharge\":" + labourCharge);
    }

    @RequestMapping(value = "api/enquiry/enquiry", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });

        model.enquiry.Enquiry obj = new model.enquiry.Enquiry();
        /*obj.setSn(map.get("sn").toString());*/
        obj.setName(map.get("name").toString());
        obj.setAddress(map.get("address").toString());
        obj.setPhone(Convert.toInt(map.get("phone").toString()));
        obj.setTitle(map.get("title").toString());
        obj.setDescription(map.get("description").toString());
        obj.setEnquiryOfficer(map.get("enquiryOfficer").toString());
        obj.setDate(new Date());

        msg = da.save(obj);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Success", gson.toJson(da.getAll(" from Enquiry")));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/enquiry/enquiry/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson, @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });
            model.enquiry.Enquiry obj = new model.enquiry.Enquiry();
            obj.setSn(Convert.toInt(sn));
            obj.setName(map.get("name").toString());
            obj.setAddress(map.get("address").toString());
            obj.setPhone(Convert.toInt(map.get("phone").toString()));
            obj.setTitle(map.get("title").toString());
            obj.setDescription(map.get("description").toString());
            obj.setEnquiryOfficer(map.get("enquiryOfficer").toString());
            obj.setDate(new Date());

            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Updated successfully", gson.toJson(da.getAll(" from Enquiry")));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/enquiry/enquiry/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM enquiry WHERE SN IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", gson.toJson(da.getAll(" from Enquiry")));
        } else {
            return json.respondWithError(msg);
        }
    }
}
