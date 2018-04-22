
package model;

import java.util.List;

public class ConvertExamSubject 
{
 int subjectId,thCreditHr,prCreditHr,programId,order;
  float thFm,thPm,prFm,prPm;
 String gradingType,subType,subjectName,subjectGroup,name,subjectHeirarchy;


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getSubjectHeirarchy() {
        return subjectHeirarchy;
    }

    public void setSubjectHeirarchy(String subjectHeirarchy) {
        this.subjectHeirarchy = subjectHeirarchy;
    }

    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(String subjectGroup) {
        this.subjectGroup = subjectGroup;
    }
String uid,boundindex,uniqueid,visibleindex;

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getThCreditHr() {
        return thCreditHr;
    }

    public void setThCreditHr(int thCreditHr) {
        this.thCreditHr = thCreditHr;
    }

    public int getPrCreditHr() {
        return prCreditHr;
    }

    public void setPrCreditHr(int prCreditHr) {
        this.prCreditHr = prCreditHr;
    }

    public float getThFm() {
        return thFm;
    }

    public void setThFm(float thFm) {
        this.thFm = thFm;
    }

    public float getThPm() {
        return thPm;
    }

    public void setThPm(float thPm) {
        this.thPm = thPm;
    }

    public float getPrFm() {
        return prFm;
    }

    public void setPrFm(float prFm) {
        this.prFm = prFm;
    }

    public float getPrPm() {
        return prPm;
    }

    public void setPrPm(float prPm) {
        this.prPm = prPm;
    }

    public String getGradingType() {
        return gradingType;
    }

    public void setGradingType(String gradingType) {
        this.gradingType = gradingType;
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
        public static List<ConvertExamSubject> convert(String jcson)
        {
        jcson=jcson.substring(jcson.indexOf("["), jcson.indexOf("]")+1);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper =  new  com.fasterxml.jackson.databind.ObjectMapper();
        List<ConvertExamSubject> cerd = null;
        try{
        cerd = objectMapper.readValue(jcson, new com.fasterxml.jackson.core.type.TypeReference<List<ConvertExamSubject>>(){});
        }catch(Exception e){}
        return cerd;

        } 
 
}
