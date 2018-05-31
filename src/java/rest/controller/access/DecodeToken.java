
package rest.controller.access;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.General;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpHeaders;

public class DecodeToken {

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   String userCode,schoolId,status,userType;
   int remainingTime,municipal,tokenStatus;

    public int getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(int tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getMunicipal() {
        return municipal;
    }

    public void setMunicipal(int municipal) {
        this.municipal = municipal;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
 public DecodeToken(String token)
 {
     set(token);
  }
 public DecodeToken(HttpHeaders headers)
 {
//     System.out.println();
     String token=toToken(headers);
      set(token);
  }
 void set(String token){
      
   try{
     General  q=new General();
     String sql="SELECT USER_CODE,STATUS,TIME_TO_SEC(TIMEDIFF(TOKEN_EXP_TIME,NOW())) AS remainTime,USER_TYPE AS userType FROM application_user WHERE TOKEN='"+token+"'";
    List list= q.getRecord(sql);
     if(list.isEmpty())
     {
          setUserCode(null);
           setStatus(null);
           setRemainingTime(0);
           setUserType(null);
             setTokenStatus(0);
     }else
     {
        Object object=list.get(0);
        Map row = (Map)object;
        setUserCode(row.get("USER_CODE").toString());
        setStatus(row.get("STATUS").toString());
        setRemainingTime(Integer.parseInt(row.get("remainTime").toString()));
        setUserType(row.get("userType").toString());
         setTokenStatus(1);
     }
   }catch(Exception e){System.out.println(e.getMessage());}
  
 }
public String  toToken(HttpHeaders headers) {
//    System.out.println(head);
String head=headers.toString();
    int authorization=head.indexOf("authorization=[Bearer")+"authorization=[Bearer ".length();
        char c;
        int i=authorization;
        for(;i<head.length();i++)
        {
        c=head.charAt(i);
        if(c==']')break;
        }
        String token=head.substring(authorization,i);
//        System.out.println(authorization+" "+i);
//        System.out.println(token);
        return token;
        }
       
//        public static Claims parseJWT(String apiKey,String jwt) {
//    try{
//Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(apiKey)).parseClaimsJws(jwt).getBody();
//
//        System.out.println(claims.getExpiration());
//        System.out.println(claims.getId());
//         System.out.println(claims.getIssuedAt());
//          System.out.println(claims.getIssuer());
//          
//return claims;
//    }catch(Exception e){System.err.println(e);}
//    return null;
//}
}

