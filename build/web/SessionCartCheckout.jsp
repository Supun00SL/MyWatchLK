<%-- 
    Document   : InstantBuyNow
    Created on : Jul 9, 2017, 1:03:16 PM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="pojos.Stock"%>
<%@page import="mvc.CartHasStockModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvc.SessionCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">      
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.min.js"></script>
        <title>Instant Buy Now</title>
    </head>
    <body>
        <%
            HttpSession hs = request.getSession();
            if (hs.getAttribute("client") != null) {
                response.sendRedirect("CartCheckout.jsp");
            }
        %>
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge"></span></span></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Login
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="clientLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
                                <li><a href="#m1" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> 
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
        <form method="post" action="CartCheckout">
            <div class="container">
                <div class="page-header">
                    <h3>Payment</h3>
                </div>
                <div class="well well-lg col-md-5" style="background-color: #00cc66; margin: 10px;">
                    <div class="col-md-4">
                        <span><img src="img/business_user.png" class="img-circle img-thumbnail" style="width: 100px; height: 100px;"></span> 
                    </div>
                    <div class="col-md-8">
                        <%
                            double tot = 0.0;
                            if (hs.getAttribute("cart") != null) {
                                SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                                ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                                for (int i = 0; i < cartHasStocks.size(); i++) {
                                    CartHasStockModel cartHasStock = cartHasStocks.get(i);
                                    tot += cartHasStock.getTotal();
                                }
                            }
                        %>
                        <h2 class="text-info text-capitalize" style="color: #ffffff;"> RS <%= classes.Common.VALUE_FORMAT.format(tot)%></h2>
                        <hr>

                        <h3 class="text-info text-capitalize" style="color: #ffffff;"> Dear Customer,</h3>
                        <h5 class="text-info text-capitalize" style="color: #ffffff;"> Hurry Purchase Those Items !!!</h5>
                    </div>
                </div>
                <div class="well well-lg col-md-6" style="background-color: #6699ff;  margin: 10px;">
                    <h4 class="h4" style="color: #ffffff;">Delivery Details</h4>
                    <hr>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">First Name:</label>
                        <input required type="text" id='fname' class="form-control" name='fname' placeholder="First Name" >
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">Last Name:</label>
                        <input required type="text" id='lname' class="form-control" name='lname' placeholder="Last Name" >
                    </div>
                    <div class="form-group col-md-12">
                        <label style="color: #ffffff;">Contact:</label>
                        <input required type="text" id='contact' class="form-control" name='contact' placeholder="Contact">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">No:</label>
                        <input required type="text" id='no' class="form-control" name='no' placeholder="No">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">Street:</label>
                        <input required type="text" id='street' class="form-control" name='street' placeholder="Street">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">City:</label>
                        <input type="text" id='city' class="form-control" name='city' placeholder="City">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">District:</label>
                        <input required type="text" id='district' class="form-control" name='district' placeholder="District">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">Postal Code:</label>
                        <input required type="text" id='postalcode' class="form-control" name='postalcode' placeholder="Postal Code">
                    </div>
                    <div class="form-group col-md-6">
                        <label style="color: #ffffff;">Country:</label>
                        <input required type="text" id='country' class="form-control" name='country' placeholder="Country">
                    </div>
                </div>
                <div>
                    <table class="table table-hover col-md-12">
                        <tr class="bg-info">
                            <th style="color: #999999;">Product Name & Details</th>
                            <th style="color: #999999;">Quantity</th>
                            <th style="color: #999999;">Price</th>
                            <th style="color: #999999;">Shipping Details</th>
                        </tr>

                        <%
                            Session session1 = new classes.SessionConect().testConnection();
                            if (hs.getAttribute("cart") != null) {
                                SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                                ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();

                                for (int i = 0; i < cartHasStocks.size(); i++) {
                                    CartHasStockModel cartHasStock = cartHasStocks.get(i);

                                    pojos.Stock stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid()));
                        %>
                        <tr>
                            <td class="col-md-3">
                                <img src="<%= stock.getProduct().getImage()%>" class="img-rounded" alt="1" width="100" height="75">
                                <h5 class="text-capitalize"><%= stock.getProduct().getSearchWord()%></h5>

                            </td>
                            <td>
                                <label class="text-danger"><%= cartHasStock.getQty()%></label>

                            </td>
                            <td>
                                <label>RS <%= new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal())%> </label>

                            </td>
                            <td>
                                <label style="color: #999999;">Sub Total :</label>
                                <label>RS <%= new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal())%></label>
                                <br>
                                <label style="color: #999999;">Shipping Cost :</label>
                                <label>RS <%= new classes.Common().VALUE_FORMAT.format(0.00)%></label>

                                <div class="col-md-offset-9 ">
                                    <label style="color: #999999;">Total :</label>
                                    <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal())%></label>
                                </div>
                            </td>

                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>

                </div>

            </div>
            <div class="container">
                <div class="well text-right">
                    <%
                        if (hs.getAttribute("cart") != null) {
                            SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                            ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();


                    %>
                    <div class="col-md-offset-9">
                        <label  style="color: #999999;">Sub Total (<%= cartHasStocks.size()%> Items):</label>
                        <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(tot)%></label>

                        <br>

                        <label  style="color: #999999;">Shipping Cost (<%= cartHasStocks.size()%> Items):</label>
                        <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(0.00)%></label>

                        <hr>
                        <label  style="color: #999999; font-size: large;">All Total :</label>
                        <label class="text-success" style="font-size: x-large;">RS <%= new classes.Common().VALUE_FORMAT.format(tot)%></label>
                        <br>
                        <button type="submit" class="btn btn-success"><span class="glyphicon"></span>Buy All</button>

                    </div>

                    <%
                        }
                        session1.close();
                    %> 

                </div>
            </div>
        </form>
        <div class="modal fade" id="m1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post" action="SimpleRegistrationClient">
                        <div class="modal-header text-capitalize" style="font-size: x-large;"><span class="glyphicon glyphicon-user"></span>  Sign Up</div>
                        <div class="modal-body">
                            <div  id="stattop" class="hidden">
                                <div class="alert alert-success fade in row" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                                </div>

                            </div> 

                            <div class="form-group col-md-6">
                                <label>First Name :</label> 
                                <input required type="text"  class="form-control" placeholder="First Name" name="fname" id="fname">
                            </div>

                            <div class="form-group col-md-6">
                                <label>Last Name :</label> 
                                <input type="text" name="lname" id="lname" class="form-control" placeholder="Last Name">
                            </div>
                            <div class="form-group col-md-12">
                                <label>Email :</label> 
                                <input required type="text"  name="email" id="email" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group col-md-12">
                                <label>User Name :</label>
                                <input required type="text" name="username" id="username" class="form-control" placeholder="User Name">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Password :</label> 
                                <input required type="password" name="password" id="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Re Enter Password :</label> 
                                <input required type="password" name="reenterpassword" id="reenterpassword" class="form-control" placeholder="Re Enter Password">
                            </div>  
                        </div>
                        <div class="modal-footer">
                            <input type="submit" value="Save" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="PageFooter.jsp" %>

    </body>
</html>
