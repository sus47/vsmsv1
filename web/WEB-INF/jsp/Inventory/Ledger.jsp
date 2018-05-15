<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Ledger</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Cus Id</label>
<input type='text' name='cusId' id='cusId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Staff Id</label>
<input type='text' name='staffId' id='staffId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Description</label>
<input type='text' name='description' id='description'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Debit</label>
<input type='text' name='debit' id='debit'  class='form-control'/>
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
  
  <label id='ActionMSG'>&nbsp;</label><br>  ${msg}
<input type='submit' name='Action' id='Action' value='Save' class='btn btn-success'/>
</div>
</div>
</form> <br><br><br>
 <div class='row'>
<table class='table table-striped table-hover table-bordered' id='dataTable'>
<tr>
<th>Sn</th>
<th>Cus Id</th>
<th>Staff Id</th>
<th>Description</th>
<th>Debit</th>
<th>Credit</th>
<th>Created Date</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.cusId}</td>
<td>${rst.staffId}</td>
<td>${rst.description}</td>
<td>${rst.debit}</td>
<td>${rst.credit}</td>
<td>${rst.createdDate}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','cusId','staffId','description','debit','credit','createdDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','cusId','staffId','description','debit','credit','createdDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"cusId\": \""+cusId+"\",\"staffId\": \""+staffId+"\",\"description\": \""+description+"\",\"debit\": \""+debit+"\",\"credit\": \""+credit+"\",\"createdDate\": \""+createdDate+"\"}";
--%>