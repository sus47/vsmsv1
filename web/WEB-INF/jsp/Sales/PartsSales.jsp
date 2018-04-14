<%@include file="../login/header.jsp" %>
 <center><h3><label><u>PartsSales</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Customer Id</label>
<input type='text' name='customerId' id='customerId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Parts Id</label>
<input type='text' name='partsId' id='partsId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Price</label>
<input type='text' name='price' id='price'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Quantity</label>
<input type='text' name='quantity' id='quantity'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sold By</label>
<input type='text' name='soldBy' id='soldBy'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sold Date</label>
<input type='text' name='soldDate' id='soldDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Discount</label>
<input type='text' name='discount' id='discount'  class='form-control'/>
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
<th>Sn</th>
<th>Customer Id</th>
<th>Parts Id</th>
<th>Price</th>
<th>Quantity</th>
<th>Sold By</th>
<th>Sold Date</th>
<th>Discount</th>
<th>Invoice</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.customerId}</td>
<td>${rst.partsId}</td>
<td>${rst.price}</td>
<td>${rst.quantity}</td>
<td>${rst.soldBy}</td>
<td>${rst.soldDate}</td>
<td>${rst.discount}</td>
<td>${rst.invoice}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','customerId','partsId','price','quantity','soldBy','soldDate','discount','invoice'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','customerId','partsId','price','quantity','soldBy','soldDate','discount','invoice'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"customerId\": \""+customerId+"\",\"partsId\": \""+partsId+"\",\"price\": \""+price+"\",\"quantity\": \""+quantity+"\",\"soldBy\": \""+soldBy+"\",\"soldDate\": \""+soldDate+"\",\"discount\": \""+discount+"\",\"invoice\": \""+invoice+"\"}";
--%>