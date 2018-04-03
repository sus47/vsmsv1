/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.sales;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author susha
 */
public class BillView {

    
    @RequestMapping(value = "bill/view", method = RequestMethod.GET)
    public String get(){
        return "Sales/bill";
    }

    
}


