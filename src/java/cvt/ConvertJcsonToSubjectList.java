
package cvt;

import java.util.List;


public class ConvertJcsonToSubjectList {
    
     public static List<ConvertJcsonToSubjectList> convert(String jcson)
        {
        jcson=jcson.substring(jcson.indexOf("["), jcson.indexOf("]")+1);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper =  new  com.fasterxml.jackson.databind.ObjectMapper();
        List<ConvertJcsonToSubjectList> cerd = null;
        try{
        cerd = objectMapper.readValue(jcson, new com.fasterxml.jackson.core.type.TypeReference<List<ConvertJcsonToSubjectList>>(){});
        }catch(Exception e){System.out.println(e.getMessage());}
            System.out.println(cerd.size());
        return cerd;
} 
//     public static void main(String[] args) 
//     {
//     System.out.println(convert("[{\"subjectName\":\"----\",\"thFm\":100,\"thPm\":35,\"phFm\":0,\"phPm\":0,\"uid\":0,\"boundindex\":0,\"uniqueid\":\"2116-22-24-18-272525\",\"visibleindex\":0,\"subjectName\":\"COM. English\"},{\"subjectId\":\"\",\"thFm\":100,\"thPm\":35,\"phFm\":0,\"phPm\":0,\"uid\":1,\"boundindex\":1,\"uniqueid\":\"1727-24-18-17-221716\",\"visibleindex\":1,\"subjectName\":\"COM. Nepali\"},{\"subjectId\":\"\",\"thFm\":100,\"thPm\":35,\"phFm\":0,\"phPm\":0,\"uid\":2,\"boundindex\":2,\"uniqueid\":\"2226-31-21-30-282830\",\"visibleindex\":2,\"subjectName\":\"OPT. Math\"}]\n" ));
//     System.exit(0);
//     }
String uid,boundindex,uniqueid,visibleindex;
private String subjectName;
private Float thFm;
private Float thPm;
private Float thCreditHr;
private Float phFm;
private Float phPm;
private Float phCreditHr;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Float getThFm() {
        return thFm;
    }

    public void setThFm(Float thFm) {
        this.thFm = thFm;
    }

    public Float getThPm() {
        return thPm;
    }

    public void setThPm(Float thPm) {
        this.thPm = thPm;
    }

    public Float getThCreditHr() {
        return thCreditHr;
    }

    public void setThCreditHr(Float thCreditHr) {
        this.thCreditHr = thCreditHr;
    }

    public Float getPhFm() {
        return phFm;
    }

    public void setPhFm(Float phFm) {
        this.phFm = phFm;
    }

    public Float getPhPm() {
        return phPm;
    }

    public void setPhPm(Float phPm) {
        this.phPm = phPm;
    }

    public Float getPhCreditHr() {
        return phCreditHr;
    }

    public void setPhCreditHr(Float phCreditHr) {
        this.phCreditHr = phCreditHr;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBoundindex() {
        return boundindex;
    }

    public void setBoundindex(String boundindex) {
        this.boundindex = boundindex;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getVisibleindex() {
        return visibleindex;
    }

    public void setVisibleindex(String visibleindex) {
        this.visibleindex = visibleindex;
    }
}
