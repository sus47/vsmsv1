/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
     public static Date toDate(String sDate)
  {
      Date date=null;
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
     try{ 
         date=df.parse(sDate);   
          return date;
     }catch(Exception e){}
     df=new SimpleDateFormat("yyyy/MM/dd");
     try{ 
         date=df.parse(sDate);   
          return date;
     }catch(Exception e){}
      df=new SimpleDateFormat("dd/M/yyyy");
     try{ 
         date=df.parse(sDate);   
          return date;
     }catch(Exception e){}
     return date;
  } 
 public static String inDate(String sDate)
  {
      Date date=null;
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
     try{ 
         date=df.parse(sDate);   
          }catch(Exception e){}
     df=new SimpleDateFormat("yyyy/MM/dd");
     try{ 
         date=df.parse(sDate);   
     }catch(Exception e){}
      df=new SimpleDateFormat("dd/M/yyyy");
     try{ 
         date=df.parse(sDate);   
    }catch(Exception e){}
     df=new SimpleDateFormat("yyyy-MM-dd");
     return df.format(date);
  }  
  public static int toInt(String intVal)
  {
  return Integer.parseInt(intVal);
  } 
   public static float toFloat(String fltVal)
  {
  return Float.parseFloat(fltVal);
  } 
  public static double toDouble(String dblVal)
  {
  return Double.parseDouble(dblVal);
  }
  
  
  public static int toMsg(String msg)
  {
  String temp=msg.substring(0,msg.indexOf(" "));
  int i=0;
  try{
  i=Integer.parseInt(temp);
  }catch(Exception e){}
  return i;
  }
}
