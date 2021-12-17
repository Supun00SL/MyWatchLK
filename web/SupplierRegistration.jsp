<%-- 
    Document   : SupplierRegistration
    Created on : Nov 19, 2016, 8:30:10 AM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <script>
            function setValues() {
            <%
                HttpSession hs = request.getSession();
                if (hs.getAttribute("status") != null) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) hs.getAttribute("SupplierDetails");
                    String status = hs.getAttribute("status").toString();
            %>

                document.getElementById("comname").value = "<%= hashMap.get("comname")%>";
                document.getElementById("grccode").value = "<%= hashMap.get("grccode")%>";
                document.getElementById("mobilenumber").value = "<%= hashMap.get("mobilenumber")%>";
                document.getElementById("telephonenumber").value = "<%= hashMap.get("telephonenumber")%>";
                document.getElementById("addressno").value = "<%= hashMap.get("addressno")%>";
                document.getElementById("street1").value = "<%= hashMap.get("street1")%>";
                document.getElementById("street2").value = "<%= hashMap.get("street2")%>";
                document.getElementById("street3").value = "<%= hashMap.get("street3")%>";
                document.getElementById("email").value = "<%= hashMap.get("email")%>";
                document.getElementById("username").value = "<%= hashMap.get("username")%>";
                document.getElementById("password").value = "";
                document.getElementById("reenterpassword").value = "";
                var stat = document.getElementById("stat");
                var stattop = document.getElementById("stattop");
                var stat1 = document.getElementById("stat1");
                var stattop1 = document.getElementById("stattop1");
                var stata = "<%= status%>";
                if (stata == "<a href='#' class='close' data-dismiss='alert' aria-label='close' id='a'>&times;</a>  Successfully Saved...!") {
                    stat1.innerHTML = stata;
                    stattop1.className = "show";
                } else {
                    stat.innerHTML = stata;
                    stattop.className = "show";

                }
            <%

                }
            %>

            }
            function red() {
                window.location = "SupplierLogin.jsp";

            }
        </script>
        <title>Supplier Registration</title>
    </head>
    <body onload="setValues()">



        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="SupplierRegistration.jsp">Sell With Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <div class="well-sm">
                                <form class="form-inline">
                                    <input type="text" class="form-control" placeholder="I'm shopping for.....">
                                    <button class="btn btn-info glyphicon glyphicon-search form-control"></button>
                                </form>
                            </div>

                        </li>
                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge"></span></span></a></li>
                        <!--<li><a  href="#m1" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
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
        <div class="container-fluid">
            <div  id="stattop" class="hidden">
                <div class="alert alert-danger fade in" id="stat"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  

                </div>

            </div>

            <div  id="stattop1" class="hidden">
                <div class="alert alert-success fade in" id="stat1"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a1">&times;</a>  

                </div>

            </div>
            <form method="post" action="SupplierRegistration">
                <div class="panel panel-default">
                    <div class="panel panel-heading">
                        <h3 class="page-header"> Supplier Registration</h3>
                    </div>
                    <div class="panel panel-body">
                        <div>

                        </div>
                        <div class="form-group col-md-6">
                            <label>Company Name :</label> 
                            <input required type="text"  class="form-control" placeholder="Company Name" name="comname" id="comname">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Government Registration Code :</label> 
                            <input required type="text"  class="form-control" placeholder="Government Registration Code" name="grccode" id="grccode">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Mobile Number :</label> 
                            <input required type="text"  class="form-control" placeholder="Mobile Number" name="mobilenumber" id="mobilenumber">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Telephone Number :</label> 
                            <input required type="text"  class="form-control" placeholder="Telephone Number" name="telephonenumber" id="telephonenumber">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address No :</label> 
                            <input required type="text"  class="form-control" placeholder="Address No" name="addressno" id="addressno">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street1 :</label> 
                            <input required type="text"  class="form-control" placeholder="Street1" name="street1" id="street1">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street2 :</label> 
                            <input type="text"  class="form-control" placeholder="Street2" name="street2" id="street2">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street3 :</label> 
                            <input type="text"  class="form-control" placeholder="Street3" name="street3" id="street3">
                        </div>
                        <div class="form-group col-md-12">
                            <label>Email :</label> 
                            <input required type="text"  class="form-control" placeholder="Email" name="email" id="email">
                        </div>
                        <div class="form-group col-md-6">
                            <label>User Name :</label>
                            <input required type="text" name="username" id="username" class="form-control" placeholder="User Name">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Password :</label> 
                            <input required type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Re Enter Password :</label> 
                            <input required type="password" name="reenterpassword" id="reenterpassword" class="form-control" placeholder="Re Enter Password">
                        </div>

                    </div>
                    <div class="panel-footer">
                        <div class="form-inline col-md-offset-19">
                            <input type="submit" name="submited" class="btn btn-primary" id="save" value="Register">
                            <button class="btn btn-success" type="button" onclick="red()"><a href="SupplierLogin.jsp">Login as Supplier</a></button>
                        </div>

                    </div>

                </div>

            </form>
        </div>

    </body>
</html>
