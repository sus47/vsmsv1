<%@include file="../login/header.jsp" %>
         <h3><label><u>Generate Ad Bs Calender</u></label></h3>
<form  method="post">
<div class="row">
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Baisakh</label>
        <input type="number" name="MM1" class="form-control" placeholder="31" required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Jesth</label>
        <input type="number" name="MM2" class="form-control" placeholder="31" required >
    </div>

    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Ashar</label>
        <input type="number" name="MM3" class="form-control" placeholder="31"  required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Shrawan</label>
        <input type="number" name="MM4" class="form-control" placeholder="31" required >
    </div>

    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Bhadra</label>
        <input type="number" name="MM5" class="form-control" placeholder="31" required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Ashoj</label>
        <input type="number" name="MM6" class="form-control" placeholder="31" required >
    </div>
</div>
<div class="row">
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Kartik</label>
        <input type="number" name="MM7" class="form-control" placeholder="30" required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Marsir</label>
        <input type="number" name="MM8" class="form-control" placeholder="30" required >
    </div>

    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Push</label>
        <input type="number" name="MM9" class="form-control" placeholder="30" required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Magha</label>
        <input type="number" name="MM10" class="form-control" placeholder="30" required >
    </div>

    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Falgun</label>
        <input type="number" name="MM11" class="form-control" placeholder="30" required >
    </div>
    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6">
        <label>Chaitra</label>
        <input type="number" name="MM12" placeholder="30"  class="form-control" required >
    </div>
</div>
<div class="row">
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
        <label>Bs Start Date</label>
        <input type="text" name="BS" placeholder="yyyy-MM-dd"  class="form-control" required >
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
        <label>AD Start Date</label>
        <input type="text" name="AD" placeholder="yyyy-MM-dd" class="form-control" required >
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
        <label>&nbsp;</label><br>
        <input type="submit" name="Action" class="btn btn-success" value="Generate">
    </div>
</div>
</form>
                     ${Action}
<br><br>
<div class='row'>
<%--<table class='table table-striped table-hover table-bordered' id='dataTable'>
<tr>
<th>Ad Date</th>
<th>Bs Date</th>
<th>Day</th>
</tr> 

<c:forEach  var="rst" items="${msg}" varStatus="i" >
 <tr> 
<td>${rst.adDate}</td>
<td>${rst.bsDate}</td>
<td>${rst.day}</td>
 </tr>
 </c:forEach>
  </table>--%>
<%@include file="../login/footer.jsp" %>