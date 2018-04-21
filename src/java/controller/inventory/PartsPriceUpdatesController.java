
package controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartsPriceUpdatesController {
@RequestMapping(value="Inventory/PartsPriceUpdates",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.inventory.DaoPartsPriceUpdates da=new dao.inventory.DaoImpPartsPriceUpdates(); 
map.put("Record",da.getAll("from PartsPriceUpdates"));
return "Inventory/PartsPriceUpdates";  
}
@RequestMapping(value="Inventory/PartsPriceUpdates",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.inventory.PartsPriceUpdates obj,ModelMap map,@RequestParam String Action)
{
dao.inventory.DaoPartsPriceUpdates da=new dao.inventory.DaoImpPartsPriceUpdates(); 
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
map.put("Record",da.getAll("from PartsPriceUpdates"));
return "Inventory/PartsPriceUpdates";  
}
}
