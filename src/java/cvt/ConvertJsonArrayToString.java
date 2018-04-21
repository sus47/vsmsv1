/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvt;

public class ConvertJsonArrayToString {
    public static String[] convert(String jcson) {
        String val[]=new String[2];
           int  arrayStart=jcson.indexOf("[");
           int  arrayEnd=jcson.indexOf("]")+1;
           int len=jcson.length();
                String array=jcson.substring(arrayStart,arrayEnd);
                String jsconStart=jcson.substring(0, arrayStart);
                  String jsconEnd=jcson.substring(arrayEnd, len);
//                System.out.println(jsconStart);
               val[1]=(array);
//                System.out.println(jsconEnd);
//                
               val[0]=(jsconStart+"0"+jsconEnd);
               return  val;
    }
}
