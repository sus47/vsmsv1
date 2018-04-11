/*
return "\n{\"sn\": \""+sn+"\",\"customerId\": \""+customerId+"\",\"bikesId\": \""+bikesId+"\",\"quantity\": \""+quantity+"\",\"price\": \""+price+"\",\"soldDate\": \""+soldDate+"\",\"soldBy\": \""+soldBy+"\",\"discount\": \""+discount+"\"}";
 */
package rest.controller.sales;

import cvt.Convert;
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
public class BikesSalesRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.sales.DaoBikesSales da = new dao.sales.DaoImpBikesSales();
    ApiBaseController json = new ApiBaseController();
    String msg = "";

    @RequestMapping(value = "api/sales/bikessales", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", da.getAll("from BikesSales"));
    }

    @RequestMapping(value = "api/sales/bikessales", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

//        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
//        });
        System.out.println(jcson);
        String bikeId = "", address = "", customerId = "", customerName = "", phone = "", pan = "", invoice = "";
        String sql = "",sqlBikeSale="",sqlBill="", updateSql = "";
        try {
            String jcsonArray[] = cvt.ConvertJsonArrayToString.convert(jcson);

            Map<String, Object> map = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(jcsonArray[0], new TypeReference<Map<String, String>>() {
            });

            dao.customer.DaoCustomers dac = new dao.customer.DaoImpCustomers();
            model.customer.Customers cus = new model.customer.Customers();
            customerId = (map.get("customerId").toString());
            customerName = (map.get("customerName").toString());
            address = (map.get("address").toString());
            phone = (map.get("phone").toString());
            pan = (map.get("panNumber").toString());

            invoice = (map.get("invoiceNumber").toString());

            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });
            System.out.println(list);

            for (int i = 0; i < list.size(); i++) {
                sql = "INSERT INTO `customers`(`CUS_ID`, `NAME`, `ADDRESS`, `PHONE`, `PAN`, `BIKES_ID`, `INVOICE`,`CREATED_DATE`) VALUES";
                sqlBikeSale = "INSERT INTO `bikes_sales`(`BIKE_ID`, `CUSTOMER_ID`, `DISCOUNT`, `INVOICE`, `PRICE`, `QUANTITY`, `SOLD_BY`, `SOLD_DATE`, `CREATED_DATE`) VALUES";
                sqlBill ="";
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
                    sql += " ('" + customerId + "','" + customerName + "','" + address + "','" + phone + "'," + pan + "," + bikeId + ",'" + invoice + "', now())";

                    msg = General.update(sql);

                } catch (Exception e) {
                    msg = e.getMessage();
                    return json.respondWithError(msg);
                }
            }
//        model.sales.BikesSales obj = new model.sales.BikesSales();
//        /*obj.setSn(map.get("sn").toString()); */
//        obj.setCustomerId(map.get("customerId").toString());
//        obj.setBikeId(Convert.toInt(map.get("bikesId").toString()));
//        obj.setQuantity(Convert.toInt(map.get("quantity").toString()));
//        obj.setPrice(Convert.toFloat(map.get("price").toString()));
//        obj.setSoldDate(Convert.toDate(map.get("soldDate").toString()));
//        obj.setSoldBy("admin");
//        obj.setDiscount(Convert.toFloat(map.get("discount").toString()));
//
//        msg = da.save(obj);
//
//        model.bills.Bills bill = new model.bills.Bills();
//        dao.bills.DaoBills dab = new dao.bills.DaoImpBills();
//        bill.setCusId(map.get("cusId").toString());
//        bill.setCusName(map.get("cusName").toString());
//        bill.setAddress(map.get("address").toString());
//        bill.setPhone(map.get("phone").toString());
//        bill.setOrgType(map.get("orgType").toString());
//        bill.setCusType(map.get("cusType").toString());
//        bill.setServiceBill(map.get("serviceBill").toString());
//        bill.setPanNo(Convert.toInt(map.get("panNo").toString()));
//        bill.setServiceTimes(map.get("serviceTimes").toString());
//        bill.setServiceType(map.get("serviceType").toString());
//        bill.setInvoice(map.get("invoice").toString());
//        bill.setBikeId(Convert.toInt(map.get("bikeId").toString()));
//        bill.setQuantity(Convert.toInt(map.get("quantity").toString()));
//        bill.setDiscount(Convert.toFloat(map.get("discount").toString()));
//        bill.setTotalSp(Convert.toFloat(map.get("totalSp").toString()));
//        bill.setVat(Convert.toFloat(map.get("vat").toString()));
//        bill.setNetTotal(Convert.toFloat(map.get("netTotal").toString()));
//        bill.setAdvance(Convert.toFloat(map.get("advance").toString()));
//        bill.setDue(Convert.toFloat(map.get("due").toString()));
//        bill.setCreatedDate(Convert.toDate(map.get("createdDate").toString()));
//        
//        msg = dab.save(bill);
//        if (msg.equalsIgnoreCase("Saved")) {
//            return json.respondWithMessage("Success", da.getAll(" from BikesSales"));
//        } catch (Exception e) {
        } catch (Exception e) {
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/sales/bikessales/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson,
            @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.sales.BikesSales obj = new model.sales.BikesSales();
            /*obj.setSn(map.get("sn").toString());
obj.setCustomerId(map.get("customerId").toString());
obj.setBikesId(map.get("bikesId").toString());
obj.setQuantity(map.get("quantity").toString());
obj.setPrice(map.get("price").toString());
obj.setSoldDate(map.get("soldDate").toString());
obj.setSoldBy(map.get("soldBy").toString());
obj.setDiscount(map.get("discount").toString());
             */
            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Updated successfully", da.getAll(" from BikesSales"));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/sales/bikessales/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn
    ) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM BikesSalesWHERE sn IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", da.getAll(" from BikesSales"));
        } else {
            return json.respondWithError(msg);
        }
    }
}
