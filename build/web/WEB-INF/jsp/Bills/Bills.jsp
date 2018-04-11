<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Bills</u></label></h3></center>
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
<label>Cus Name</label>
<input type='text' name='cusName' id='cusName'  class='form-control'/>
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
<label>Org Type</label>
<input type='text' name='orgType' id='orgType'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Cus Type</label>
<input type='text' name='cusType' id='cusType'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Service Bill</label>
<input type='text' name='serviceBill' id='serviceBill'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Pan No</label>
<input type='text' name='panNo' id='panNo'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Service Times</label>
<input type='text' name='serviceTimes' id='serviceTimes'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Service Type</label>
<input type='text' name='serviceType' id='serviceType'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Invoice</label>
<input type='text' name='invoice' id='invoice'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bike Id</label>
<input type='text' name='bikeId' id='bikeId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Quantity</label>
<input type='text' name='quantity' id='quantity'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Discount</label>
<input type='text' name='discount' id='discount'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Total Sp</label>
<input type='text' name='totalSp' id='totalSp'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Vat</label>
<input type='text' name='vat' id='vat'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Net Total</label>
<input type='text' name='netTotal' id='netTotal'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Advance</label>
<input type='text' name='advance' id='advance'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Due</label>
<input type='text' name='due' id='due'  class='form-control'/>
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
<th>Cus Name</th>
<th>Address</th>
<th>Phone</th>
<th>Org Type</th>
<th>Cus Type</th>
<th>Service Bill</th>
<th>Pan No</th>
<th>Service Times</th>
<th>Service Type</th>
<th>Invoice</th>
<th>Bike Id</th>
<th>Quantity</th>
<th>Discount</th>
<th>Total Sp</th>
<th>Vat</th>
<th>Net Total</th>
<th>Advance</th>
<th>Due</th>
<th>Created Date</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.cusId}</td>
<td>${rst.cusName}</td>
<td>${rst.address}</td>
<td>${rst.phone}</td>
<td>${rst.orgType}</td>
<td>${rst.cusType}</td>
<td>${rst.serviceBill}</td>
<td>${rst.panNo}</td>
<td>${rst.serviceTimes}</td>
<td>${rst.serviceType}</td>
<td>${rst.invoice}</td>
<td>${rst.bikeId}</td>
<td>${rst.quantity}</td>
<td>${rst.discount}</td>
<td>${rst.totalSp}</td>
<td>${rst.vat}</td>
<td>${rst.netTotal}</td>
<td>${rst.advance}</td>
<td>${rst.due}</td>
<td>${rst.createdDate}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','cusId','cusName','address','phone','orgType','cusType','serviceBill','panNo','serviceTimes','serviceType','invoice','bikeId','quantity','discount','totalSp','vat','netTotal','advance','due','createdDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','cusId','cusName','address','phone','orgType','cusType','serviceBill','panNo','serviceTimes','serviceType','invoice','bikeId','quantity','discount','totalSp','vat','netTotal','advance','due','createdDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"cusId\": \""+cusId+"\",\"cusName\": \""+cusName+"\",\"address\": \""+address+"\",\"phone\": \""+phone+"\",\"orgType\": \""+orgType+"\",\"cusType\": \""+cusType+"\",\"serviceBill\": \""+serviceBill+"\",\"panNo\": \""+panNo+"\",\"serviceTimes\": \""+serviceTimes+"\",\"serviceType\": \""+serviceType+"\",\"invoice\": \""+invoice+"\",\"bikeId\": \""+bikeId+"\",\"quantity\": \""+quantity+"\",\"discount\": \""+discount+"\",\"totalSp\": \""+totalSp+"\",\"vat\": \""+vat+"\",\"netTotal\": \""+netTotal+"\",\"advance\": \""+advance+"\",\"due\": \""+due+"\",\"createdDate\": \""+createdDate+"\"}";
--%>