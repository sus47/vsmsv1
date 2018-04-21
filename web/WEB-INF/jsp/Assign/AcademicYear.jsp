<%@include file="../login/header.jsp" %>
 <center><h3><label><u>AcademicYear</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Academic Year</label>
<input type='text' name='academicYear' id='academicYear'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Ad Start Date</label>
<input type='text' name='adStartDate' id='adStartDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Ad End Date</label>
<input type='text' name='adEndDate' id='adEndDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bs Start Date</label>
<input type='text' name='bsStartDate' id='bsStartDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bs End Date</label>
<input type='text' name='bsEndDate' id='bsEndDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Status</label>
<input type='text' name='status' id='status'  class='form-control'/>
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
<th>Academic Year</th>
<th>Ad Start Date</th>
<th>Ad End Date</th>
<th>Bs Start Date</th>
<th>Bs End Date</th>
<th>Status</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.academicYear}</td>
<td>${rst.adStartDate}</td>
<td>${rst.adEndDate}</td>
<td>${rst.bsStartDate}</td>
<td>${rst.bsEndDate}</td>
<td>${rst.status}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['academicYear','adStartDate','adEndDate','bsStartDate','bsEndDate','status'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['academicYear','adStartDate','adEndDate','bsStartDate','bsEndDate','status'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"academicYear\": \""+academicYear+"\",\"adStartDate\": \""+adStartDate+"\",\"adEndDate\": \""+adEndDate+"\",\"bsStartDate\": \""+bsStartDate+"\",\"bsEndDate\": \""+bsEndDate+"\",\"status\": \""+status+"\"}";
--%>