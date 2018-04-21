<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Customers</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Id</label>
<input type='text' name='id' id='id'  class='form-control'/>
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
<label>Pan</label>
<input type='text' name='pan' id='pan'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bikes Id</label>
<input type='text' name='bikesId' id='bikesId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Payment</label>
<input type='text' name='payment' id='payment'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Due Amount</label>
<input type='text' name='dueAmount' id='dueAmount'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Invoice</label>
<input type='text' name='invoice' id='invoice'  class='form-control'/>
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
<th>Id</th>
<th>Name</th>
<th>Address</th>
<th>Phone</th>
<th>Pan</th>
<th>Bikes Id</th>
<th>Payment</th>
<th>Due Amount</th>
<th>Invoice</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.id}</td>
<td>${rst.name}</td>
<td>${rst.address}</td>
<td>${rst.phone}</td>
<td>${rst.pan}</td>
<td>${rst.bikesId}</td>
<td>${rst.payment}</td>
<td>${rst.dueAmount}</td>
<td>${rst.invoice}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['id','name','address','phone','pan','bikesId','payment','dueAmount','invoice'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['id','name','address','phone','pan','bikesId','payment','dueAmount','invoice'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"id\": \""+id+"\",\"name\": \""+name+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"pan\": \""+pan+"\",\"bikesId\": \""+bikesId+"\",\"payment\": \""+payment+"\",\"dueAmount\": \""+dueAmount+"\",\"invoice\": \""+invoice+"\"}";
--%>