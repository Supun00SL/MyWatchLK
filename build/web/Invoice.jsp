<%-- 
    Document   : Invoice
    Created on : Dec 17, 2016, 7:38:03 AM
    Author     : Supun Madushanka
--%>

<%@page import="mvc.DeliveryDetailsModel"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">         
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <script>
             window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </script>
       
        <title>Payment</title>
    </head>
    <body onload="noBack()" onpageshow="if (event.persisted) noBack();" onunload="">
        <%
            Session session2 = new classes.SessionConect().testConnection();
        %>
        <div class="container">
        <div class="page-header">
            <h3>Payment</h3>
        </div>

            <div class="col-md-offset-9">
                <%
                    HttpSession hs4 = request.getSession();
                    if (hs4.getAttribute("client") != null) {
                        pojos.Client client = (pojos.Client) hs4.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());
                        
                        DeliveryDetailsModel ddm=(DeliveryDetailsModel)hs4.getAttribute("deldetails");
                        
                        System.out.println("ddm :"+ddm.getPostalcode());

                %>
                <label>Name :<%= ddm.getFname()+ " "+ddm.getLname() %></label><br>
                <label>Address :<%= ddm.getNo() + " "+ddm.getStreet()+" "+ddm.getCity()+" "+ddm.getDistrict()+" "+ddm.getCountry() %></label><br>
                <label>Postal Code :<%= ddm.getPostalcode() %></label><br>
                <label>Contact :<%= ddm.getContact()%></label><br>
                <label>Email :<%= client1.getEmail() %></label><br>
                <%
                    }
                %>


            </div>
                <hr>
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
                                response.sendRedirect("clientLogin.jsp");

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
                    <form method="post" action="PaymentInvoice">
                    <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-usd"></span>  Payment</button>
                    
                    </form>
                </div>

                <%
                        }
                    }
                    session2.close();
                %> 

            </div>
        </div>

    </body>
</html>
