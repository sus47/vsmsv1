<%@include file="../login/header.jsp" %>
 <center><h3><label><u>StudentsGeneralInfo</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Permanent Street</label>
<input type='text' name='permanentStreet' id='permanentStreet'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Permanent Municipal</label>
<input type='text' name='permanentMunicipal' id='permanentMunicipal'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Permanent Ward No</label>
<input type='text' name='permanentWardNo' id='permanentWardNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Permanent District</label>
<input type='text' name='permanentDistrict' id='permanentDistrict'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Temporary Address</label>
<input type='text' name='temporaryAddress' id='temporaryAddress'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Contact No</label>
<input type='text' name='contactNo' id='contactNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Contact Email</label>
<input type='text' name='contactEmail' id='contactEmail'  class='form-control'/>
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
<th>Permanent Street</th>
<th>Permanent Municipal</th>
<th>Permanent Ward No</th>
<th>Permanent District</th>
<th>Temporary Address</th>
<th>Contact No</th>
<th>Contact Email</th>
<th>Student Sn</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.permanentStreet}</td>
<td>${rst.permanentMunicipal}</td>
<td>${rst.permanentWardNo}</td>
<td>${rst.permanentDistrict}</td>
<td>${rst.temporaryAddress}</td>
<td>${rst.contactNo}</td>
<td>${rst.contactEmail}</td>
<td>${rst.studentSn}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','permanentStreet','permanentMunicipal','permanentWardNo','permanentDistrict','temporaryAddress','contactNo','contactEmail','studentSn'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','permanentStreet','permanentMunicipal','permanentWardNo','permanentDistrict','temporaryAddress','contactNo','contactEmail','studentSn'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"permanentStreet\": \""+permanentStreet+"\",\"permanentMunicipal\": \""+permanentMunicipal+"\",\"permanentWardNo\": \""+permanentWardNo+"\",\"permanentDistrict\": \""+permanentDistrict+"\",\"temporaryAddress\": \""+temporaryAddress+"\",\"contactNo\": \""+contactNo+"\",\"contactEmail\": \""+contactEmail+"\",\"studentSn\": \""+studentSn+"\"}";
--%>