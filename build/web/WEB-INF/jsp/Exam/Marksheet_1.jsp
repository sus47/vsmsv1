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

        <div class="content">
            <div class="content-heading" style="width:780px; height: 1220px; border:1px solid;">
                <table style="width:780px; border-bottom:1px solid black">
                    <tr>
                        <td rowspan="4" width="100px" height="100px"><div style="height:100px; width: 100px; border: 1px solid black; text-align:center;">Logo</div></td>
                        <td style="text-align:center;"><h1>${schoolName}</h1></td>
                    </tr>
                    <tr>


                        <td class="heading">${address}</td>
                    </tr>
                    <tr>

                        <td class="heading">Phone : ${contactNo}</td>
                    </tr>
                    <tr>
                        <td class="heading" style="font-size:21px; padding-top: 9px;">${examName}</td>
                    </tr>
                </table>
                <!--$ql}-->
                <table width="100%">
                    <tr>
                        <td style="text-align:left;"> Student Name:- &nbsp; <b>${studentName}</b></td>
                        <td style="text-align:right;"> Student Id:- <b> ${studentId}</b></td>
                    </tr>
                    <tr>
                        <td style="text-align:left;"> Father Name:- &nbsp; <b>${fatherName}</b></td>
                        <td style="text-align:right;"> Mother Name:- <b> ${motherName}</b></td>
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
                            int i = 1;
                        %>
                        <c:forEach items="${subjectMark}" var="Rs">
                            <%
                                i++;
                            %>
                            <tr style="height: 25px;">
                                <td >${Rs.subjectName}</td>
                                <td >${Rs.thFm}</td>
                                <td >${Rs.phFm}</td>
                                <td >${Rs.thFm+ Rs.phFm}</td>
                                <td >${Rs.thPm}</td>
                                <td >${Rs.phPm}</td>
                                <td >${Rs.thPm+Rs.phPm}</td>
                                <td >${Rs.thOm}</td>
                                <td >${Rs.phOm}</td>
                                <td >${Rs.thOm+Rs.phOm}</td>
                                <td>${Rs.grade}</td>

                            </tr>
                        </c:forEach>
                        <%
                            for (; i < 20; i++) {
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
                            <td>${totalTheoryFullMark}</td>
                            <td>${totalTheoryPassMark}</td>
                            <td>${totalFullMark}</td>
                            <td>${totalPracticalFullMark}</td>
                            <td>${totalPracticalPassMark}</td>
                            <td>${totalPassMark}</td>
                            <td>${totalObtainedFullMark}</td>
                            <td>${totalObtainedPassMark}</td>
                            <td>${totalMark}</td>
                            <td>${grade}</td>
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
                                <td>${percent}%</td>
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
    </div>

</body>
</html>
