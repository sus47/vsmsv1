<%@include file="../login/header.jsp" %>
 <center><h3><label><u>ExamSubject</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Subject Com Sn</label>
<input type='text' name='subjectComSn' id='subjectComSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Subject Opt Sn</label>
<input type='text' name='subjectOptSn' id='subjectOptSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Exam Id Es Reg</label>
<input type='text' name='examIdEsReg' id='examIdEsReg'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Grading Type</label>
<input type='text' name='gradingType' id='gradingType'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Th Fm</label>
<input type='text' name='thFm' id='thFm'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Th Pm</label>
<input type='text' name='thPm' id='thPm'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Ph Fm</label>
<input type='text' name='phFm' id='phFm'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Ph Pm</label>
<input type='text' name='phPm' id='phPm'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>In Order</label>
<input type='text' name='inOrder' id='inOrder'  class='form-control'/>
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
<th>Subject Com Sn</th>
<th>Subject Opt Sn</th>
<th>Exam Id Es Reg</th>
<th>Grading Type</th>
<th>Th Fm</th>
<th>Th Pm</th>
<th>Ph Fm</th>
<th>Ph Pm</th>
<th>In Order</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.subjectComSn}</td>
<td>${rst.subjectOptSn}</td>
<td>${rst.examIdEsReg}</td>
<td>${rst.gradingType}</td>
<td>${rst.thFm}</td>
<td>${rst.thPm}</td>
<td>${rst.phFm}</td>
<td>${rst.phPm}</td>
<td>${rst.inOrder}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','subjectComSn','subjectOptSn','examIdEsReg','gradingType','thFm','thPm','phFm','phPm','inOrder'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','subjectComSn','subjectOptSn','examIdEsReg','gradingType','thFm','thPm','phFm','phPm','inOrder'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"subjectComSn\": \""+subjectComSn+"\",\"subjectOptSn\": \""+subjectOptSn+"\",\"examIdEsReg\": \""+examIdEsReg+"\",\"gradingType\": \""+gradingType+"\",\"thFm\": \""+thFm+"\",\"thPm\": \""+thPm+"\",\"phFm\": \""+phFm+"\",\"phPm\": \""+phPm+"\",\"inOrder\": \""+inOrder+"\"}";
--%>