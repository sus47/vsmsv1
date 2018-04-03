
<%@include file="../login/header.jsp" %>
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
                            Invoice: #INVB001<br/>
                            CustomerID: #CUS001<br/>
                            Date: 2074/12/19</p>
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
                            <p style="font-size:16px;">Customer Name: Sushant Thapa</h4>
                        </div>
                        <div class="panel-body" style="padding:0;">
                            <p>
                                Kamalamai-06, Sindhuli <br>
                                Phone: 9864736255 <br>
                                <span class="pan">PAN No/VAT No: </span><br>
                            </p>
                        </div>
                    </div>
                </div>
                <!--        <div class="col-xs-5 col-xs-offset-2 text-right">
                          <div class="panel panel-default">
                            <div class="panel-heading">
                              <h4>To : <a href="#">Client Name</a></h4>
                            </div>
                            <div class="panel-body">
                              <p>
                                Address <br>
                                details <br>
                                more <br>
                              </p>
                            </div>
                          </div>
                        </div>-->
            </div>
            <!-- / end client details section -->
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
                        <td>1</td>
                        <td>HM00381 </td>
                        <td><a href="#">Red Helmet of TVS Bike</a></td>
                        <td class="text-right">1</td>
                        <td class="text-right">Rs.200.00</td>
                        <td class="text-right">Rs.10.00</td>
                        <td class="text-right">Rs.190.00</td>
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
                        <!--            <div class="panel-body">
                                      <p>Your Name</p>
                                      <p>Bank Name</p>
                                      <p>SWIFT : --------</p>
                                      <p>Account Number : --------</p>
                                      <p>IBAN : --------</p>
                                    </div>-->
                   
                </div>
                <!--        <div class="col-xs-7">
                          <div class="span7">
                            <div class="panel panel-info">
                              <div class="panel-heading">
                                <h4>Contact Details</h4>
                              </div>
                              <div class="panel-body">
                                <p>
                                  Email : you@example.com <br><br>
                                  Mobile : -------- <br> <br>
                                  Twitter : <a href="https://twitter.com/tahirtaous">@TahirTaous</a>
                                </p>
                                <h4>Payment should be made by Bank Transfer</h4>
                              </div>
                            </div>
                          </div>
                        </div>-->
            </div>
        </div>
    </body>
</html>
