
<%@page import="java.util.Date"%>
<%@include file="../login/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sample Invoice</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <style>
            @import url(http://fonts.googleapis.com/css?family=Bree+Serif);
            body, h1, h2, h3, h4, h5, h6{
                font-family: 'Bree Serif', serif;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <c:forEach items="${billData}" var="bill">
            <div class="row">
                <div class="col-xs-12">

                    <div class="company col-xs-1">
                        <img src="logo.png">
                    </div>
                    <div class="company text-left col-xs-8">
                        <p style="font-size:17px;">
                            TBS Showroom and Bikes Pvt Ltd
                            <br/>
                            Ratamata-06, Sindhuli, Nepal.<br/>
                            Phone: 047-9282662, Fax:9827929
                        </p>
                    </div>
                    <div class="col-xs-3 text-center">
                        <p>
                            Invoice: ${bill.invoice}<br/>
                            CustomerID: ${bill.cusId}<br/>
                            Date: <%
                                Date date = new Date();
                                out.print(date);%></p>
                    </div>

                </div>

            </div>
            <div class="col-xs-12 text-center" style="border-bottom: 1px solid black; border-top: 1px solid black;">
                <h4>INVOICE</h4>
            </div>

            <div class="row">
                <div class="col-xs-5">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="padding: 0;">
                            <p style="font-size:16px;">Customer Name: ${bill.cusName}</h4>
                        </div>
                        <div class="panel-body" style="padding:0;">
                            <p>
                                ${bill.address} <br>
                                Phone: ${bill.phone} <br>
                                <span class="pan">PAN No/VAT No: ${bill.panNo} </span><br>
                            </p>
                        </div>
                    </div>
                </div>
            
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>
                            <h4>S.N.</h4>
                        </th>
                        <th>
                            <h4>Code</h4>
                        </th>
                        <th>
                            <h4>Description</h4>
                        </th>
                        <th>
                            <h4>Qty./Hrs.</h4>
                        </th>
                        <th>
                            <h4>Price/Rate</h4>
                        </th>
                        <th>
                            <h4>Discount</h4>
                        </th>
                        <th>
                            <h4>Total</h4>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${counter.count}</td>
<!--                        <td><a href="#">
                               <% //${bill.partName}%>
                            </a></td>-->
                        <td class="text-right">${bill.quantity}</td>
<!--                        <td class="text-right">
                            <%//${bill.price}%>
                        </td>-->
                        <td class="text-right">${bill.discount}</td>
                        <td class="text-right">${bill.totalSp}</td>
                    </tr>
                </tbody>
            </table>
            <div class="row text-right" >
                <div class="col-xs-8 text-left " style="left: 15px;border: 1px solid black; height: 100px;">
                    <p>    <strong>Amount in words: </strong><br>
                    </p>

                </div>
                <div class="col-xs-2 ">
                    <p>
                        <strong>
                            Gross Total : <br>
                            <span class="pan">VAT@13%: <br></span>
                            Total : <br>
                            Advance: <br>
                            Due Amount: <br>
                        </strong>
                    </p>
                </div>
                <div class="col-xs-2 text-left" >
                    Rs.190.00 <br>
                    N/A <br>
                    Rs.190.00 <br>
                    Rs.100.00 <br>
                    Rs.90.00 <br>
                </div>
            </div>
            <div class="row" style="border-top: 1px solid black;">
                <div class="col-xs-12">
                    
                        <div class="panel-heading" style="padding:0px;">
                            <p>Notice*:&nbsp; Goods once sold will not be taken back.</p>
                        </div>
                </div>
            </div>
                    </c:forEach>
        </div>
                    
    </body>
</html>
