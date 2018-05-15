
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
<<<<<<< HEAD
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
=======
        <link rel="stylesheet" href="css/bootstrap.css">
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
        <style>
            @import url(http://fonts.googleapis.com/css?family=Bree+Serif);
            body, h1, h2, h3, h4, h5, h6{
                font-family: 'Bree Serif', serif;
            }
        </style>
        <style type="text/css" media="print">
            body{
                font-size:xx-small;
            }    
        </style>
    </head>

    <body>
        <div class="container">
<<<<<<< HEAD
            <%--<c:forEach items="${billData}" var="bill">--%>
=======
            <c:forEach items="${billData}" var="bill">
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
                <div class="row">
                    <div class="col-xs-12">

                        <div class="company col-xs-1">
<<<<<<< HEAD
                            <img src="<c:url value="../resources/logo.png"/>" alt="company logo"/>
                            <img src="${pageContext.request.contextPath}/resources/logo.png" alt="company logo"/>
                        </div>
                        <div class="company text-left col-xs-8">
                            <p style="font-size:17px;">
                                Bishnu Auto
                                <br/>
                                Kamalamai-6, Sindhuli<br/>
                                Ph: 047520714 / &nbsp; Cell: 9844042635, 9814829354<br/>
                                Email: bishnuauto9@gmail.com

=======
                            <img src="logo.png">
                        </div>
                        <div class="company text-left col-xs-8">
                            <p style="font-size:17px;">
                                TBS Showroom and Bikes Pvt Ltd
                                <br/>
                                Ratamata-06, Sindhuli, Nepal.<br/>
                                Phone: 047-9282662, Fax:9827929
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
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
                        <c:forEach items="${data}" var="data" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td><a href="#">
                                        ${data.code}
                                    </a></td>
                                <td class="text-right">${data.description}</td>
                                <td class="text-right">
                                    ${data.quantity}
                                </td>
                                <td class="text-right">${data.rate}</td>
                                <td class="text-right">${data.discount}</td>
                                <td class="text-right">${data.totalSp}</td>
                            </tr>
                        </c:forEach>>
                    </tbody>
                </table>

                <div class="row text-right" >
                    <div class="col-xs-8 text-left " style="left: 15px;border: 1px solid black; height: 100px;">
                        <p>    <strong>Amount in words: </strong>
                        </p>
                        <p id="amountWord"></p>

                    </div>
                    <div class="col-xs-2 ">
                        <p>
                            <strong>
                                Gross Total :<br>
                                <span class="pan">VAT@13%: <br></span>
                                Total : <br>
                                Advance: <br>
                                Due Amount: <br>
                            </strong>
                        </p>
                    </div>
                    <div class="col-xs-2 text-left" >
                        Rs. ${bill.total} <br>
                        Rs. ${bill.vat} <br>
                        Rs. ${bill.netTotal} <br>
                        Rs. ${bill.advance}<br>
                        Rs. ${bill.due} <br>
                    </div>
                </div>
                <div class="row" style="border-top: 1px solid black;">
                    <div class="col-xs-12">

                        <div class="panel-heading" style="padding:0px;">
                            <p>Notice*:&nbsp; Goods once sold will not be taken back.</p>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="totalPayable" value="${bill.netTotal}">
<<<<<<< HEAD
            <%--</c:forEach>--%>
=======
            </c:forEach>
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
        </div>

    </body>

    <script>
        var money = document.getElementById("totalPayable").value;
        console.log(money);
        var words = inWords(money);
//        document.getElementById("amountWord").value= inWords(money);
<<<<<<< HEAD
        $("#amountWord").val(inWords(money));
=======
$("#amountWord").val(inWords(money));
>>>>>>> 057025784c6430b4d3928f13451864c41bbe3cab
        console.log(words);


        function inWords(num) {
            var a = ['', 'one ', 'two ', 'three ', 'four ', 'five ', 'six ', 'seven ', 'eight ', 'nine ', 'ten ', 'eleven ', 'twelve ', 'thirteen ', 'fourteen ', 'fifteen ', 'sixteen ', 'seventeen ', 'eighteen ', 'nineteen '];
            var b = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'];
            num = Math.ceil(num);
            if ((num = num.toString()).length > 9)
                return 'overflow';
            n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
            console.log(n);
            if (!n)
                return;
            var str = '';
            str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
            str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'lakh ' : '';
            str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'thousand ' : '';
            str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'hundred ' : '';
            str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) + 'only ' : '';
            return str;
        }
    </script>
</html>
