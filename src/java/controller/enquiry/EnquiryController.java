
package controller.enquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnquiryController {
@RequestMapping(value="enquiry/Enquiry",method = RequestMethod.GET)
public String doGet(ModelMap map)
{
 dao.enquiry.DaoEnquiry da=new dao.enquiry.DaoImpEnquiry(); 
map.put("Record",da.getAll("from Enquiry"));
return "enquiry/Enquiry";  
}
@RequestMapping(value="enquiry/Enquiry",method = RequestMethod.POST)
public String doSave(@ModelAttribute model.enquiry.Enquiry obj,ModelMap map,@RequestParam String Action)
{
dao.enquiry.DaoEnquiry da=new dao.enquiry.DaoImpEnquiry(); 
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
map.put("Record",da.getAll("from Enquiry"));
return "enquiry/Enquiry";  
}
}
