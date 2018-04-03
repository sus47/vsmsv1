
package controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BikesController {
@RequestMapping(value="Inventory/Bikes",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.inventory.DaoBikes da=new dao.inventory.DaoImpBikes(); 
map.put("Record",da.getAll("from Bikes"));
//return "Inventory/Bikes"; 
        return "Sales/bill";

}
@RequestMapping(value="Inventory/Bikes",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.inventory.Bikes obj,ModelMap map,@RequestParam String Action)
{
dao.inventory.DaoBikes da=new dao.inventory.DaoImpBikes(); 
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
map.put("Record",da.getAll("from Bikes"));
return "Inventory/Bikes";  
}
}
