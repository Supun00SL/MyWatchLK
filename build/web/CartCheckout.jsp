<%-- 
    Document   : CartCheckout
    Created on : Dec 15, 2016, 9:06:19 AM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">         
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
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
                        <li><a href="#">Home</a></li>
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
                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge"><%= new mvc.ClientHome().ReturnCartBadgeCount(client)%></span></span></a></li>
                        <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>

                        <%
                                        break;
                                    }
                                }
                            } else {
                                response.sendRedirect("clientLogin.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>
        <form method="post" action="CartCheckout">
            <div class="container-fluid">
                <div class="page-header">
                    <h3>Cart Checkout</h3>
                </div>
                <div class="container">

                    <%                HttpSession hs1 = request.getSession();
                        if (hs1.getAttribute("client") != null) {

                            pojos.Client client = (pojos.Client) hs1.getAttribute("client");

                            pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());

                            //                        if (hs.getAttribute("cart") != null) {
                            //                            SessionCart cart = (SessionCart) hs.getAttribute("cart");
                            //                            //new mvc.SessionCart().SaveSessionCartToTheDB(cart, client);
                            //                        }
                            Criteria cartCriteria = session2.createCriteria(pojos.Cart.class);
                            cartCriteria.add(Restrictions.eq("client", client1));

                            List<pojos.Cart> carts = cartCriteria.list();

                            if (!carts.isEmpty()) {
                                pojos.Cart cart = carts.get(0);
                    %>



                    <div class="well well-lg col-md-5" style="background-color: #00cc66; margin: 10px;">
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

                    <div class="well well-lg col-md-6" style="background-color: #6699ff;  margin: 10px;">
                        <h4 class="h4" style="color: #ffffff;">Delivery Details</h4>
                        <hr>
                        <div class="form-group col-md-6">
                            <label style="color: #ffffff;">First Name:</label>
                            <input required type="text" id='fname' class="form-control" name='fname' placeholder="First Name" value="<%= cart.getClient().getFname()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label style="color: #ffffff;">Last Name:</label>
                            <input required type="text" id='lname' class="form-control" name='lname' placeholder="Last Name" value="<%= cart.getClient().getLname()%>">
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


                    <%
                            }
                        }

                    %>

                    <div>
                        <table class="table table-hover col-md-12">
                            <tr class="bg-info">
                                <th style="color: #999999;">Product Name & Details</th>
                                <th style="color: #999999;">Quantity</th>
                                <th style="color: #999999;">Price</th>
                                <th style="color: #999999;">Shipping Details</th>
                            </tr>

                            <%                        try {
                                    HttpSession hs2 = request.getSession();
                                    if (hs2.getAttribute("client") != null) {
                                        pojos.Client client = (pojos.Client) hs2.getAttribute("client");

                                        pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());

                                        Criteria cartCriteria = session2.createCriteria(pojos.Cart.class);
                                        cartCriteria.add(Restrictions.eq("client", client1));

                                        List<pojos.Cart> carts = cartCriteria.list();

                                        if (!carts.isEmpty()) {
                                            pojos.Cart cart = carts.get(0);

                                            Criteria cartItem = session2.createCriteria(pojos.CartHasStock.class);
                                            cartItem.add(Restrictions.eq("cart", cart));

                                            List<pojos.CartHasStock> cartsHasStocks = cartItem.list();

                                            if (!cartsHasStocks.isEmpty()) {
                                                for (pojos.CartHasStock cartHasStock : cartsHasStocks) {

                            %>
                            <tr>
                                <td class="col-md-3">
                                    <img src="<%= cartHasStock.getStock().getProduct().getImage()%>" class="img-rounded" alt="1" width="100" height="75">
                                    <h5 class="text-capitalize"><%= cartHasStock.getStock().getProduct().getSearchWord()%></h5>

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


                </div>
                <div class="container">
                    <div class="well text-right">
                        <%                HttpSession hs3 = request.getSession();
                            if (hs3.getAttribute("client") != null) {

                                pojos.Client client = (pojos.Client) hs3.getAttribute("client");

                                pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());

                                //                        if (hs.getAttribute("cart") != null) {
                                //                            SessionCart cart = (SessionCart) hs.getAttribute("cart");
                                //                            //new mvc.SessionCart().SaveSessionCartToTheDB(cart, client);
                                //                        }
                                Criteria cartCriteria = session2.createCriteria(pojos.Cart.class);
                                cartCriteria.add(Restrictions.eq("client", client1));

                                List<pojos.Cart> carts = cartCriteria.list();

                                if (!carts.isEmpty()) {
                                    pojos.Cart cart = carts.get(0);
                        %>
                        <div class="col-md-offset-9">
                            <label  style="color: #999999;">Sub Total (<%= cart.getCartHasStocks().size()%> Items):</label>
                            <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(cart.getNetTotal())%></label>

                            <br>

                            <label  style="color: #999999;">Shipping Cost (<%= cart.getCartHasStocks().size()%> Items):</label>
                            <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(0.00)%></label>

                            <hr>
                            <label  style="color: #999999; font-size: large;">All Total :</label>
                            <label class="text-success" style="font-size: x-large;">RS <%= new classes.Common().VALUE_FORMAT.format(cart.getNetTotal())%></label>
                            <br>
                            <button type="submit" class="btn btn-success"><span class="glyphicon"></span>Buy All</button>

                        </div>

                        <%
                                }
                            }
                            session2.close();
                        %> 

                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
