<%-- 
    Document   : ClientInvoiceHistory
    Created on : Jul 18, 2017, 11:07:40 AM
    Author     : Supun Madushanka
--%>

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

        <title>Client Invoice History</title>
    </head>
    <body>
    

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="AdminHome.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li ><a href="AdminHome.jsp">Admin Home</a></li>
                        <li><a href="AllStock.jsp">Stock</a></li>
                        <li><a href="AddNewAdvertisement.jsp">Add New Advertisement</a></li>
                        <li><a href="AdminProfit.jsp">Admin Profit</a></li>
                        <li class="active"><a href="ClientsInvoiceHistory_ForAdmin.jsp">Client Invoice History</a></li>
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
                <h3>Client Invoice History</h3>
            </div>

            <div class="well well-lg col-md-12">
                <div class=" col-md-4">
                    <label>Start Date</label>
                    <input type="date" id="startdate" name="startdate" class="form-control">
                </div>
                <div class=" col-md-4">
                    <label>End Date</label>
                    <input type="date" id="enddate" name="enddate" class="form-control">
                </div>
                <br>
                <div class="col-lg-offset-6">                    
                    <input type="button" value="Search" class="btn btn-primary" onclick="filterSearch()">
                </div>
            </div>

            <div id="tabledata">
                <table class="table table-condensed">

                </table>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        //Creating Xhttp Request------------------------------
        var xhttp;
        function CreateXHTTPRequest() {

            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();
            } else {
                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        //-----------------------------------------------------
        function filterSearch() {
            var startdate = document.getElementById("startdate").value;
            var enddate = document.getElementById("enddate").value;

            CreateXHTTPRequest();
            xhttp.onreadystatechange = function() {
                if (xhttp.readyState === 4 & xhttp.status === 200) {


                    document.getElementById("tabledata").innerHTML = xhttp.responseText;
                }

            };
            xhttp.open("POST", "ClientInvoiceHistory_ForAdmin", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("startdate=" + startdate + "&enddate=" + enddate);

        }
        
         function logout1() {
                CreateXHTTPRequest();
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
