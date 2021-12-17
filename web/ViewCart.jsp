<%-- 
    Document   : ViewCart
    Created on : Nov 17, 2016, 10:51:16 PM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="mvc.CartHasStockModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvc.SessionCart"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>Cart</title>

        <script>

            function getData() {
                var xhttp;

                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                var stat = document.getElementById("stattop");

                xhttp.onreadystatechange = function() {
                    if (xhttp.readyState === 4 & xhttp.status === 200) {

                        var text = xhttp.responseText;
                        if (text.length > 1) {
                            stat.innerHTML = "<div class='alert alert-success fade in row' id='status'><a href='#' class='close' data-dismiss='alert' aria-label='close' id='a'>&times;</a>"+xhttp.responseText+"</div>";
                            document.getElementById("uname").value = '';
                            document.getElementById("pword").value = '';
                        } else {
                            //alert(xhttp.responseText);
                            if (xhttp.responseText == "1") {

                                window.location = "CartCheckout.jsp";

                            } else {
                                window.location = "ClientHome.jsp";

                            }
                        }
                    }

                };
                xhttp.open("POST", "LoginFromCart", false);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.setRequestHeader("cache-control", "no-cache");
                xhttp.setRequestHeader("cache-control", "no-store");
                xhttp.send("u=" + document.getElementById("uname").value + "&p=" + document.getElementById("pword").value);

            }
            function next() {
                window.location = 'CartCheckout.jsp';

            }
        </script>
    </head>
    <body>
        <%
            Session session2 = new classes.SessionConect().testConnection();
        %>
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                                        HttpSession hs = request.getSession();

                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        %>
                        <li class="active"><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge"><%= new mvc.ClientHome().ReturnCartBadgeCount(client)%></span></span></a></li>
                        <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>

                        <%
                                        break;
                                    }
                                }
                            } else {
                                // response.sendRedirect("index.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container-fluid">

            <h3>Cart</h3>
            <div  id="stattop" class="hidden">
                <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  

                </div>
            </div>  
        </div>
        <div class="container">

            <%                Session session1 = new classes.SessionConect().testConnection();
                try {
                    HttpSession hs1 = request.getSession();
                    if (hs1.getAttribute("client") != null) {

                        pojos.Client client = (pojos.Client) hs1.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session1.load(pojos.Client.class, client.getIdClient());

//                        if (hs.getAttribute("cart") != null) {
//                            SessionCart cart = (SessionCart) hs.getAttribute("cart");
//                            //new mvc.SessionCart().SaveSessionCartToTheDB(cart, client);
//                        }
                        Criteria cartCriteria = session1.createCriteria(pojos.Cart.class);
                        cartCriteria.add(Restrictions.eq("client", client1));

                        List<pojos.Cart> carts = cartCriteria.list();

                        if (!carts.isEmpty()) {
                            pojos.Cart cart = carts.get(0);
            %>



            <div class="well well-lg col-md-5" style="background-color: #00cc66;">
                <div class="col-md-4">
                    <span><img src="<%= client1.getImage()%>" class="img-circle img-thumbnail" style="width: 100px; height: 100px;"></span> 
                </div>
                <div class="col-md-8">
                    <h2 class="text-info text-capitalize" style="color: #ffffff;"> RS <%= classes.Common.VALUE_FORMAT.format(cart.getNetTotal())%></h2>
                    <hr>

                    <h3 class="text-info text-capitalize" style="color: #ffffff;"> <%= client1.getFname() + "  " + client1.getLname()%></h3>
                    <h5 class="text-info text-capitalize" style="color: #ffffff;"> Hurry Purchase Those Items !!!</h5>
                </div>
            </div>


            <%
            } else {
            %>

            <div class="well well-lg col-md-5" style="background-color: #00cc66;">
                <div class="col-md-4">
                    <span><img src="<%= client1.getImage()%>" class="img-circle img-thumbnail" style="width: 100px; height: 100px;"></span> 
                </div>
                <div class="col-md-8">
                    <h2 class="text-info text-capitalize" style="color: #ffffff;"> RS 0.00</h2>
                    <hr>
                    <h3 class="text-info text-capitalize" style="color: #ffffff;"> <%= client1.getFname() + "  " + client1.getLname()%></h3>
                    <h5 class="text-info text-capitalize" style="color: #ffffff;"> Your Cart is Empty !!!</h5>
                </div>
            </div>

            <%
                }
            } else {
                //response.sendRedirect("clientLogin.jsp");
            %>
            <div class="panel panel-body">
                <table class="table table-bordered">
                    <%
                        if (hs.getAttribute("cart") != null) {
                            SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                            ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                            for (int i = 0; i < cartHasStocks.size(); i++) {
                                CartHasStockModel cartHasStock = cartHasStocks.get(i);
                                pojos.Stock stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid()));


                    %>

                    <tr class="col-lg-6">
                        <td>
                            <img src="<%= stock.getProduct().getImage()%>" class="img-rounded" alt="1" width="200" height="150">

                        </td>
                        <td>
                            <h4 class="text-capitalize">Product :<%= stock.getProduct().getSearchWord()%></h4>
                            <h4 class="text-danger">QTY     :<%= cartHasStock.getQty()%></h4>
                            <h4 class="text-primary">Total   :<%= cartHasStock.getTotal()%> LKR</h4>
                            <form method="post" action="RemovefromSessionCart">
                                <input type="hidden" name="itemid" value="<%=cartHasStock.getCartHasStockid()%>">
                                <input type="submit" value="Remove" class="btn btn-warning"> 
                            </form>
                        </td>

                    </tr> 




                    <%                }
                    %>
                </table>
            </div>
            <%
                        } else {

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            %>
            <div class="panel panel-body">
                <table class="table table-bordered">

                    <%                        try {
                            HttpSession hs2 = request.getSession();
                            if (hs2.getAttribute("client") != null) {
                                pojos.Client client = (pojos.Client) hs2.getAttribute("client");

                                pojos.Client client1 = (pojos.Client) session1.load(pojos.Client.class, client.getIdClient());

                                Criteria cartCriteria = session1.createCriteria(pojos.Cart.class);
                                cartCriteria.add(Restrictions.eq("client", client1));

                                List<pojos.Cart> carts = cartCriteria.list();

                                if (!carts.isEmpty()) {
                                    pojos.Cart cart = carts.get(0);

                                    Criteria cartItem = session1.createCriteria(pojos.CartHasStock.class);
                                    cartItem.add(Restrictions.eq("cart", cart));

                                    List<pojos.CartHasStock> cartsHasStocks = cartItem.list();

                                    if (!cartsHasStocks.isEmpty()) {
                                        for (pojos.CartHasStock cartHasStock : cartsHasStocks) {

                    %>
                    <tr class="col-lg-6">
                        <td>
                            <img src="<%= cartHasStock.getStock().getProduct().getImage()%>" class="img-rounded" alt="1" width="200" height="150">

                        </td>
                        <td>
                            <h4 class="text-capitalize">Product :<%= cartHasStock.getStock().getProduct().getSearchWord()%></h4>
                            <h4 class="text-danger">QTY     :<%= cartHasStock.getQty()%></h4>
                            <h4 class="text-primary">Total   :<%= cartHasStock.getTotal()%> LKR</h4>
                            <form method="post" action="RemovefromCart">
                                <input type="hidden" name="itemid" value="<%=cartHasStock.getCartHasStockid()%>">
                                <input type="submit" value="Remove" class="btn btn-warning"> 
                            </form>

                        </td>

                    </tr>
                    <%                                        }
                                    }
                                }
                            } else {
                                //response.sendRedirect("clientLogin.jsp");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    %>
                </table>

            </div>
            <%                    Session session4 = new classes.SessionConect().testConnection();

                HttpSession hs1 = request.getSession();
                if (hs1.getAttribute("client") != null) {

                    pojos.Client client = (pojos.Client) hs1.getAttribute("client");

                    pojos.Client client1 = (pojos.Client) session4.load(pojos.Client.class, client.getIdClient());

                    Criteria cartCriteria = session4.createCriteria(pojos.Cart.class);
                    cartCriteria.add(Restrictions.eq("client", client1));

                    List<pojos.Cart> carts = cartCriteria.list();

                    if (!carts.isEmpty()) {
                        pojos.Cart cart = carts.get(0);
            %>
            <div class="panel panel-footer col-md-12">
                <div class="col-md-offset-10">

                    <button type="button" class="btn btn-primary" onclick="next()"><span class="glyphicon glyphicon-check"></span> Checkout</button>


                </div>
            </div>
            <%
                }
            } else {
                if (hs.getAttribute("cart") != null) {
            %>
            <div class="panel panel-footer col-md-12">
                <div class="col-md-offset-10">

                    <a href="#m1" data-toggle="modal"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-check"></span> Checkout</button></a>


                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
        <div class="modal fade" id="m1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-capitalize" style="font-size: x-large;"><span class="glyphicon glyphicon-user"></span>  Select Your Option</div>
                    <div class="modal-body">
                        <div class="container" >
                            <ul class="nav nav-tabs">
                                <li class="active" ><a data-toggle="tab" href="#Login">Login</a></li>
                                <li><a data-toggle="tab" href="#SignUp">SignUp</a></li>
                            </ul>
                            <div class="tab-content col-md-6">
                                <div id="Login" class="tab-pane fade in active" col-md-6>
                                    <div  id="stattop" class="hidden">

                                    </div>

                                    <div class="form-group">
                                        <label>Username :</label>
                                        <input type="text" name="uname" id="uname" class="form-control">

                                    </div>
                                    <div class="form-group">
                                        <label>Password :</label>
                                        <input type="password" name="pword" id="pword" class="form-control">

                                    </div>

                                    <div>
                                        <input type="button" onclick="getData()" value="Login as Client" class="btn btn-primary">
                                    </div>


                                </div>
                                <div id="SignUp" class="tab-pane fade" >
                                    <form method="post" action="SimpleRegistrationClient">
                                        <input type="hidden" name="red" value="CartCheckout.jsp" >
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
                                        <div class="col-md-9">
                                            <input type="submit" value="Save" class="btn btn-success">
                                        </div>
                                </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="PageFooter.jsp" %>
    </body>
</html>
