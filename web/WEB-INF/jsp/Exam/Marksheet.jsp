<%@page import="dao.General"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
     
        <style>
            .heading{
                text-align:center;
                font-weight:bolder;
            }

            @page{
                size:A4;
            }
            h1{
                margin:0;
            }
            .td-height{
                height: 400px;
            }
            .td-height1{
                height: 425px;
            }
            .marksheet{
                display: inline-block;
            }
            .info{
                display: inline-block;
                margin-top:14px;
                /*vertical-align: top;*/
            }
            .parent-div{
                display:block;
                /*padding-left:10px;*/
                padding-right:10px;
            }
        </style>
    </head>
    <body>
<%
    General da=new General();
     String schoolId=request.getParameter("schoolId");
     String studentId=request.getParameter("studentId");
     String examId=request.getParameter("examId");
String sql="SELECT EXAM_SN_TO_NAME(EXAM_SN) AS examName,SI.`CONTACT_NO` contactNo,SI.ADDRESS AS address,SI.NAME AS schoolName,STUDENT_ID AS studentId,GET_STUDENT_NAME(GET_STUDENT_REG_NAME(STUDENT_ID)) AS studentName,TOTAL_PM AS totalPassMark,TOTAL_FM AS totalFullMark,TOTAL_OBTAIN_MARK totalMark,DIVISION division,GRADE grade,RESULT AS 'result',PERCENT percent,ER.SN sn ,SGI.FATHER_NAME AS fatherName,MOTHER_NAME AS motherName FROM exam_result ER,students_guardian_information SGI ,school_info SI WHERE SI.ID=ER.SCHOOL_ID AND GET_STUDENT_REG_NAME(STUDENT_ID)=SGI.STUDENT_SN AND  ER.STUDENT_ID IN ("+studentId+") AND ER.SCHOOL_ID="+schoolId+" AND ER.EXAM_SN="+examId; 
List list;

try{
List data=da.getRecord(sql);
String sn="";
  for(int k=0;k<data.size();k++)
  {
        Map row = (Map)data.get(k);
    
 %>
 <div class="content" style="margin-bottom: 65px;">
            <div class="content-heading" style="width:780px; height: 1220px; border:1px solid;">
                <table style="width:780px; border-bottom:1px solid black">
                    <tr>
                        <td rowspan="4" width="100px" height="100px"><div style="height:100px; width: 100px; border: 1px solid black; text-align:center;">Logo</div></td>
                        <td style="text-align:center;"><h1><%=row.get("schoolName")%></h1></td>
                    </tr>
                    <tr>


                        <td class="heading"><%=row.get("address")%></td>
                    </tr>
                    <tr>

                        <td class="heading">Phone : <%=row.get("contactNo")%> </td>
                    </tr>
                    <tr>
                        <td class="heading" style="font-size:21px; padding-top: 9px;"><%=row.get("examName")%></td>
                    </tr>
                </table>
                <!--$ql}-->
                <table width="100%">
                    <tr>
                        <td style="text-align:left;"> Student Name:- &nbsp; <b><%=row.get("studentName")%></b></td>
                        <td style="text-align:right;"> Student Id:- <b> <%=row.get("studentId")%></b></td>
                    </tr>
                    <tr>
                        <td style="text-align:left;"> Father Name:- &nbsp; <b><%=row.get("fatherName")%></b></td>
                        <td style="text-align:right;"> Mother Name:- <b> <%=row.get("motherName")%></b></td>
                    </tr>

                </table>
                <h2 style="text-align:center;"> ASSIGNMENT </h2>
                <div style="width: 770px; margin-left: 10px;" class="marksheet">
                    <table cellpadding="0" cellspacing="0" border="1" width="100%">
                        <tr style="text-align:center;">
                            <td rowspan="2">SUBJECT</td>
                            <td colspan="3">FULL MARKS</td>
                            <td colspan="3">PASS MARKS</td>
                            <td colspan="3">MARKS</td>
                            <td rowspan="2">GRADE</td>
                        </tr>
                        <tr style="text-align:center;">
                            <td>TH.</td>
                            <td>PR.</td>
                            <td>TO.</td>
                            <td>TH.</td>
                            <td>PR.</td>
                            <td>TO.</td>
                            <td>TH.</td>
                            <td>PR.</td>
                            <td>TO.</td>
                        </tr>
                        <%
        int i = 0;
        sn=  row.get("sn").toString();
        sql="SELECT SUBJECT_NAME AS subjectName,IFNULL(ERD.TH_OM,0) AS thOm,IFNULL(ERD.PH_OM,0) AS phOm,IFNULL(ERD.TH_FM,0) AS thFm,IFNULL(ERD.PH_FM,0) AS phFm,IFNULL(ERD.TH_PM,0) AS thPm,IFNULL(ERD.PH_PM,0) AS phPm,IFNULL(ERD.GRADE,' ') AS grade FROM exam_result_details ERD,exam_subject_group ESG WHERE CONCAT(ESG.SUB_CODE,ESG.SN)=ERD.EXAM_SUBJECT_SN AND EXAM_RESULT_SN="+sn;
        list=da.getRecord(sql);
          for(;i<list.size();i++)
  {
        Map Rs = (Map)list.get(i);
                        %>
                      
                            <tr style="height: 25px;">
                                <td ><%=Rs.get("subjectName")%></td>
                                <td ><%=Rs.get("thFm")%></td>
                                <td ><%=Rs.get("phFm")%></td>
                                <td ><%=(Integer)Rs.get("thFm")+(Integer)Rs.get("phFm")%></td>
                                <td ><%=Rs.get("thPm")%></td>
                                <td ><%=Rs.get("phPm")%></td>
                                <td ><%=(Integer)Rs.get("thPm")+(Integer)Rs.get("phPm")%></td>
                                <td ><%=Rs.get("thOm")%></td>
                                <td ><%=Rs.get("phOm")%></td>
                                <td ><%=(Integer)Rs.get("thOm")+(Integer)Rs.get("phOm")%></td>
                                <td><%=Rs.get("grade")%></td>

                            </tr>
                    
                        <%}
                            for (; i < 29; i++) {
                        %>
                        <tr style="height: 40px; border: solid 0px;">
                            <td style="border:solid 0px;border-right:solid 1px;"> &nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>
                            <td style="border:solid 0px;border-right:solid 1px;">&nbsp; </td>

                        </tr>
                        <tr >
                            <%}%>
                            <!--totalFullMark,totalPassMark,totalMark,grade,division-->
                            <td>TOTAL</td>
                            <td><%if(row.get("totalTheoryFullMark")==null){%><c:out value=""/><%}else{%><c:out value="row.get('totalTheoryFullMark')"/><%}%></td>
                            <td><%=row.get("totalTheoryPassMark")%></td>
                            <td><%=row.get("totalFullMark")%></td>
                            <td><%=row.get("totalPracticalFullMark")%></td>
                            <td><%=row.get("totalPracticalPassMark")%></td>
                            <td><%=row.get("totalPassMark")%></td>
                            <td><%=row.get("totalObtainedFullMark")%></td>
                            <td><%=row.get("totalObtainedPassMark")%></td>
                            <td><%=row.get("totalMark")%></td>
                            <td><%=row.get("grade")%></td>
                        </tr>
                    </table>
                </div>
                <!--<div style="width:35%; float:right; margin-right:10px;" class="marksheet">
                <table cellpadding="3" cellspacing="0" border="1" width="100%">
                <tr>
                <td>ACTIVITIES</td>
                <td>GRADE</td>
                </tr>
                <tr>
                <td class="td-height1">lasjf</td>
                <td class="td-height1">asf</td>
                </tr>
                </table>
                </div>-->
                <div class="parent-div">
                    <div style="width: 27%;float:left; margin-left: 10px;" class="info">
                        <table cellpadding="3" cellspacing="0" border="1" width="100%">
                            <tr>
                                <td>Attendance</td>
                                <td>32/365</td>
                            </tr>
                            <tr>
                                <td>Percentage</td>
                                <td><%=row.get("percent")%></td>
                            </tr>
                            <tr>
                                <td>Grading</td>
                                <td>N/A</td>
                            </tr>
                        </table>
                    </div>

                    <div style="width: 65%;float:right; padding-right: 1px;" class="info">
                        <table cellpadding="3" cellspacing="0" border="1" width="100%">
                            <tr>
                                <td>GRADING CRITERIA</td>
                            </tr>
                            <tr>
                                <td height="40"><p style="width: 435px;">90 Above (A+) , 80 Above (A) , 60 Above (B+)
                                        50 Above (C+) , 40 Above (C) , 20 Above (D)
                                        1 Above (E) , 0 Above (N) , </p>
                                </td>
                            </tr>

                        </table>
                    </div>
                </div>
                <div style="clear:both;">
                    <br/>
                    <br/>
                    <br/>
                </div>
                <div>
                    <h3 style="text-align:center; margin:0;"> CLASS TEACHER'S REMARKS</h3>
                    <div style="height:80px; border:1px solid black; margin:0 10px;">
                    </div>
                </div>
                <div style="clear:both;">
                     <table style="table-layout:fixed; margin:100px 10px 10px 10px; text-align:center;" width="100%" >
                        <tr>
                            <td width="(100/4)%"><span style="border-top: 1px dashed black;">&nbsp;&nbsp;&nbsp;Class Teacher&nbsp;&nbsp;&nbsp;</td>
                            <td width="(100/4)%"><span style="border-top: 1px dashed black;">&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;</td>
                            <td width="(100/4)%"><span style="border-top: 1px dashed black;">&nbsp;&nbsp;&nbsp;School Seal&nbsp;&nbsp;&nbsp;</td>
                            <td width="(100/4)%"><span style="border-top: 1px dashed black;">&nbsp;&nbsp;&nbsp;Principal&nbsp;&nbsp;&nbsp;</td>
                    </table> 
                </div>
            </div>
        </div>
<%
}  
}catch(Exception e){  }%>
                           
  

</body>
</html>
