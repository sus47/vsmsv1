
package controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LedgerController {
@RequestMapping(value="inventory/Ledger",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.inventory.DaoLedger da=new dao.inventory.DaoImpLedger(); 
map.put("Record",da.getAll("from Ledger"));
return "inventory/Ledger";  
}
@RequestMapping(value="inventory/Ledger",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.inventory.Ledger obj,ModelMap map,@RequestParam String Action)
{
dao.inventory.DaoLedger da=new dao.inventory.DaoImpLedger(); 
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
map.put("Record",da.getAll("from Ledger"));
return "inventory/Ledger";  
}
}
