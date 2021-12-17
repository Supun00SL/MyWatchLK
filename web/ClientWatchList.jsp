<%-- 
    Document   : ClientWatchList
    Created on : Dec 17, 2016, 10:56:12 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">         
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>Watch List</title>
    </head>
    <body>
        <%
            Session session2 = new classes.SessionConect().testConnection();
            HttpSession hs = request.getSession();

        %>

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Page 1</a></li>
                        <li><a href="#">Page 2</a></li> 
                        <li><a href="#">Page 3</a></li> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        %>
                        <li class="active"><a  href="ClientWatchList.jsp"><span class="glyphicon glyphicon-eye-open"><span class="badge" id="wb"><%= new mvc.ClientHome().ReturnWatchListBadgeCount(client)%></span></span> </a></li>
                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge" id="cb"><%= new mvc.ClientHome().ReturnCartBadgeCount(client)%></span></span></a></li>
                        <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>

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
            <div class="page-header">
                <h3>Watch List</h3>
            </div>
            <%                if (hs.getAttribute("client") != null) {
                    pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                    pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                    Set<pojos.Watchlist> watchlists = client.getWatchlists();
                    if (!watchlists.isEmpty()) {
                        for (pojos.Watchlist watchlist : watchlists) {

            %>
            <div class="well col-md-12">
                <div class="col-lg-4">
                    <img src="<%= watchlist.getStock().getProduct().getImage()%>" alt="<%= watchlist.getStock().getProduct().getSearchWord()%>" class="img-rounded img-thumbnail" width="200" height="150">
                </div>
                <div class="col-md-8">
                    <h4><%= watchlist.getStock().getProduct().getSearchWord()%></h4>
                    <button class="btn btn-primary" onclick="View1(<%= watchlist.getStock().getIdStock()%>)">View More</button>

                </div>
            </div>
            <%
                        }
                    }
                } else {
                    response.sendRedirect("index.jsp");
                }

            %>
        </div>

    </body>

    <script>
        function View1(item) {

            var id = item;

            window.location = 'ViewOneProduct.jsp?ideka=' + id;

        }
    </script>
</html>
