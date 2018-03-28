
package controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BikePriceUpdatesController {
@RequestMapping(value="Inventory/BikePriceUpdates",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.inventory.DaoBikePriceUpdates da=new dao.inventory.DaoImpBikePriceUpdates(); 
map.put("Record",da.getAll("from BikePriceUpdates"));
return "Inventory/BikePriceUpdates";  
}
@RequestMapping(value="Inventory/BikePriceUpdates",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.inventory.BikePriceUpdates obj,ModelMap map,@RequestParam String Action)
{
dao.inventory.DaoBikePriceUpdates da=new dao.inventory.DaoImpBikePriceUpdates(); 
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
map.put("Record",da.getAll("from BikePriceUpdates"));
return "Inventory/BikePriceUpdates";  
}
}
