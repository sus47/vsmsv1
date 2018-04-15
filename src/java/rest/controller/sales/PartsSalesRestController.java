/*
return "\n{\"sn\": \""+sn+"\",\"customerId\": \""+customerId+"\",\"partsId\": \""+partsId+"\",\"price\": \""+price+"\",\"quantity\": \""+quantity+"\",\"soldBy\": \""+soldBy+"\",\"soldDate\": \""+soldDate+"\",\"discount\": \""+discount+"\",\"invoice\": \""+invoice+"\"}";
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
public class PartsSalesRestController {

    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.sales.DaoPartsSales da = new dao.sales.DaoImpPartsSales();
    ApiBaseController json = new ApiBaseController();
    String msg = "";

    @RequestMapping(value = "api/sales/partssales", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", da.getAll("from PartsSales"));
    }

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    @RequestMapping(value = "api/sales/latestCustomerId", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String customer() {
        String customer = "SELECT CUS_ID as customerId FROM invoice WHERE substr(CUS_ID,5,10)= (SELECT MAX(SUBSTR(CUS_ID,5,10)) FROM invoice)";
        List list = new DB().getRecord(customer);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/latestPartInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String partInvoice() {
        String invoice = "SELECT PART_INV as partsInvoice FROM invoice WHERE substr(PART_INV,5,10)= (SELECT MAX(SUBSTR(PART_INV,5,10)) FROM invoice)";
        List list = new DB().getRecord(invoice);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/latestServiceInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String servInvoice() {
        String invoice = "SELECT SERVICE_INV as serviceInvoice FROM invoice WHERE substr(SERVICE_INV,5,10)= (SELECT MAX(SUBSTR(SERVICE_INV,5,10)) FROM invoice)";
        List list = new DB().getRecord(invoice);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/partssales", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        System.out.println("data:" + jcson);
        String bikeId = "", partsId = "", address = "", customerId = "", customerName = "", phone = "",  invoice = "";
        String model = "", sellingPrice = "", quantity = "", price = "", cusType = "", netTotal = "", orgType = "";
        String total = "", serviceType = "", serviceTimes = "", isService = "";
        int pan=0, vat=0; 
        float advance = 0,discount = 0,dueAmount =0;
        String sql = "", sqlPartSale = "", sqlBill = "", partUpdate = "", sqlLedger = "", inv = "", remarks = "";
        try {
            System.out.println("inside try");
            String jcsonArray[] = cvt.ConvertJsonArrayToString.convert(jcson);

            Map<String, Object> map = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(jcsonArray[0], new TypeReference<Map<String, String>>() {
            });
            System.out.println("getting data");
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
                pan = (Convert.toInt(map.get("panNumber").toString()));
            } catch (Exception e) {
            }

            try {
                invoice = (map.get("invoiceNumber").toString());
            } catch (Exception e) {
            }
            try {
                cusType = (map.get("cusType").toString());
            } catch (Exception e) {
            }
            try {
                dueAmount = Convert.toFloat(map.get("dueAmount").toString());
            } catch (Exception e) {
            }
            try {
                netTotal = map.get("netTotal").toString();
            } catch (Exception e) {
            }
            try {
                advance = Convert.toFloat(map.get("advance").toString());
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
                vat = Convert.toInt(map.get("vat").toString());
            } catch (Exception e) {
            }
//            try{isService = map.get("isService").toString();}catch(Exception e){}
            try {
                serviceType = map.get("serviceType").toString();
            } catch (Exception e) {
            }
            try {
                serviceTimes = map.get("serviceTimes").toString();
            } catch (Exception e) {
            }
            if (serviceType.equals("F") ){
                switch (serviceTimes) {
                    case "1":
                        remarks = "First Free Servicing";
                        break;
                    case "2":
                        remarks = "Second Free Servicing";
                        break;
                    case "3":
                        remarks = "Third Free Servicing";
                        break;
                    case "4":
                        remarks = "Fourth Free Servicing";
                        break;
                    case "5":
                        remarks = "Fifth Free Servicing";
                        break;
                    case "6":
                        remarks = "Sixth Free Servicing";
                        break;
                    case "7":
                        remarks = "Seventh Free Servicing";
                        break;
                    case "8":
                        remarks = "Eighth Free Servicing";
                        break;
                    case "9":
                        remarks = "Nineth Free Servicing";
                        break;
                    case "10":
                        remarks = "Tenth Free Servicing";
                        break;
                    case "11":
                        remarks = "Eleventh Free Servicing";
                        break;
                    case "12":
                        remarks = "Twelvth Free Servicing";
                        break;
                    case "13":
                        remarks = "Thirteenth Free Servicing";
                        break;
                    default:
                        remarks="Invalid Entry";
                        break;
                }
            }
            
//            if(isService=="N"){
            if (serviceType == "N") {
                System.out.println("inside servicetype no");
                inv = "INSERT INTO `invoice`(`SERVICE_INV`,`CUS_ID`,`CREATED_DATE`) VALUES ('" + invoice + "','" + customerId + "',now())";
            } else {
                inv = "INSERT INTO `invoice`(`SERVICE_INV`,`CUS_ID`,`CREATED_DATE`) VALUES ('" + invoice + "','" + customerId + "',now())";
                sql = "INSERT INTO servicing_info(`CUSTOMER_ID`, `SERVICED_DATE`, `SERVICING_DATE`, `REMARKS`, SERVICING_TYPE, SERVICING_COUNT,CREATED_DATE) VALUES('" + customerId + "',now(),DATE_ADD(DATE_FORMAT(SYSDATE(),'%Y-%m-%d'), INTERVAL 3 MONTH),'" + remarks + "','" + serviceType + "','" + serviceTimes + "',now())";
                msg = General.update(sql);
                System.out.println(msg);
            }
            msg = General.update(inv);
            System.out.println(msg);

            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });

            System.out.println(list);
            System.out.println("size of list is:" + list.size());

            for (int i = 0; i < list.size(); i++) {
                sql = "INSERT INTO customers(`CUS_ID`, `NAME`, `ADDRESS`, `PHONE`, `PAN`, `BIKES_ID`,`PARTS_ID`, `INVOICE`,`CREATED_DATE`) VALUES";
                sqlPartSale = "INSERT INTO parts_sales(`CUSTOMER_ID`, `BIKE_ID`, `PARTS_ID`, `PRICE`, `QUANTITY`, `SOLD_BY`, `SOLD_DATE`, `DISCOUNT`, `INVOICE`, `CREATED_DATE`) VALUES ";
                partUpdate = "UPDATE parts SET ";
                Object object = list.get(i);
                System.out.println(object);
                try {
                    Map row = (Map) object;

                    try {
                        partsId = row.get("sn").toString();
                        System.out.println(partsId);
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
                        System.out.println("model is :" + e.getMessage());
                    }
                    try {
                        discount = Convert.toFloat(row.get("discount").toString());
                        System.out.println(discount);
                    } catch (Exception e) {
                    }

                   

                    sql += " ('" + customerId + "','" + customerName + "','" + address + "','" + phone + "'," + pan + ",(SELECT BIKE_ID FROM parts WHERE SN=" + partsId + ")," + partsId + ",'" + invoice + "', now())";

                    sqlPartSale += "('" + customerId + "',(SELECT BIKE_ID FROM parts WHERE SN=" + partsId + ")," + partsId + "," + price + "," + quantity + ",'admin',now()," + discount + ",'" + invoice + "',now())";
                    partUpdate += "QUANTITY=QUANTITY-" + quantity + ", UPDATED_DATE=now() WHERE SN=" + partsId + "";

                    if (serviceType == "N") {
                        sqlBill = "INSERT INTO bills(`ADDRESS`, `ADVANCE`,`BIKE_ID`,`PARTS_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`, `DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`, `TOTAL`) VALUES ";
                        sqlBill += "('" + address + "'," + advance + ",(SELECT BIKE_ID FROM parts WHERE SN=" + partsId + ")," + partsId + ",now(),'" + customerId + "','" + customerName + "'," + discount + "," + dueAmount + ",'" + invoice + "'," + netTotal + ",'" + orgType + "'," + pan + ",'" + phone + "'," + quantity + "," + sellingPrice + "," + vat + "," + total + ")";
                    } else {
                        sqlBill = "INSERT INTO bills(`SERVICE_BILL`,`SERVICE_TIMES`,`SERVICE_TYPE`,`ADDRESS`, `ADVANCE`,`BIKE_ID`,`PARTS_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`,`DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`, `TOTAL`) VALUES ";
                        sqlBill += "('" + serviceType + "','" + serviceTimes + "','" + serviceType + "','" + address + "'," + advance + ",(SELECT BIKE_ID FROM parts WHERE SN=" + partsId + ")," + partsId + ",now(),'" + customerId + "','" + customerName + "'," + discount + "," + dueAmount + ",'" + invoice + "'," + netTotal + ",'" + orgType + "'," + pan + ",'" + phone + "'," + quantity + "," + sellingPrice + "," + vat + "," + total + ")";
                    }
                    msg = General.update(sql);
                    System.out.println(msg);
                    msg = General.update(sqlPartSale);
                    System.out.println(msg);
                    msg = General.update(partUpdate);
                    System.out.println(msg);
                    msg = General.update(sqlBill);
                    System.out.println(msg);
                } catch (Exception e) {
                    msg = e.getMessage();
                    return json.respondWithError(msg);
                }
            }

        } catch (Exception e) {
            msg = e.getMessage();
            return json.respondWithError(msg);
        }
        return json.respondWithMessage(msg);
    }

    @RequestMapping(value = "api/sales/partssales/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM PartsSalesWHERE sn IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", da.getAll(" from PartsSales"));
        } else {
            return json.respondWithError(msg);
        }
    }
}
