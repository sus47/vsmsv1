/*
return "\n{\"sn\": \""+sn+"\",\"customerId\": \""+customerId+"\",\"bikesId\": \""+bikesId+"\",\"quantity\": \""+quantity+"\",\"price\": \""+price+"\",\"soldDate\": \""+soldDate+"\",\"soldBy\": \""+soldBy+"\",\"discount\": \""+discount+"\"}";
 */
package rest.controller.sales;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvt.Convert;
import dao.General;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/sales/latestBikeInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String invoice() {
        String invoice = "SELECT CASE WHEN ((select count(*) FROM invoice)>0) THEN (select concat(substr(INV,1,3),(CAST(substr(INV,4,10) AS INT)+1)) "
                + " FROM invoice WHERE substr(INV,4,10)= (SELECT MAX(CAST(SUBSTR(INV,4,10) AS int)) FROM invoice) )"
                + " ELSE 'INV1' END as bikeInvoice;";

        List list = new DB().getRecord(invoice);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/latestCustomerInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String customer() {

        String sql ="SELECT CASE WHEN ((select count(*) FROM invoice)>0) THEN (select concat(substr(CUS_ID,1,3),(CAST(substr(CUS_ID,4,10) AS INT)+1)) "
                + " FROM invoice WHERE substr(CUS_ID,4,10)= (SELECT MAX(CAST(SUBSTR(CUS_ID,4,10) AS int)) FROM invoice) )"
                + " ELSE 'CUS1' END as customerId;"; 
        List list = new DB().getRecord(sql);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/bikessales", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

//        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
//        });
        System.out.println("inside bikesales:" + jcson);
        String bikeId = "", address = "", customerId = "", customerName = "", phone = "", invoice = "";
        double advance = 0.0, dueAmount = 0.0, discount = 0.0, vat = 0.0;
        int pan = 0;
        String model = "", sellingPrice = "", quantity = "", price = "", netTotal = "", orgType = "";
        String total = "";

        String sql = "", sqlBikeSale = "", sqlBill = "", bikeUpdate = "", sqlLedger = "";
        try {
            String jcsonArray[] = cvt.ConvertJsonArrayToString.convert(jcson);
            System.out.println("inside try");
            Map<String, Object> map = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(jcsonArray[0], new TypeReference<Map<String, String>>() {
            });

            dao.consumer.DaoCustomers dac = new dao.consumer.DaoImpCustomers();
            model.consumer.Customers cus = new model.consumer.Customers();
            try {
                customerId = (map.get("customerId").toString());
            } catch (Exception e) {
            }
            try {
                customerName = (map.get("customerName").toString());
            } catch (Exception e) {
            }
            try {
                address = (map.get("address").toString());
            } catch (Exception e) {
            }
            try {
                phone = (map.get("phone").toString());
            } catch (Exception e) {
            }
            try {
                pan = Convert.toInt(map.get("panNumber").toString());
                System.out.println(pan);
            } catch (Exception e) {
            }

            try {
                invoice = (map.get("invoiceNumber").toString());
            } catch (Exception e) {
            }

            try {
                dueAmount = Convert.toDouble(map.get("dueAmount").toString());
            } catch (Exception e) {
            }
            try {
                netTotal = map.get("netTotal").toString();
            } catch (Exception e) {
            }
            try {
                advance = Convert.toDouble(map.get("advance").toString());
            } catch (Exception e) {
            }
            try {
                orgType = map.get("orgType").toString();
            } catch (Exception e) {
            }
            try {
                total = map.get("total").toString();
            } catch (Exception e) {
            }
            try {
                vat = Convert.toDouble(map.get("vat").toString());
            } catch (Exception e) {
            }
            String inv = "INSERT INTO `invoice`(`INV`,`CUS_ID`,`CREATED_DATE`) VALUES (UPPER('" + invoice + "'),UPPER('" + customerId + "'),now())";
            msg = General.update(inv);
            System.out.println(msg);

            String led = "INSERT INTO `ledger`(`CUS_ID`, `DESCRIPTION`, `DEBIT`, `CREDIT`, `CREATED_DATE`) VALUES (UPPER('" + customerId + "'),'Bike Purchase'," + advance + "," + dueAmount + ", now())";
            msg = General.update(led);
            System.out.println(msg);
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });

            System.out.println("list:" + list);
            System.out.println("size of list is:" + list.size());

            for (int i = 0; i < list.size(); i++) {
                sql = "INSERT INTO customers(`CUS_ID`, `NAME`, `ADDRESS`, `PHONE`, `PAN`, `BIKES_ID`, `INVOICE`,`CREATED_DATE`) VALUES";
                sqlBikeSale = "INSERT INTO bikes_sales(`BIKE_ID`, `CUSTOMER_ID`, `DISCOUNT`, `INVOICE`, `PRICE`, `QUANTITY`, `SOLD_BY`, `SOLD_DATE`, `CREATED_DATE`) VALUES";
                bikeUpdate = "UPDATE bikes SET ";
                sqlBill = "INSERT INTO bills(`ADDRESS`, `ADVANCE`, `BIKE_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`, `DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`, `TOTAL`) VALUES ";
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
                        sellingPrice = row.get("sellingPrice").toString();
                        System.out.println(sellingPrice);
                    } catch (Exception e) {
                    }
                    try {
                        quantity = row.get("quantity").toString();
                        System.out.println(quantity);
                    } catch (Exception e) {
                    }
                    try {
                        price = row.get("price").toString();
                        System.out.println(price);
                    } catch (Exception e) {
                    }
                    try {
                        model = row.get("model").toString();
                        System.out.println(model);
                    } catch (Exception e) {
                    }
                    try {
                        discount = Convert.toDouble(row.get("discount").toString());
                        System.out.println(discount);
                    } catch (Exception e) {
                    }
                    sql += " (UPPER('" + customerId + "'),'" + customerName + "','" + address + "','" + phone + "'," + pan + "," + bikeId + ",'" + invoice + "', now())";

                    sqlBikeSale += "(" + bikeId + ",UPPER('" + customerId + "')," + discount + ",'" + invoice + "'," + price + "," + quantity + ",'admin',now(),now())";
                    bikeUpdate += "QUANTITY=QUANTITY-" + quantity + ", UPDATED_DATE=now() WHERE SN=" + bikeId + "";
                    sqlBill += "('" + address + "'," + advance + "," + bikeId + ",now(),UPPER('" + customerId + "'),'" + customerName + "'," + discount + "," + dueAmount + ",'" + invoice + "'," + netTotal + ",'" + orgType + "'," + pan + ",'" + phone + "'," + quantity + "," + sellingPrice + "," + vat + "," + total + ")";
                    msg = General.update(sql);
                    System.out.println(msg);

                    msg = General.update(sqlBikeSale);
                    System.out.println(msg);
                    msg = General.update(bikeUpdate);
                    System.out.println(msg);
                    msg = General.update(sqlBill);
                    System.out.println(msg);

                    String servicing = "INSERT INTO `servicing_info`(`CUSTOMER_ID`, `SERVICING_DATE`, `REMARKS`, `CREATED_DATE`) VALUES (UPPER('" + customerId + "'),DATE_ADD(DATE_FORMAT(SYSDATE(),'%Y-%m-%d'), INTERVAL 20 DAY),'Bike Purchased',now())";
                    msg = General.update(servicing);
                } catch (Exception e) {
                    msg = e.getMessage();
                    return json.respondWithError(msg);
                }
            }

        } catch (Exception e) {
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
        return json.respondWithMessage("Successfully Sold!");
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
        String sql = "DELETE FROM bikes_sales WHERE SN IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", gson.toJson(da.getAll(" from BikesSales")));
        } else {
            return json.respondWithError(msg);
        }
    }
}
