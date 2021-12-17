<%-- 
    Document   : AllStock
    Created on : Jul 16, 2017, 7:59:45 AM
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
        <title>All Stock</title>
    </head>
    <body>
        <%                Session session2 = new classes.SessionConect().testConnection();

        %>
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="SupplierHome.jsp">Home</a></li>
                        <li ><a href="AddNewProduct.jsp">Add New Product</a></li>
                        <li><a href="AddToStock.jsp">Add To Stock</a></li>
                        <li class="active"><a href="AllStock_Sup.jsp">Stock</a></li>
                        <li><a href="SupplierProfit.jsp">Supplier Profit</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            HttpSession hs = request.getSession();

                            if (hs.getAttribute("supplier") != null) {
                                pojos.Supplier supplier1 = (pojos.Supplier) hs.getAttribute("supplier");
                                pojos.Supplier supplier = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier1.getIdSupplier());

                                Set<pojos.Supplierlogin> supplierlogins = supplier.getSupplierlogins();
                                if (!supplierlogins.isEmpty()) {
                                    for (pojos.Supplierlogin supplierlogin : supplierlogins) {

                        %>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> My Account
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><span class="glyphicon glyphicon-user"></span> <%= supplierlogin.getUsername()%></li>
                                <li onclick="logout1()"><span class="glyphicon glyphicon-log-out"></span> Logout</li>

                            </ul>
                        </li>

                        <%
                                        break;
                                    }
                                }
                            } else {
                                response.sendRedirect("SupplierHome.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="page-header">
                <h3>All Stock</h3>
            </div>
            <div class="well well-lg col-md-12">
                <div class="col-md-4">
                    <label class="control-label"><input type="radio" name="stype" id="name" value="name" ><b>Search Name</b></label>
                </div>

                <div class="col-md-4">
                    <label class="control-label"><input type="radio" name="stype" id="bar" value="bar" ><b>Search Barcode</b></label>
                </div>

                <div class="col-md-4 form-group" style="padding-top: 1%;">
                    <input type="text" class="text-right text-capitalize form-control" onkeyup="filterSearch(this)">
                </div>
            </div>
            <div id="tabledata">

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
        function filterSearch(text) {
            var name = document.getElementById("name").checked;
            var bar = document.getElementById("bar").checked;
            var text = text.value;

            var stype = "";
            if (name) {
                stype = "name";
            } else if (bar) {
                stype = "bar";
            }
            CreateXHTTPRequest();
            xhttp.onreadystatechange = function() {
                if (xhttp.readyState === 4 & xhttp.status === 200) {


                    document.getElementById("tabledata").innerHTML = xhttp.responseText;
                }

            };
            xhttp.open("POST", "AllStock", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("type=" + stype + "&value=" + text);

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
