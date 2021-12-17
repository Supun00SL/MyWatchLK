<%-- 
    Document   : clientLogin
    Created on : Oct 12, 2016, 11:08:22 AM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head  onload="noBack()">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>Log In</title>

        <style>
            .positionimg{
                float: left;
                position: relative;
                margin-top: 3%;


            }

            .warinintxt{
                color: #ff3333;

            }

        </style>
        <script>
        function getData() {
            var xhttp;

            var rem = "";
            var remcomp = document.getElementById("rem");
            if (remcomp.checked) {
                rem = "rem";
            }

            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();
            } else {
                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            var stat = document.getElementById("status");

            xhttp.onreadystatechange = function() {
                if (xhttp.readyState === 4 & xhttp.status === 200) {

                    var text = xhttp.responseText;
                    if (text.length > 1) {
                        stat.innerHTML = xhttp.responseText;
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
            xhttp.open("POST", "ClientLoginStatus", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("u=" + document.getElementById("uname").value + "&p=" + document.getElementById("pword").value + "&r=" + rem);//

        }
        function noBack() {
            window.history.forward();
        }



        </script>
    </head >
    <body onload="noBack()">
        <%
            //Session session2 = new classes.SessionConect().testConnection();
            HttpSession hs = request.getSession();

            if (hs.getAttribute("client") != null) {
                response.sendRedirect("ClientHome.jsp");

            } else if (hs.getAttribute("admin") != null) {

                response.sendRedirect("AdminHome.jsp");
            } else if (hs.getAttribute("supplier") != null) {

                response.sendRedirect("SupplierHome.jsp");
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
                        <!--<li><a  href="#m1" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Login
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="clientLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
                                <li><a href="#m2" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> 
                            </ul>
                        </li>

                    </ul>



                </div>
            </div>
        </nav>
        <div class="container">

            <h2 style="font-family: fantasy; color: #666666">Welcome Back !!!</h2>
        </div>
        <div id="img" class="positionimg">
            <img src="img/log.jpg" alt="img1" class="img-responsive">             
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1><span class="glyphicon glyphicon-log-in"> </span> Login</h1>
                </div>
                <div class="panel-body">
                    <div id="status" class="warinintxt"> 
                    </div>

                    <label><span class="glyphicon glyphicon-user"> </span> User Name : </label>
                    <input type="text" class="form-control" id="uname" placeholder="User Name"><br><br>
                    <label><span class="glyphicon glyphicon-lock"> </span> Password  :  </label>
                    <input type="password" class="form-control" id="pword" placeholder="Password"><br><br>
                    <div class="form-group">
                        <input type="checkbox" id="rem" class="checkbox-inline">
                        <label class="label label-primary">Remember Me </label>
                    </div>
                </div>
                <div class="panel-footer">

                    <input type="button" class="btn btn-success col-md-offset-10" id="login" onclick="getData()" value="Login">
                </div>
            </div>
        </div>

    </body>
</html>
