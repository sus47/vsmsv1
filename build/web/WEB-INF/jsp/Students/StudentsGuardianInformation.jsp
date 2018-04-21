<%@include file="../login/header.jsp" %>
 <center><h3><label><u>StudentsGuardianInformation</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Father Name</label>
<input type='text' name='fatherName' id='fatherName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Father Contact No</label>
<input type='text' name='fatherContactNo' id='fatherContactNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Father Email</label>
<input type='text' name='fatherEmail' id='fatherEmail'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Father Occupation</label>
<input type='text' name='fatherOccupation' id='fatherOccupation'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Mother Name</label>
<input type='text' name='motherName' id='motherName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Mother Contact No</label>
<input type='text' name='motherContactNo' id='motherContactNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Local Guardian Name</label>
<input type='text' name='localGuardianName' id='localGuardianName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Local Guardian Contact No</label>
<input type='text' name='localGuardianContactNo' id='localGuardianContactNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Local Guardion Email</label>
<input type='text' name='localGuardionEmail' id='localGuardionEmail'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Student Sn</label>
<input type='text' name='studentSn' id='studentSn'  class='form-control'/>
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
<th>Father Name</th>
<th>Father Contact No</th>
<th>Father Email</th>
<th>Father Occupation</th>
<th>Mother Name</th>
<th>Mother Contact No</th>
<th>Local Guardian Name</th>
<th>Local Guardian Contact No</th>
<th>Local Guardion Email</th>
<th>Student Sn</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.fatherName}</td>
<td>${rst.fatherContactNo}</td>
<td>${rst.fatherEmail}</td>
<td>${rst.fatherOccupation}</td>
<td>${rst.motherName}</td>
<td>${rst.motherContactNo}</td>
<td>${rst.localGuardianName}</td>
<td>${rst.localGuardianContactNo}</td>
<td>${rst.localGuardionEmail}</td>
<td>${rst.studentSn}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','fatherName','fatherContactNo','fatherEmail','fatherOccupation','motherName','motherContactNo','localGuardianName','localGuardianContactNo','localGuardionEmail','studentSn'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','fatherName','fatherContactNo','fatherEmail','fatherOccupation','motherName','motherContactNo','localGuardianName','localGuardianContactNo','localGuardionEmail','studentSn'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"fatherName\": \""+fatherName+"\",\"fatherContactNo\": \""+fatherContactNo+"\",\"fatherEmail\": \""+fatherEmail+"\",\"fatherOccupation\": \""+fatherOccupation+"\",\"motherName\": \""+motherName+"\",\"motherContactNo\": \""+motherContactNo+"\",\"localGuardianName\": \""+localGuardianName+"\",\"localGuardianContactNo\": \""+localGuardianContactNo+"\",\"localGuardionEmail\": \""+localGuardionEmail+"\",\"studentSn\": \""+studentSn+"\"}";
--%>