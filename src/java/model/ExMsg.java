/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MS
 */
public class ExMsg {
    public static String get(Exception e){
        String msg="";
        try{
        return e.getCause().getMessage();
        }catch(Exception ex){}
        return e.getMessage();
    }
}
