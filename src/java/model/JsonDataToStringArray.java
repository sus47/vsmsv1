
package model;

import java.util.List;

public class JsonDataToStringArray {
public static String[] get(String jsonData) {
String val[]=new String[2];
int  arrayStart=jsonData.indexOf("[");
int  arrayEnd=jsonData.indexOf("]")+1;
int len=jsonData.length();
String array=jsonData.substring(arrayStart,arrayEnd);
String jsconStart=jsonData.substring(0, arrayStart);
String jsconEnd=jsonData.substring(arrayEnd, len);
val[1]=(array);
val[0]=(jsconStart+"0"+jsconEnd);
return  val;
} 
}
