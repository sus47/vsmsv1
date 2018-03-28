<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Parts</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Parts Number</label>
<input type='text' name='partsNumber' id='partsNumber'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Name</label>
<input type='text' name='name' id='name'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bike Id</label>
<input type='text' name='bikeId' id='bikeId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Cost Price</label>
<input type='text' name='costPrice' id='costPrice'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Selling Price</label>
<input type='text' name='sellingPrice' id='sellingPrice'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Quantity</label>
<input type='text' name='quantity' id='quantity'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Status</label>
<input type='text' name='status' id='status'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Entry Date</label>
<input type='text' name='entryDate' id='entryDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Created Date</label>
<input type='text' name='createdDate' id='createdDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Updated Date</label>
<input type='text' name='updatedDate' id='updatedDate'  class='form-control'/>
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
<th>Parts Number</th>
<th>Name</th>
<th>Bike Id</th>
<th>Cost Price</th>
<th>Selling Price</th>
<th>Quantity</th>
<th>Status</th>
<th>Entry Date</th>
<th>Created Date</th>
<th>Updated Date</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.partsNumber}</td>
<td>${rst.name}</td>
<td>${rst.bikeId}</td>
<td>${rst.costPrice}</td>
<td>${rst.sellingPrice}</td>
<td>${rst.quantity}</td>
<td>${rst.status}</td>
<td>${rst.entryDate}</td>
<td>${rst.createdDate}</td>
<td>${rst.updatedDate}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','partsNumber','name','bikeId','costPrice','sellingPrice','quantity','status','entryDate','createdDate','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','partsNumber','name','bikeId','costPrice','sellingPrice','quantity','status','entryDate','createdDate','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"partsNumber\": \""+partsNumber+"\",\"name\": \""+name+"\",\"bikeId\": \""+bikeId+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"status\": \""+status+"\",\"entryDate\": \""+entryDate+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
--%>