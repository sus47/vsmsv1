<%@include file="../login/header.jsp" %>
 <center><h3><label><u>ApplicationUser</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>User Code</label>
<input type='text' name='userCode' id='userCode'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>User Name</label>
<input type='text' name='userName' id='userName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>School Id</label>
<input type='text' name='schoolId' id='schoolId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>User Password</label>
<input type='text' name='userPassword' id='userPassword'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Email</label>
<input type='text' name='email' id='email'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Mobile</label>
<input type='text' name='mobile' id='mobile'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Last Login</label>
<input type='text' name='lastLogin' id='lastLogin'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Token</label>
<input type='text' name='token' id='token'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Status</label>
<input type='text' name='status' id='status'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Municipal</label>
<input type='text' name='municipal' id='municipal'  class='form-control'/>
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
<th>User Code</th>
<th>User Name</th>
<th>School Id</th>
<th>User Password</th>
<th>Email</th>
<th>Mobile</th>
<th>Last Login</th>
<th>Token</th>
<th>Status</th>
<th>Municipal</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.userCode}</td>
<td>${rst.userName}</td>
<td>${rst.schoolId}</td>
<td>${rst.userPassword}</td>
<td>${rst.email}</td>
<td>${rst.mobile}</td>
<td>${rst.lastLogin}</td>
<td>${rst.token}</td>
<td>${rst.status}</td>
<td>${rst.municipal}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['userCode','userName','schoolId','userPassword','email','mobile','lastLogin','token','status','municipal'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['userCode','userName','schoolId','userPassword','email','mobile','lastLogin','token','status','municipal'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"userCode\": \""+userCode+"\",\"userName\": \""+userName+"\",\"schoolId\": \""+schoolId+"\",\"userPassword\": \""+userPassword+"\",\"email\": \""+email+"\",\"mobile\": \""+mobile+"\",\"lastLogin\": \""+lastLogin+"\",\"token\": \""+token+"\",\"status\": \""+status+"\",\"municipal\": \""+municipal+"\"}";
--%>