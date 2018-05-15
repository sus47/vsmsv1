<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Staffs</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Staff Id</label>
<input type='text' name='staffId' id='staffId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Name</label>
<input type='text' name='name' id='name'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Address</label>
<input type='text' name='address' id='address'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Phone</label>
<input type='text' name='phone' id='phone'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Joined Date</label>
<input type='text' name='joinedDate' id='joinedDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Salary</label>
<input type='text' name='salary' id='salary'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Attendance</label>
<input type='text' name='attendance' id='attendance'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Credit</label>
<input type='text' name='credit' id='credit'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Created Date</label>
<input type='text' name='createdDate' id='createdDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Post</label>
<input type='text' name='post' id='post'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Type</label>
<input type='text' name='type' id='type'  class='form-control'/>
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
<th>Staff Id</th>
<th>Name</th>
<th>Address</th>
<th>Phone</th>
<th>Joined Date</th>
<th>Salary</th>
<th>Attendance</th>
<th>Credit</th>
<th>Created Date</th>
<th>Post</th>
<th>Type</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.staffId}</td>
<td>${rst.name}</td>
<td>${rst.address}</td>
<td>${rst.phone}</td>
<td>${rst.joinedDate}</td>
<td>${rst.salary}</td>
<td>${rst.attendance}</td>
<td>${rst.credit}</td>
<td>${rst.createdDate}</td>
<td>${rst.post}</td>
<td>${rst.type}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','staffId','name','address','phone','joinedDate','salary','attendance','credit','createdDate','post','type'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','staffId','name','address','phone','joinedDate','salary','attendance','credit','createdDate','post','type'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"staffId\": \""+staffId+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"joinedDate\": \""+joinedDate+"\",\"salary\": \""+salary+"\",\"attendance\": \""+attendance+"\",\"credit\": \""+credit+"\",\"createdDate\": \""+createdDate+"\",\"post\": \""+post+"\",\"type\": \""+type+"\"}";
--%>