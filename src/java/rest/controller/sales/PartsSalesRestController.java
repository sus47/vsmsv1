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

    @RequestMapping(value = "api/sales/latestPartInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String partInvoice() {
        String invoice = "SELECT CASE WHEN ((select count(INV_P) FROM invoice)>0) THEN (select concat(substr(INV_P,1,4),(CAST(substr(INV_P,5,10) AS INT)+1)) "
                + " FROM invoice WHERE substr(INV_P,5,10)= (SELECT MAX(CAST(SUBSTR(INV_P,5,10) AS int)) FROM invoice) )"
                + " ELSE 'INVP1' END as partsInvoice;";
        List list = new DB().getRecord(invoice);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/latestServiceInvoice", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String servInvoice() {
        String invoice = "SELECT CASE WHEN ((select count(INV_S) FROM invoice)>0) THEN (select concat(substr(INV_S,1,4),(CAST(substr(INV_S,5,10) AS INT)+1)) "
                + " FROM invoice WHERE substr(INV_S,5,10)= (SELECT MAX(CAST(SUBSTR(INV_S,5,10) AS int)) FROM invoice) )"
                + " ELSE 'INVS1' END as serviceInvoice;";
        List list = new DB().getRecord(invoice);
        return json.respondWithMessage("Success", gson.toJson(list));
    }

    @RequestMapping(value = "api/sales/partssales", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        System.out.println("data:" + jcson);
        String address = "", customerId = "", customerName = "", phone = "", invoice = "";
        String model = "", sellingPrice = "", quantity = "", price = "", cusType = "", netTotal = "", orgType = "";
        String total = "", serviceType = "", serviceTimes = "", isService = "";
        int bikeId = 0, partsId = 0, pan = 0;
        float advance = 0, discount = 0, dueAmount = 0;
        Double vat = 0.0;
        Double labourCharge = 0.0;
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
                labourCharge = Convert.toDouble(map.get("labourCharge").toString());
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
                cusType = (map.get("customerType").toString());
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
                bikeId = Convert.toInt(map.get("bikeId").toString());
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
                vat = Convert.toDouble(map.get("vat").toString());
            } catch (Exception e) {
            }

            String led = "INSERT INTO `ledger`(`CUS_ID`, `DESCRIPTION`, `DEBIT`, `CREDIT`, `CREATED_DATE`) VALUES (UPPER('" + customerId + "'),'Parts Sold'," + advance + "," + dueAmount + ", now())";
            msg = General.update(led);
            System.out.println(msg);

            if (cusType.equalsIgnoreCase("n")) {
                inv = "INSERT INTO `invoice`(`INV_P`,`CUS_ID`,`CREATED_DATE`) VALUES (UPPER('" + invoice + "'),UPPER('" + customerId + "'),now())";
            } else {
                inv = "INSERT INTO `invoice`(`INV_P`,`CREATED_DATE`) VALUES (UPPER('" + invoice + "'),now())";

            }
            msg = General.update(inv);
            System.out.println(msg);

            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });

            System.out.println(list);
            System.out.println("size of list is:" + list.size());
            if (cusType.equalsIgnoreCase("n")) {
                sql = "INSERT INTO customers(`CUS_ID`, `NAME`, `ADDRESS`, `PHONE`, `PAN`, `BIKES_ID`,`PARTS_ID`, `INVOICE`,`CREATED_DATE`) VALUES"
                        + " ('" + customerId + "','" + customerName + "','" + address + "','" + phone + "'," + pan + ","+bikeId+"," + partsId + ",'" + invoice + "', now())";
                msg = General.update(sql);
                System.out.println(msg);
            }
            for (int i = 0; i < list.size(); i++) {
                sqlPartSale = "INSERT INTO parts_sales(`LABOUR_CHARGE`,`CUSTOMER_ID`, `BIKE_ID`, `PARTS_ID`, `PRICE`, `QUANTITY`, `SOLD_BY`, `SOLD_DATE`, `DISCOUNT`, `INVOICE`, `CREATED_DATE`) VALUES ";
                partUpdate = "UPDATE parts SET ";
                Object object = list.get(i);
                String rep = "INSERT INTO daily_sales_report (LABOUR_CHARGE,ITEM_NAME, SELLING_PRICE,PURCHASE_PRICE,PROFIT,CREATED_DATE) VALUES ";
                System.out.println(object);
                try {
                    Map row = (Map) object;

                    try {
                        partsId = Convert.toInt(row.get("sn").toString());
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

                    sqlPartSale += "(" + labourCharge + ",'" + customerId + "',"+bikeId+"," + partsId + "," + price + "," + quantity + ",'admin',now()," + discount + ",'" + invoice + "',now())";
                    partUpdate += "QUANTITY=QUANTITY-" + quantity + ", UPDATED_DATE=now() WHERE SN=" + partsId + "";

                    sqlBill = "INSERT INTO bills(`ADDRESS`, `ADVANCE`,`BIKE_ID`,`PARTS_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`, `DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`, `TOTAL`) VALUES ";
                    sqlBill += "('" + address + "'," + advance + ","+bikeId+"," + partsId + ",now(),'" + customerId + "','" + customerName + "'," + discount + "," + dueAmount + ",'" + invoice + "'," + netTotal + ",'" + orgType + "'," + pan + ",'" + phone + "'," + quantity + "," + sellingPrice + "," + vat + "," + total + ")";

                    msg = General.update(sqlPartSale);
                    System.out.println(msg);
                    msg = General.update(partUpdate);
                    System.out.println(msg);
                    msg = General.update(sqlBill);
                    System.out.println(msg);

                    rep += "(" + labourCharge + ",GET_PARTS_NAME(" + partsId + ")," + price + ",(SELECT COST_PRICE FROM parts WHERE SN=" + partsId + "),(" + price + "-(SELECT COST_PRICE FROM parts WHERE SN=" + partsId + ")),now())";
                    msg = General.update(rep);
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
    public String doDelete(@PathVariable String sn
    ) {
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
