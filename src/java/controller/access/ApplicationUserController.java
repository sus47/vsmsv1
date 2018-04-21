
package controller.access;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationUserController {
@RequestMapping(value="Access/ApplicationUser",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.access.DaoApplicationUser da=new dao.access.DaoImpApplicationUser(); 
map.put("Record",da.getAll("from ApplicationUser"));
return "Access/ApplicationUser";  
}
@RequestMapping(value="Access/ApplicationUser",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.access.ApplicationUser obj,ModelMap map,@RequestParam String Action)
{
dao.access.DaoApplicationUser da=new dao.access.DaoImpApplicationUser(); 
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
map.put("Record",da.getAll("from ApplicationUser"));
return "Access/ApplicationUser";  
}
}
