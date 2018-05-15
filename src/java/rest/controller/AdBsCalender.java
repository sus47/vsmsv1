/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.controller;


import dao.assign.DaoAdBsCalender;
import dao.assign.DaoImpAdBsCalender;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
    public class AdBsCalender {
    @RequestMapping(value = "/AdBsCalender", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List index() {
    DaoAdBsCalender da=new DaoImpAdBsCalender();
//    return da.getRecord("select * from ad_bs_calender");
    return da.getAll("from AdBsCalender");
    }

}
