
package controller.sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BikesSalesController {
@RequestMapping(value="sales/BikesSales",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.sales.DaoBikesSales da=new dao.sales.DaoImpBikesSales(); 
map.put("Record",da.getAll("from BikesSales"));
return "Sales/BikesSales";  
}
@RequestMapping(value="sales/BikesSales",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.sales.BikesSales obj,ModelMap map,@RequestParam String Action)
{
dao.sales.DaoBikesSales da=new dao.sales.DaoImpBikesSales(); 
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
map.put("Record",da.getAll("from BikesSales"));
return "sales/BikesSales";  
}
}
