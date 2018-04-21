

package rest.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.controller.ApiBaseController;

@RestController
public class BsToAdConvert {
    
dao.assign.DaoAdBsCalender da=new dao.assign.DaoImpAdBsCalender(); 
ApiBaseController json=new ApiBaseController();
String msg="";

@RequestMapping(value = "api/bstoadconvert", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public String index(Map map,@RequestParam String bsDate)
{

List data=da.getRecord("SELECT `AD_DATE` AS adDate FROM ad_bs_calender WHERE `BS_DATE`='"+bsDate+"'");
String adDate="";
for(Object object : data) 
{
map = (Map)object;
adDate= map.get("adDate").toString();
return json.respondWithMessage("Success","\""+adDate+"\"");
}
return json.respondWithError("Invalid BS Date");
}
 
}