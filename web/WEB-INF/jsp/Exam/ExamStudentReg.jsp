<%@include file="../login/header.jsp" %>
 <center><h3><label><u>ExamStudentReg</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Academic Year</label>
<input type='text' name='academicYear' id='academicYear'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Exam Id</label>
<input type='text' name='examId' id='examId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>School Sn</label>
<input type='text' name='schoolSn' id='schoolSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Student Sn</label>
<input type='text' name='studentSn' id='studentSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Reg No</label>
<input type='text' name='regNo' id='regNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Time Of Attempt</label>
<input type='text' name='timeOfAttempt' id='timeOfAttempt'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
  
  <label id='ActionMSG'>&nbsp;</label><br>  ${msg}
<input type='submit' name='Action' id='Action' value='Save' class='btn btn-success'/>
</div>
</div>
</form> <br><br><br>
 <div class='row'>
<table class='table table-striped table-hover table-bordered' id='dataTable'>
<tr>
<th>Sn</th>
<th>Academic Year</th>
<th>Exam Id</th>
<th>School Sn</th>
<th>Student Sn</th>
<th>Reg No</th>
<th>Time Of Attempt</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.academicYear}</td>
<td>${rst.examId}</td>
<td>${rst.schoolSn}</td>
<td>${rst.studentSn}</td>
<td>${rst.regNo}</td>
<td>${rst.timeOfAttempt}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','academicYear','examId','schoolSn','studentSn','regNo','timeOfAttempt'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','academicYear','examId','schoolSn','studentSn','regNo','timeOfAttempt'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"academicYear\": \""+academicYear+"\",\"examId\": \""+examId+"\",\"schoolSn\": \""+schoolSn+"\",\"studentSn\": \""+studentSn+"\",\"regNo\": \""+regNo+"\",\"timeOfAttempt\": \""+timeOfAttempt+"\"}";
--%>