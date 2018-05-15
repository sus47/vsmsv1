
package model;

import java.util.List;

public class ConvertStudentReg 
{
   private String academicYear;
  
    private String examId;
   
    private Integer schoolSn;
 
    private Integer studentSn;
 
    private String regNo;
   
    private int timeOfAttempt;

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Integer getSchoolSn() {
        return schoolSn;
    }

    public void setSchoolSn(Integer schoolSn) {
        this.schoolSn = schoolSn;
    }

    public Integer getStudentSn() {
        return studentSn;
    }

    public void setStudentSn(Integer studentSn) {
        this.studentSn = studentSn;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getTimeOfAttempt() {
        return timeOfAttempt;
    }

    public void setTimeOfAttempt(int timeOfAttempt) {
        this.timeOfAttempt = timeOfAttempt;
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

 String uid,boundindex,uniqueid,visibleindex;

    
        public static List<ConvertStudentReg> convert(String jcson)
        {
        jcson=jcson.substring(jcson.indexOf("["), jcson.indexOf("]")+1);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper =  new  com.fasterxml.jackson.databind.ObjectMapper();
        List<ConvertStudentReg> cerd = null;
        try{
        cerd = objectMapper.readValue(jcson, new com.fasterxml.jackson.core.type.TypeReference<List<ConvertStudentReg>>(){});
        }catch(Exception e){}
        return cerd;

        } 
 
}
