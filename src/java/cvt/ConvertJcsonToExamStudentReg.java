/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 ACADEMIC_YEAR
  EXAM_ID    
   SCHOOL_SN
   EXAM_SUBJECT_GROUP  
 */
package cvt;

import java.util.List;

public class ConvertJcsonToExamStudentReg {
         public static List<ConvertJcsonToExamStudentReg> convert(String jcson)
        {
        jcson=jcson.substring(jcson.indexOf("["), jcson.indexOf("]")+1);
        com.fasterxml.jackson.databind.ObjectMapper objectMapper =  new  com.fasterxml.jackson.databind.ObjectMapper();
        List<ConvertJcsonToExamStudentReg> list = null;
        try{
        list = objectMapper.readValue(jcson, new com.fasterxml.jackson.core.type.TypeReference<List<ConvertJcsonToExamStudentReg>>(){});
        }catch(Exception e){System.out.println(e.getMessage());}
          
        return list;
} 
  String uid,boundindex,uniqueid,visibleindex;  
  int timeOfAttempt,studentSn;
 String studentName,nameNepali,rollNo,regNo,symbolNo;  

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

    public int getTimeOfAttempt() {
        return timeOfAttempt;
    }

    public void setTimeOfAttempt(int timeOfAttempt) {
        this.timeOfAttempt = timeOfAttempt;
    }

    public int getStudentSn() {
        return studentSn;
    }

    public void setStudentSn(int studentSn) {
        this.studentSn = studentSn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNameNepali() {
        return nameNepali;
    }

    public void setNameNepali(String nameNepali) {
        this.nameNepali = nameNepali;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getSymbolNo() {
        return symbolNo;
    }

    public void setSymbolNo(String symbolNo) {
        this.symbolNo = symbolNo;
    }
}
