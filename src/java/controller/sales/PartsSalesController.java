
package controller.sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartsSalesController {
@RequestMapping(value="sales/PartsSales",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.sales.DaoPartsSales da=new dao.sales.DaoImpPartsSales(); 
map.put("Record",da.getAll("from PartsSales"));
return "sales/PartsSales";  
}
@RequestMapping(value="sales/PartsSales",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.sales.PartsSales obj,ModelMap map,@RequestParam String Action)
{
dao.sales.DaoPartsSales da=new dao.sales.DaoImpPartsSales(); 
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
map.put("Record",da.getAll("from PartsSales"));
return "sales/PartsSales";  
}
}
