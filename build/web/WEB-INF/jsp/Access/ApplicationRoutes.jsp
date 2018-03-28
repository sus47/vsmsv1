<%@include file="../login/header.jsp" %>
 <center><h3><label><u>ApplicationRoutes</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Route Id</label>
<input type='text' name='routeId' id='routeId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Route Name</label>
<input type='text' name='routeName' id='routeName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Method</label>
<input type='text' name='method' id='method'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Path</label>
<input type='text' name='path' id='path'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Action Name</label>
<input type='text' name='actionName' id='actionName'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Permission Id</label>
<input type='text' name='permissionId' id='permissionId'  class='form-control'/>
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
<th>Route Id</th>
<th>Route Name</th>
<th>Method</th>
<th>Path</th>
<th>Action Name</th>
<th>Permission Id</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.routeId}</td>
<td>${rst.routeName}</td>
<td>${rst.method}</td>
<td>${rst.path}</td>
<td>${rst.actionName}</td>
<td>${rst.permissionId}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['routeId','routeName','method','path','actionName','permissionId'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['routeId','routeName','method','path','actionName','permissionId'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"routeId\": \""+routeId+"\",\"routeName\": \""+routeName+"\",\"method\": \""+method+"\",\"path\": \""+path+"\",\"actionName\": \""+actionName+"\",\"permissionId\": \""+permissionId+"\"}";
--%>