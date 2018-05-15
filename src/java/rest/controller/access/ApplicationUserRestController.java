/*
return "\n{\"userCode\": \""+userCode+"\",\"userName\": \""+userName+"\",\"schoolId\": \""+schoolId+"\",\"userPassword\": \""+userPassword+"\",\"email\": \""+email+"\",\"mobile\": \""+mobile+"\",\"lastLogin\": \""+lastLogin+"\",\"token\": \""+token+"\",\"status\": \""+status+"\",\"municipal\": \""+municipal+"\"}";
*/

package rest.controller.access;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.General;
import dao.access.DaoApplicationUser;
import dao.access.DaoImpApplicationUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
<<<<<<< HEAD
=======
import model.inventory.Bikes;
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.controller.ApiBaseController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
@RestController
public class ApplicationUserRestController {
<<<<<<< HEAD
    int tokenTime=60;
       
 ApiBaseController json=new ApiBaseController();
=======

>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
@RequestMapping(value = "api/access/applicationuserlogin", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public String doLogin(@RequestBody String jcson) throws IOException
{ 
 return login(jcson);
  }
<<<<<<< HEAD
@RequestMapping(value = "api/access/applicationuserlogin", method = RequestMethod.PUT, produces = "application/json")
@ResponseBody
public String doUpdate(@RequestParam String minut,@RequestParam String token) throws IOException
{ 
 int MM=1;
 try{MM=Integer.parseInt(minut);}catch(Exception e){}
 if(MM<1)MM=1;
    String temp=loginUpdate(token,MM);
    
  return temp;
}
=======

>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
String login(String jcson)
{
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();  
<<<<<<< HEAD
        String userCode="",userName="",userType="";
     
      try{
       map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});
         userCode=map.get("userCode").toString();
        String userPassword=map.get("userPassword").toString();
        String sql="SELECT PASSWORD('"+userPassword+"') AS loginPass,USER_PASSWORD AS dbPass,USER_NAME AS userName,EMAIL AS email,MOBILE AS mobile,USER_TYPE AS userType FROM application_user WHERE USER_CODE='"+userCode+"'";
=======
        ApiBaseController json=new ApiBaseController();
      try{
       map = mapper.readValue(jcson, new TypeReference<Map<String, String>>(){});
        String userCode=map.get("userCode").toString();
        String userPassword=map.get("userPassword").toString();
        String sql="SELECT PASSWORD('"+userPassword+"') AS PASS,USER_PASSWORD AS dbPass,USER_NAME AS userName,GET_SCHOOL_NAME(SCHOOL_ID) schoolName,SCHOOL_ID schoolId,EMAIL AS email,MOBILE AS mobile,MUNICIPAL municipal,IF(SCHOOL_ID IS NULL,'M','S') AS userType FROM application_user WHERE USER_CODE='"+userCode+"'";
       
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
        General au=new General();
        List list=au.getRecord(sql);
        if(list.isEmpty())
        return json.respondWithError("Invalid login id");
<<<<<<< HEAD

        Object object=list.get(0);
        Map row = (Map)object;       
        if(row.get("loginPass").toString().equalsIgnoreCase(row.get("dbPass").toString()))
        {
        try{userCode=row.get("userCode").toString();}catch(Exception e){}
        try{userName=row.get("userName").toString();}catch(Exception e){}
        try{userType=row.get("userType").toString();}catch(Exception e){}
        Key key = MacProvider.generateKey();
        String apiKey=key.toString();
        String token=createJWT(apiKey, "phoenix", "{\"loginId\": \""+userCode+"\",\"userName\":\""+row.get("userName")+"\",\"userType\":\""+row.get("userType")+"\"}", "userLogin", (60000)*tokenTime);
        sql="UPDATE application_user SET TOKEN='"+token+"',TOKEN_EXP_TIME=(NOW()+ INTERVAL "+(tokenTime+30)+" MINUTE) WHERE USER_CODE='"+userCode+"'";  
        if(au.save(sql)>0)
        {
        return "{\"message\":\"Success\",\"token\":\""+token+"\",\"userType\":\""+userType+"\",\"userName\":\""+userName+"\"}";
=======
        Object object=list.get(0);
        Map row = (Map)object;
        
        if(row.get("PASS").toString().equalsIgnoreCase(row.get("dbPass").toString()))
        {
        Key key = MacProvider.generateKey();
        String apiKey=key.toString();
        String token=createJWT(apiKey, "phoenix", "{\"loginId\": \""+userCode+"\",\"userName\":\""+row.get("userName")+"\",\"userType\":\""+row.get("userType")+"\",\"municipal\":\""+row.get("municipal")+"\",\"schoolName\":\""+row.get("schoolName")+"\"}", "userLogin", (60000)*180);
        sql="UPDATE application_user SET TOKEN='"+token+"',API_KEY='"+apiKey+"',TOKEN_EXP_TIME=(NOW()+ INTERVAL 180 MINUTE) WHERE USER_CODE='"+userCode+"'";  
        if(au.save(sql)>0)
        {
        return "{\"message\":\"Success\",\"token\":\""+token+"\",\"token\":\""+token+"\"}";
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
        }
        }else 
        {
        return json.respondWithError("invalid password");
        }
        return json.respondWithError("Try Again");
<<<<<<< HEAD
        }catch(Exception e){return json.respondWithError(e.getMessage());}
}

   String loginUpdate(String token,int MM)
{
String oldToken=token;
    try{
          String sql="SELECT USER_CODE AS userCode, USER_NAME AS userName,EMAIL AS email,MOBILE AS mobile,USER_TYPE AS userType FROM application_user WHERE TOKEN='"+oldToken+"'";
        General au=new General();
        List list=au.getRecord(sql);
        String userCode="",userName="",userType="";
       try{ 
        Object object=list.get(0);
        Map row = (Map)object;       

        try{userCode=row.get("userCode").toString();}catch(Exception e){}
        try{userName=row.get("userName").toString();}catch(Exception e){}
        try{userType=row.get("userType").toString();}catch(Exception e){}

        }catch(Exception e){}
        Key key = MacProvider.generateKey();
        String apiKey=key.toString();
        String newToken=createJWT(apiKey, "phoenix", "{\"loginId\": \""+userCode+"\",\"userName\":\""+userName+"\",\"userType\":\""+userType+"\"}", "userLogin",((60000*tokenTime)));
        sql="UPDATE application_user SET TOKEN='"+newToken+"',TOKEN_EXP_TIME=(NOW()+ INTERVAL "+((tokenTime+30))+" MINUTE) WHERE TOKEN='"+oldToken+"'";  
        int up=au.save(sql);
        if(up>0)
        {
        return "{\"message\":\"Success\",\"token\":\""+newToken+"\",\"userType\":\""+userType+"\",\"userName\":\""+userName+"\"}";
        }else
        {
        return json.respondWithError("token Alredy updated");
        }

}catch(Exception e){return json.respondWithError(e.getMessage());}
}

=======
}catch(Exception e){return json.respondWithError(e.getMessage());}
}

   
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
private String createJWT(String apiKey,String id, String issuer, String subject, long ttlMillis) {
 
    //The JWT signature algorithm we will be using to sign the token
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; 
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis); 
    //We will sign our JWT with our ApiKey secret
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
 
    //Let's set the JWT Claims
    JwtBuilder builder = Jwts.builder().setId(id)
                                .setIssuedAt(now)
                                .setSubject(subject)
                                .setIssuer(issuer)
                                .signWith(signatureAlgorithm, signingKey);
 
    //if it has been specified, let's add the expiration

    long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
    
 
    //Builds the JWT and serializes it to a compact, URL-safe string
   
    return builder.compact();
}
 
//Sample method to validate and read the JWT
public Claims parseJWT(String apiKey,String jwt) {
    try{
Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(apiKey)).parseClaimsJws(jwt).getBody();
 System.out.println(claims.isEmpty());
 
        System.out.println(claims.getExpiration());
        System.out.println(claims.getId());
         System.out.println(claims.getIssuedAt());
          System.out.println(claims.getIssuer());
return claims;
    }catch(Exception e){}
    return null;
}
<<<<<<< HEAD
 

=======
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
}
