
package controller.bills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillsController {
@RequestMapping(value="Bills/Bills",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.bills.DaoBills da=new dao.bills.DaoImpBills(); 
map.put("Record",da.getAll("from Bills"));
return "Bills/Bills";  
}
@RequestMapping(value="Bills/Bills",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.bills.Bills obj,ModelMap map,@RequestParam String Action)
{
dao.bills.DaoBills da=new dao.bills.DaoImpBills(); 
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
map.put("Record",da.getAll("from Bills"));
return "Bills/Bills";  
}
}
