<%@include file="../login/header.jsp" %>
 <center><h3><label><u>Bikes</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Model</label>
<input type='text' name='model' id='model'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Color</label>
<input type='text' name='color' id='color'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Engine Number</label>
<input type='text' name='engineNumber' id='engineNumber'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Chasis Number</label>
<input type='text' name='chasisNumber' id='chasisNumber'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Reg No</label>
<input type='text' name='regNo' id='regNo'  class='form-control'/>
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
<label>Entry Date</label>
<input type='text' name='entryDate' id='entryDate'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Status</label>
<input type='text' name='status' id='status'  class='form-control'/>
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
<th>Model</th>
<th>Color</th>
<th>Engine Number</th>
<th>Chasis Number</th>
<th>Reg No</th>
<th>Cost Price</th>
<th>Selling Price</th>
<th>Quantity</th>
<th>Entry Date</th>
<th>Status</th>
<th>Created Date</th>
<th>Updated Date</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.model}</td>
<td>${rst.color}</td>
<td>${rst.engineNumber}</td>
<td>${rst.chasisNumber}</td>
<td>${rst.regNo}</td>
<td>${rst.costPrice}</td>
<td>${rst.sellingPrice}</td>
<td>${rst.quantity}</td>
<td>${rst.entryDate}</td>
<td>${rst.status}</td>
<td>${rst.createdDate}</td>
<td>${rst.updatedDate}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','model','color','engineNumber','chasisNumber','regNo','costPrice','sellingPrice','quantity','entryDate','status','createdDate','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','model','color','engineNumber','chasisNumber','regNo','costPrice','sellingPrice','quantity','entryDate','status','createdDate','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"model\": \""+model+"\",\"color\": \""+color+"\",\"engineNumber\": \""+engineNumber+"\",\"chasisNumber\": \""+chasisNumber+"\",\"regNo\": \""+regNo+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"entryDate\": \""+entryDate+"\",\"status\": \""+status+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
--%>