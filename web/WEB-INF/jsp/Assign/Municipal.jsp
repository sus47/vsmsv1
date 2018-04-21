<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Municipal</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Municipal Name</label>
<input type='text' name='municipalName' id='municipalName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>District</label>
<input type='text' name='district' id='district'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Contact Person</label>
<input type='text' name='contactPerson' id='contactPerson'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Contact No</label>
<input type='text' name='contactNo' id='contactNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Office Location</label>
<input type='text' name='officeLocation' id='officeLocation'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Mayor Name</label>
<input type='text' name='mayorName' id='mayorName'  class='form-control'/>
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
<th>Municipal Name</th>
<th>District</th>
<th>Contact Person</th>
<th>Contact No</th>
<th>Office Location</th>
<th>Mayor Name</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.municipalName}</td>
<td>${rst.district}</td>
<td>${rst.contactPerson}</td>
<td>${rst.contactNo}</td>
<td>${rst.officeLocation}</td>
<td>${rst.mayorName}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','municipalName','district','contactPerson','contactNo','officeLocation','mayorName'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','municipalName','district','contactPerson','contactNo','officeLocation','mayorName'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"municipalName\": \""+municipalName+"\",\"district\": \""+district+"\",\"contactPerson\": \""+contactPerson+"\",\"contactNo\": \""+contactNo+"\",\"officeLocation\": \""+officeLocation+"\",\"mayorName\": \""+mayorName+"\"}";
--%>