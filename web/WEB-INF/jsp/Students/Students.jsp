<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Students</u></label></h3></center>
 
 <a href="../marksheet/MS131.pdf">dfdfdfd</a>
<form method='POST'> 
<div class="row">

<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Academic Year</label>
<input type='text' name='academicYear' id='academicYear'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>School Id</label>
<input type='text' name='schoolId' id='schoolId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>School Grade</label>
<input type='text' name='schoolGrade' id='schoolGrade'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>School Roll</label>
<input type='text' name='schoolRoll' id='schoolRoll'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Reg No</label>
<input type='text' name='regNo' id='regNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Symbol No</label>
<input type='text' name='symbolNo' id='symbolNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Student Name</label>
<input type='text' name='studentName' id='studentName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Name Nepali</label>
<input type='text' name='nameNepali' id='nameNepali'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Dob Ad</label>
<input type='text' name='dobAd' id='dobAd'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Dob Bs</label>
<input type='text' name='dobBs' id='dobBs'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
  
  <label id='ActionMSG'>&nbsp;</label><br>  ${msg}  ${msg1}  ${msg2}
<input type='submit' name='Action' id='Action' value='Save' class='btn btn-success'/>
</div>
</div>
</form> <br><br><br>
 <div class='row'>
<table class='table table-striped table-hover table-bordered' id='dataTable'>
<tr>
<th>Sn</th>
<th>Academic Year</th>
<th>School Id</th>
<th>School Grade</th>
<th>School Roll</th>
<th>Reg No</th>
<th>Symbol No</th>
<th>Student Name</th>
<th>Name Nepali</th>
<th>Dob Ad</th>
<th>Dob Bs</th>
<th>Action</th>
</tr> 
<%--
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.academicYear}</td>
<td>${rst.schoolId}</td>
<td>${rst.schoolGrade}</td>
<td>${rst.schoolRoll}</td>
<td>${rst.regNo}</td>
<td>${rst.symbolNo}</td>
<td>${rst.studentName}</td>
<td>${rst.nameNepali}</td>
<td>${rst.dobAd}</td>
<td>${rst.dobBs}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
--%>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','academicYear','schoolId','schoolGrade','schoolRoll','regNo','symbolNo','studentName','nameNepali','dobAd','dobBs'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','academicYear','schoolId','schoolGrade','schoolRoll','regNo','symbolNo','studentName','nameNepali','dobAd','dobBs'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"academicYear\": \""+academicYear+"\",\"schoolId\": \""+schoolId+"\",\"schoolGrade\": \""+schoolGrade+"\",\"schoolRoll\": \""+schoolRoll+"\",\"regNo\": \""+regNo+"\",\"symbolNo\": \""+symbolNo+"\",\"studentName\": \""+studentName+"\",\"nameNepali\": \""+nameNepali+"\",\"dobAd\": \""+dobAd+"\",\"dobBs\": \""+dobBs+"\"}";
--%>