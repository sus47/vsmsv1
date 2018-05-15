/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvt;

import dao.assign.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Date {
   public static String get()
   {
    java.util.Date date=new java.util.Date();
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      return df.format(date);
   }
   public static String get(java.util.Date date )
   {   
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      return df.format(date);
   }
    public static String checkDate(String date )
   {   
       
//       DaoSchoolInfo da=new DaoImpSchoolInfo();
//      String sql="SELECT TO_DATE('"+date+"') AS TO_DATE FROM DUAL";
//      List data=da.getRecord(sql);
//       for(Object object : data) {
//            Map row = (Map)object;
//           date= row.get("TO_DATE").toString();
//       }
      return date;
   }
    public static String checkDate(java.util.Date d )
   {   
//         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//         String date=df.format(d);
//       DaoSchoolInfo da=new DaoImpSchoolInfo();
//      String sql="SELECT TO_DATE('"+date+"') AS TO_DATE FROM DUAL";
//      List data=da.getRecord(sql);
//       for(Object object : data) {
//            Map row = (Map)object;
//           date= row.get("TO_DATE").toString();
//       }
      return d.toString();
   }


//    public static void main(String[] args) {
//        System.out.println(checkDate(new java.util.Date()));
//        System.exit(0);
//    }
}
