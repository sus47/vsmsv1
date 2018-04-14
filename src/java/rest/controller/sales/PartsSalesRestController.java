/*
return "\n{\"sn\": \""+sn+"\",\"customerId\": \""+customerId+"\",\"partsId\": \""+partsId+"\",\"price\": \""+price+"\",\"quantity\": \""+quantity+"\",\"soldBy\": \""+soldBy+"\",\"soldDate\": \""+soldDate+"\",\"discount\": \""+discount+"\",\"invoice\": \""+invoice+"\"}";
*/

package rest.controller.sales;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
dao.sales.DaoPartsSales da=new dao.sales.DaoImpPartsSales(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/sales/partssales", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index()
{
return json.respondWithMessage("Success",da.getAll("from PartsSales"));
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
public String doSave(@RequestBody String jcson) throws IOException
{
 
        System.out.println(jcson);
        String bikeId = "", address = "", customerId = "", customerName = "", phone = "", pan = "", invoice = "",advance="";
        String model = "", sellingPrice = "", quantity = "", price = "", discount = "",cusType="", dueAmount="",netTotal="", orgType="";
        String total="", vat="";

        String sql = "", sqlPartSale = "", sqlBill = "", partUpdate = "", sqlLedger = "";
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
            cusType = (map.get("cusType").toString());
            dueAmount = map.get("dueAmount").toString();
            netTotal= map.get("netTotal").toString();
            advance = map.get("advance").toString();
            orgType = map.get("orgType").toString();
            total = map.get("total").toString();
            vat = map.get("vat").toString();
            String inv = "INSERT INTO `invoice`(`BIKE_INV`,`CUS_ID`,`CREATED_DATE`) VALUES ('"+invoice+"','"+customerId+"',now())";
            msg = General.update(inv);
            System.out.println(msg);
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            List list = objectMapper.readValue(jcsonArray[1], new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });
            
            System.out.println(list);
 System.out.println("size of list is:"+list.size());
            
            for (int i = 0; i < list.size(); i++) {
                sql = "INSERT INTO customers(`CUS_ID`, `NAME`, `ADDRESS`, `PHONE`, `PAN`, `BIKES_ID`, `INVOICE`,`CREATED_DATE`) VALUES";
                sqlPartSale = "INSERT INTO bikes_sales(`BIKE_ID`, `CUSTOMER_ID`, `DISCOUNT`, `INVOICE`, `PRICE`, `QUANTITY`, `SOLD_BY`, `SOLD_DATE`, `CREATED_DATE`) VALUES";
                partUpdate = "UPDATE bikes SET ";
                sqlBill = "INSERT INTO bills(`ADDRESS`, `ADVANCE`, `BIKE_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`, `CUS_TYPE`, `DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`, `TOTAL`) VALUES ";
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
                        discount = row.get("discount").toString();
                        System.out.println(discount);
                    } catch (Exception e) {
                    }
                    sql+= " ('" + customerId + "','" + customerName + "','" + address + "','" + phone + "'," + pan + "," + bikeId + ",'" + invoice + "', now())";

                    sqlPartSale+="("+bikeId+",'"+customerId+"',"+discount+",'"+invoice+"',"+price+","+quantity+",'admin',now(),now())";
                     partUpdate+="QUANTITY=QUANTITY-"+quantity+", UPDATED_DATE=now() WHERE SN="+bikeId+"";
// sqlBill = "INSERT INTO bills(`ADDRESS`, `ADVANCE`, `BIKE_ID`, `CREATED_DATE`, `CUS_ID`, `CUS_NAME`, `CUS_TYPE`, `DISCOUNT`, `DUE`, `INVOICE`, `NET_TOTAL`, `ORG_TYPE`, `PAN_NO`, `PHONE`, `QUANTITY`, `TOTAL_SP`, `VAT`) VALUES ";
                    sqlBill+="('"+address+"',"+advance+","+bikeId+",now(),'"+customerId+"','"+customerName+"','"+cusType+"',"+discount+","+dueAmount+",'"+invoice+"',"+netTotal+",'"+orgType+"',"+pan+",'"+phone+"',"+quantity+","+sellingPrice+","+vat+","+total+")";
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
        return json.respondWithError(msg);
    }

@RequestMapping(value = "api/sales/partssales/{sn}", method = RequestMethod.DELETE, produces = "application/json")
@ResponseBody
public String doDelete(@PathVariable String sn){
 sn=sn.replaceAll("\"", "'");
String sql="DELETE FROM PartsSalesWHERE sn IN "+sn+" ";
msg=da.delete(sql);
if(msg.indexOf("Record Deleted")>=0)
return json.respondWithMessage("Record Deleted successfully",da.getAll(" from PartsSales"));else 
return json.respondWithError(msg);
}
}
