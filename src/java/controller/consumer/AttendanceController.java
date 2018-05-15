
package controller.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendanceController {
@RequestMapping(value="consumer/Attendance",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.consumer.DaoAttendance da=new dao.consumer.DaoImpAttendance(); 
map.put("Record",da.getAll("from Attendance"));
return "consumer/Attendance";  
}
@RequestMapping(value="consumer/Attendance",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.consumer.Attendance obj,ModelMap map,@RequestParam String Action)
{
dao.consumer.DaoAttendance da=new dao.consumer.DaoImpAttendance(); 
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
map.put("Record",da.getAll("from Attendance"));
return "consumer/Attendance";  
}
}
