
package controller.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffsController {
@RequestMapping(value="consumer/Staffs",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.consumer.DaoStaffs da=new dao.consumer.DaoImpStaffs(); 
map.put("Record",da.getAll("from Staffs"));
return "consumer/Staffs";  
}
@RequestMapping(value="consumer/Staffs",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.consumer.Staffs obj,ModelMap map,@RequestParam String Action)
{
dao.consumer.DaoStaffs da=new dao.consumer.DaoImpStaffs(); 
 if(Action.equalsIgnoreCase("Save"))
{
 map.addAttribute("msg", da.save(obj));
}else if(Action.equalsIgnoreCase("Update"))
{
map.addAttribute("msg", da.update(obj));
}else if(Action.equalsIgnoreCase("Delete"))
{
 map.addAttribute("msg", da.delete(obj));
}
map.put("Record",da.getAll("from Staffs"));
return "consumer/Staffs";  
}
}
