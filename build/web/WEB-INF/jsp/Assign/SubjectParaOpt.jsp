<%@include file="../login/header.jsp" %>
 <center><h3><label><u>SubjectParaOpt</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Course Group</label>
<input type='text' name='courseGroup' id='courseGroup'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Class Id</label>
<input type='text' name='classId' id='classId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sub Code</label>
<input type='text' name='subCode' id='subCode'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sub Name</label>
<input type='text' name='subName' id='subName'  class='form-control'/>
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
  
  <label id='ActionMSG'>&nbsp;</label><br>  ${msg}
<input type='submit' name='Action' id='Action' value='Save' class='btn btn-success'/>
</div>
</div>
</form> <br><br><br>
 <div class='row'>
<table class='table table-striped table-hover table-bordered' id='dataTable'>
<tr>
<th>Sn</th>
<th>Course Group</th>
<th>Class Id</th>
<th>Sub Code</th>
<th>Sub Name</th>
<th>Th Fm</th>
<th>Th Pm</th>
<th>Ph Fm</th>
<th>Ph Pm</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.courseGroup}</td>
<td>${rst.classId}</td>
<td>${rst.subCode}</td>
<td>${rst.subName}</td>
<td>${rst.thFm}</td>
<td>${rst.thPm}</td>
<td>${rst.phFm}</td>
<td>${rst.phPm}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','courseGroup','classId','subCode','subName','thFm','thPm','phFm','phPm'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','courseGroup','classId','subCode','subName','thFm','thPm','phFm','phPm'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"courseGroup\": \""+courseGroup+"\",\"classId\": \""+classId+"\",\"subCode\": \""+subCode+"\",\"subName\": \""+subName+"\",\"thFm\": \""+thFm+"\",\"thPm\": \""+thPm+"\",\"phFm\": \""+phFm+"\",\"phPm\": \""+phPm+"\"}";
--%>