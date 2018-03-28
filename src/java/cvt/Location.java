
package cvt;

public class Location {
    public static String getUrl() {
        String url="http://localhost:8084/RPS/";
     // url="http://139.59.16.153:8080/RPS/";
        return url;
    }
 public static String getDrivePath() {
        String path="C:/Users/susha/Documents/NetBeansProjects/MarksheetGen/web/";
//               path="/opt/tomcat/ewbapps/RPSMarksheet/";

        return path;
    }
  public static String getUrl(int port) {
        String url;
    if(port==8080)
        url="http://139.59.16.153:8080/RPS/";
    else url="http://localhost:"+port+"/RPS/";
        return url;
    }
        public static String getDrivePath(int port) {
        String path="C:/Users/susha/Documents/NetBeansProjects/MarksheetGen/web/";
        if(port==8080)
        path="/opt/tomcat/webapps/RPSMarksheet/";
        return path;
        }
}
