
package controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomersController {
@RequestMapping(value="Customer/Customers",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.customer.DaoCustomers da=new dao.customer.DaoImpCustomers(); 
map.put("Record",da.getAll("from Customers"));
return "Customer/Customers";  
}
@RequestMapping(value="Customer/Customers",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.customer.Customers obj,ModelMap map,@RequestParam String Action)
{
dao.customer.DaoCustomers da=new dao.customer.DaoImpCustomers(); 
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
map.put("Record",da.getAll("from Customers"));
return "Customer/Customers";  
}
}
