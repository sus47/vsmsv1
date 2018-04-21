<%@include file="../login/header.jsp" %>
 <center><h3><label><u>BikePriceUpdates</u></label></h3></center>
<form method='POST'> 
<div class="row">
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Bike Id</label>
<input type='text' name='bikeId' id='bikeId'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>Old Price</label>
<input type='text' name='oldPrice' id='oldPrice'  class='form-control'/>
</div>
<div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
<label>New Price</label>
<input type='text' name='newPrice' id='newPrice'  class='form-control'/>
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
<th>Bike Id</th>
<th>Old Price</th>
<th>New Price</th>
<th>Updated Date</th>
<th>Action</th>
</tr> 
<c:forEach  var="rst" items="${Record}" varStatus="i" >
 <tr> 
<td>${rst.sn}</td>
<td>${rst.bikeId}</td>
<td>${rst.oldPrice}</td>
<td>${rst.newPrice}</td>
<td>${rst.updatedDate}</td>
<td><a onclick='edit(${i.index+1})' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(${i.index+1})' class='glyphicon glyphicon-remove-circle'></a></td>
 </tr>
 </c:forEach>
  </table>
</div> <script>
function edit(sn){
var id = ['sn','bikeId','oldPrice','newPrice','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Update';
document.getElementById('ActionMSG').innerHTML='&nbsp;';
document.getElementById('Action').focus();
}
function recordDelete(sn){
var id = ['sn','bikeId','oldPrice','newPrice','updatedDate'];
for( var i=0;i<id.length;i++)
document.getElementById(id[i]).value=document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
document.getElementById('Action').value='Delete'; 
document.getElementById('ActionMSG').innerHTML='Are You Sure';
document.getElementById('Action').focus();
}</script>
<%@include file="../login/footer.jsp" %>



<%--
return "\n{\"sn\": \""+sn+"\",\"bikeId\": \""+bikeId+"\",\"oldPrice\": \""+oldPrice+"\",\"newPrice\": \""+newPrice+"\",\"updatedDate\": \""+updatedDate+"\"}";
--%>