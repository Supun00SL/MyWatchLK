<%-- 
    Document   : CompleteOrders
    Created on : Aug 3, 2017, 6:07:12 AM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">      
        <link type="text/css" rel="stylesheet" href="css/animate.css">      
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>



        <title>Complete Orders</title>
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
                        <li><a href="ClientHome.jsp">Client Home</a></li>
                        <li><a href="ClientInvoiceHistory.jsp">Client Invoice History</a></li>
                        <li class="active"><a href="CompleteOrders.jsp">Complete Orders</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                                        HttpSession hs = request.getSession();
                            pojos.Client client = null;
                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        %>
                        <li>
                            <div class="well-sm">
                                <form class="form-inline">
                                    <input type="text" class="form-control" placeholder="I'm shopping for.....">
                                    <button class="btn btn-info glyphicon glyphicon-search form-control"></button>
                                </form>
                            </div>

                        </li>
                        <li><a  href="ClientWatchList.jsp"><span class="glyphicon glyphicon-eye-open"><span class="badge" id="wb"><%= new mvc.ClientHome().ReturnWatchListBadgeCount(client)%></span></span> </a></li>
                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge" id="cb"><%= new mvc.ClientHome().ReturnCartBadgeCount(client)%></span></span></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> My Account
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>
                                <li onclick="logout()"><span class="glyphicon glyphicon-log-out"></span> Logout</li>

                            </ul>
                        </li>

                        <%
                                        break;
                                    }
                                }
                            } else {
                                response.sendRedirect("index.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container">
            <%                if (request.getParameter("id") != null) {
                    if (request.getParameter("id").equals("0")) {
            %>
            <div  id="stattop">
                <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    Successfully Saved...!
                </div>
            </div>
            <%
            } else {
            %>
            <div  id="stattop">
                <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    Not Saved Please Try Again...!
                </div>
            </div>
            <%
                    }

                }

            %>
            <table class="table table-condensed">
                <tr>
                    <th>Image</th>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Order State</th>
                </tr>
                <%                Set<pojos.Invoice> invoices = client.getInvoices();

                    for (pojos.Invoice invoice : invoices) {
                        Set<pojos.InvoiceHasStock> hasStocks = invoice.getInvoiceHasStocks();

                        for (pojos.InvoiceHasStock hasStock : hasStocks) {
                            Set<pojos.Deliveryitem> deliveryitems = hasStock.getDeliveryitems();

                            for (pojos.Deliveryitem deliveryitem : deliveryitems) {
                                if (!deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Delivered")) {
                %>
                <tr>
                    <td><img src="<%= hasStock.getStock().getProduct().getImage()%>" class="img-rounded" height="100"></td>
                    <td><%=hasStock.getStock().getProduct().getSearchWord()%></td>
                    <td><%=hasStock.getQty()%></td>
                    <%
                        if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Shipped")) {
                    %>
                    <td>
                <form method="post" action="settofound">
                    <input type="hidden" value="<%=deliveryitem.getIdDeliveryItem()%>" name="delid">
                    <input type="submit" value="Found Order" class="btn btn-success">

                </form>
                    </td>
                <%
                } else if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Not Delivered")) {
                %>
                <td>
                <input disabled type="button" value="Not Delievered by Supplie Yet" class="btn btn-warning">
                </td>
                <%
                    }
                %>

                </tr>

                <%
                                }
                            }
                        }
                    }

                %>

            </table>
        </div>
    </body>

    <script>
        var xhttp;

        function CreateRequest() {
            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();

            } else if (window.ActiveXObject) {
                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

        }

        function logout() {
            CreateRequest();
            xhttp.onreadystatechange = function() {

                if (xhttp.readyState === 4 & xhttp.status === 200) {


                    var text = xhttp.responseText;
                    window.location = "index.jsp";

                }
            };
            xhttp.open("POST", "Logout", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send();

        }


    </script>
</html>
