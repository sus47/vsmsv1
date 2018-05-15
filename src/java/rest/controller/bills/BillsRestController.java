/*
return "\n{\"sn\": \""+sn+"\",\"cusId\": \""+cusId+"\",\"cusName\": \""+cusName+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"orgType\": \""+orgType+"\",\"cusType\": \""+cusType+"\",\"serviceBill\": \""+serviceBill+"\",\"panNo\": \""+panNo+"\",\"serviceTimes\": \""+serviceTimes+"\",\"serviceType\": \""+serviceType+"\",\"invoice\": \""+invoice+"\",\"bikeId\": \""+bikeId+"\",\"quantity\": \""+quantity+"\",\"discount\": \""+discount+"\",\"totalSp\": \""+totalSp+"\",\"vat\": \""+vat+"\",\"netTotal\": \""+netTotal+"\",\"advance\": \""+advance+"\",\"due\": \""+due+"\",\"createdDate\": \""+createdDate+"\"}";
 */
package rest.controller.bills;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.DB;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    dao.bills.DaoBills da = new dao.bills.DaoImpBills();
    ApiBaseController json = new ApiBaseController();
    String msg = "", sql = "";
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    DB db = new DB();

    @RequestMapping(value = "api/bills/bills", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", gson.toJson(da.getAll("from Bills GROUP BY INVOICE")));
    }

    @RequestMapping(value = "api/bills/view", method = RequestMethod.GET, produces = "application/json")
    public String view(@RequestParam(value = "invoice", required = true) String invoice, HttpServletRequest request, ModelMap map) throws UnknownHostException {
        dao.bills.DaoBills da = new dao.bills.DaoImpBills();
        List bill = da.getAll("from Bills where INVOICE ='" + invoice + "' GROUP BY INVOICE");
        String sql = "SELECT (CASE "
                + "WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect ENGINE_NUMBER from bikes where SN=BI.BIKE_ID) "
                + "WHEN (SUBSTR(INVOICE,1,4)=('INVP' || 'INVS')) THEN (SELect PARTS_NUMBER from parts where SN=BI.PARTS_ID) "
                + "ELSE NULL "
                + "END "
                + ") as code, "
                + "(CASE "
                + "WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect MODEL from bikes where SN=BI.BIKE_ID) "
                + "WHEN (SUBSTR(INVOICE,1,4)=('INVP' || 'INVS')) THEN (SELect NAME from parts where SN=BI.PARTS_ID) "
                + "ELSE NULL "
                + "END "
                + ") as description,"
                + "BI.`QUANTITY` as quantity,"
                + "(CASE "
                + "WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect `SELLING_PRICE` from bikes where SN=BI.BIKE_ID) "
                + "WHEN (SUBSTR(INVOICE,1,4)=('INVP' || 'INVS')) THEN (SELect `SELLING_PRICE` from parts where SN=BI.PARTS_ID) "
                + "ELSE NULL "
                + "END "
                + ") as rate, "
                + "BI.`DISCOUNT` as discount, "
                + "BI.`TOTAL_SP` as totalSp "
                + "from bills BI, bikes B where B.`SN` = BI.`BIKE_ID` AND BI.`INVOICE`='" + invoice + "'";
        System.out.println(sql);
        List billData = db.getRecord(sql);
        map.addAttribute("data", billData);
        System.out.println(bill);
        map.addAttribute("billData", bill);
        int port = request.getServerPort();
        InetAddress IP = InetAddress.getLocalHost();
        System.out.println(IP);
        return json.respondWithMessage("Success", gson.toJson("http://" + IP.getHostAddress() + ":" + port + "/VSMS/Bills/View?invoice=" + invoice + ""));
    }

    @RequestMapping(value = "api/notification/order", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String order() {
        try {
            String order = "SELECT * FROM parts WHERE QUANTITY<=THRESHOLD";
            System.out.println(order);
            List orders = db.getRecord(order);
            return json.respondWithMessage("Success", gson.toJson(orders));
        } catch (Exception e) {
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
    }

    @RequestMapping(value = "api/notification/service", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String service() {
        try {
            String service = "SELECT C.`NAME` customerName, C.PHONE phone, B.MODEL bikeModel,S.`SERVICING_DATE` servicingDate,(-DATEDIFF(SYSDATE(),S.SERVICING_DATE)) AS remainingDays FROM servicing_info S,customers C, bikes B WHERE S.`CUSTOMER_ID`=C.`CUS_ID` AND C.`BIKES_ID`= B.`SN` AND (-DATEDIFF(SYSDATE(),SERVICING_DATE))<=7";
            System.out.println(service);
            List services = db.getRecord(service);
            return json.respondWithMessage("Success", gson.toJson(services));
        } catch (Exception e) {
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
    }

    @RequestMapping(value = "api/bills/bills", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });

        model.bills.Bills obj = new model.bills.Bills();
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

        msg = da.save(obj);
        if (msg.equalsIgnoreCase("Saved")) {
            return json.respondWithMessage("Success", da.getAll(" from Bills"));
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/bills/bills/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson,
            @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.bills.Bills obj = new model.bills.Bills();
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
<<<<<<< HEAD
             */
            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Updated successfully", da.getAll(" from Bills"));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/bills/bills/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn
    ) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM bills WHERE sn IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", da.getAll(" from Bills"));
        } else {
            return json.respondWithError(msg);
        }
    }
}

