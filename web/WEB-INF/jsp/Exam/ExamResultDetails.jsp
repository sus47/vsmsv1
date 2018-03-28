<%@include file="../login/header.jsp" %>
 <center><h3><label><u>ExamResultDetails</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Mark Id</label>
<input type='text' name='markId' id='markId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Exam Subject Sn</label>
<input type='text' name='examSubjectSn' id='examSubjectSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Exam Result Sn</label>
<input type='text' name='examResultSn' id='examResultSn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Th Om</label>
<input type='text' name='thOm' id='thOm'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Ph Om</label>
<input type='text' name='phOm' id='phOm'  class='form-control'/>
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
<th>Mark Id</th>
<th>Exam Subject Sn</th>
<th>Exam Result Sn</th>
<th>Th Om</th>
<th>Ph Om</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.markId}</td>
<td>${rst.examSubjectSn}</td>
<td>${rst.examResultSn}</td>
<td>${rst.thOm}</td>
<td>${rst.phOm}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['markId','examSubjectSn','examResultSn','thOm','phOm'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['markId','examSubjectSn','examResultSn','thOm','phOm'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"markId\": \""+markId+"\",\"examSubjectSn\": \""+examSubjectSn+"\",\"examResultSn\": \""+examResultSn+"\",\"thOm\": \""+thOm+"\",\"phOm\": \""+phOm+"\"}";
--%>