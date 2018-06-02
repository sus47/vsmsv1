package controller.bills;

import java.util.List;
import java.util.Map;
import model.DB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rest.controller.ApiBaseController;

@Controller
public class BillsController {
    @RequestMapping(value = "Bills/Bills", method = RequestMethod.GET)
    public String doGet(ModelMap map) {
        dao.bills.DaoBills da = new dao.bills.DaoImpBills();
        map.put("Record", da.getAll("from Bills"));
//        return "Sales/bill";
        return "Bills/Bills";
    }

    @RequestMapping(value = "Bills/View", method = RequestMethod.GET)
    public String view(@RequestParam(value = "invoice", required = true) String invoice, ModelMap map) {
        dao.bills.DaoBills da = new dao.bills.DaoImpBills();
        String billSql = "SELECT `SN` sn, `ADDRESS` address, `ADVANCE` advance, `BIKE_ID` bikeId, `PARTS_ID` partsId, `CREATED_DATE` createdDate, `CUS_ID` cusId, `CUS_NAME` cusName, `CUS_TYPE` cusType, `DISCOUNT` discount, `DUE` due, "
                + "`INVOICE` invoice, `NET_TOTAL` netTotal , `ORG_TYPE` orgType , `PAN_NO` panNo, `PHONE` phone, `QUANTITY` quantity, `SERVICE_BILL` serviceBill, `SERVICE_TIMES` serviceTimes, `SERVICE_TYPE` serviceType, "
                + "`TOTAL_SP` totalSp, `VAT` vat, `TOTAL` total,GET_BIKE_CHASIS_NUMBER(BIKE_ID) chasisNumber, GET_BIKE_ENGINE_NUMBER(BIKE_ID) engineNumber, GET_BIKE_NAME(BIKE_ID) bikeModel FROM `bills` where INVOICE ='" + invoice + "' GROUP BY INVOICE";
        
        List bill = new DB().getRecord(billSql);
        String sql = "SELECT (CASE "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect ENGINE_NUMBER from bikes where SN=BI.BIKE_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVP') THEN (SELect PARTS_NUMBER from parts where SN=BI.PARTS_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVS') THEN (SELect PARTS_NUMBER from parts where SN=BI.PARTS_ID) "
                + " ELSE NULL END ) as code, "
                + " (CASE"
                + " WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect MODEL from bikes where SN=BI.BIKE_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVP') THEN (SELect NAME from parts where SN=BI.PARTS_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVS') THEN (SELect NAME from parts where SN=BI.PARTS_ID) "
                + " ELSE NULL END ) as description, "
                + " BI.`QUANTITY` as quantity,"
                + " (CASE "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVB') THEN (SELect `SELLING_PRICE` from bikes where SN=BI.BIKE_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVP') THEN (SELect `SELLING_PRICE` from parts where SN=BI.PARTS_ID) "
                + " WHEN (SUBSTR(INVOICE,1,4)='INVS') THEN (SELect `SELLING_PRICE` from parts where SN=BI.PARTS_ID) "
                + " ELSE NULL END ) as rate,"
                + " BI.`DISCOUNT` as discount, BI.`TOTAL_SP` as totalSp from bills BI WHERE BI.`INVOICE`='"+invoice+"'";
        System.out.println(sql);
        List billData = new DB().getRecord(sql);
        map.addAttribute("data", billData);
        System.out.println(bill);
        map.addAttribute("billData", bill);
        return "Sales/bill";
    }
    

    @RequestMapping(value = "Bills/Bills", method = RequestMethod.POST)
    public String doSave(@ModelAttribute model.bills.Bills obj, ModelMap map, @RequestParam String Action) {
        dao.bills.DaoBills da = new dao.bills.DaoImpBills();
        if (Action.equalsIgnoreCase("Save")) {
            map.addAttribute("msg", da.save(obj));
        } else if (Action.equalsIgnoreCase("Update")) {
            map.addAttribute("msg", da.update(obj));
        } else if (Action.equalsIgnoreCase("Delete")) {
            map.addAttribute("msg", da.delete(obj));
        }
        map.put("Record", da.getAll("from Bills"));
        return "Bills/Bills";
    }
}
