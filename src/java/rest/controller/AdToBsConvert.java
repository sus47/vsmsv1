

package rest.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.controller.ApiBaseController;

@RestController
public class AdToBsConvert {
    
dao.assign.DaoAdBsCalender da=new dao.assign.DaoImpAdBsCalender(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/adtobsonvert", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index(Map map,@RequestParam String adDate)
{

try{
List data=da.getRecord("SELECT `BS_DATE` AS bsDate FROM ad_bs_calender WHERE `AD_DATE`='"+adDate+"'");

String bsDate="";
for(Object object : data) 
{
map = (Map)object;
bsDate= map.get("bsDate").toString();
return json.respondWithMessage("Success","\""+bsDate+"\"");
}
}catch(Exception e){}
return json.respondWithMessage("Success","\"Invalid AD Date\"");
}
 
}
  

