<%-- 
    Document   : AdminHome
    Created on : Jan 4, 2017, 11:50:24 AM
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
        <link type="text/css" rel="stylesheet" href="css/animate.css">      
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>Admin</title>

        <script>
            var xhttp;

            function CreateRequest() {
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();

                } else if (window.ActiveXObject) {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

            }
            function logout1() {
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
    </head>
    <body>

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="AdminHome.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="AdminHome.jsp">Admin Home</a></li>
                        <li><a href="AllStock.jsp">Stock</a></li>
                        <li><a href="AddNewAdvertisement.jsp">Add New Advertisement</a></li>
                        <li><a href="AdminProfit.jsp">Admin Profit</a></li>
                        <li><a href="ClientsInvoiceHistory_ForAdmin.jsp">Client Invoice History</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            HttpSession hs = request.getSession();

                            if (hs.getAttribute("admin") != null) {

                        %>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> My Account
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><span class="glyphicon glyphicon-user"></span> <%= hs.getAttribute("admin")%></li>
                                <li onclick="logout1()"><span class="glyphicon glyphicon-log-out"></span> Logout</li>

                            </ul>
                        </li>

                        <%

                            } else {
                                response.sendRedirect("adminLogin.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="page-header">
                <h3>Admin Home</h3>
            </div>

        </div>
        <%@include file="SupplierActivation.jsp" %>
    </body>
</html>
