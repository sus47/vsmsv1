
package controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartsController {
@RequestMapping(value="Inventory/Parts",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.inventory.DaoParts da=new dao.inventory.DaoImpParts(); 
map.put("Record",da.getAll("from Parts"));
return "Inventory/Parts";  
}
@RequestMapping(value="Inventory/Parts",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.inventory.Parts obj,ModelMap map,@RequestParam String Action)
{
dao.inventory.DaoParts da=new dao.inventory.DaoImpParts(); 
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
map.put("Record",da.getAll("from Parts"));
return "Inventory/Parts";  
}
}
