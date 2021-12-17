<%-- 
    Document   : AddNewAdvertisement
    Created on : Jul 26, 2017, 7:37:39 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
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
        <title>Advertisement</title>

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

            function getImage(input) {
                var c = 0;
                for (var i = 0; i < input.files.length; i++) {

                    if (input.files[i] !== null) {

                        var reader = new FileReader();

                        reader.onload = function(e) {

                            var elem = document.getElementById("image");
                            elem.src = e.target.result;
                            elem.width = "300";
                            elem.height = "200";


                            c++;

                        };
                        reader.readAsDataURL(input.files[i]);
                    }
                }
            }
        </script>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="AdminHome.jsp">Admin Home</a></li>
                        <li  ><a href="AllStock.jsp">Stock</a></li>
                        <li class="active"><a href="AddNewAdvertisement.jsp">Add New Advertisement</a></li>
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
                <h3>Add New Advertisements</h3>
            </div>

            <%                if (request.getParameter("stat") != null) {
                    if (request.getParameter("stat").equals("1")) {
            %>
            <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                Successfully Saved...!
            </div>
            <%
            } else {
            %>
            <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                Something Went Wrong...!
            </div>
            <%
                    }
                }
            %>
            <form method="post" enctype="multipart/form-data" action="AddNewAdd">
                <div class="panel panel-default">
                    <div class="panel panel-heading">
                        <h4>Create New Advertisement</h4>
                    </div>
                    <div class="panel panel-body">
                        <div class="col-md-6">
                            <label>Image</label>
                            <div class="col-md-12 text-center" id="images">
                                <img src="icons/add_image.png" alt="img" class="img-thumbnail" id="image">
                                <br>
                                <br>
                                <input required type="file" name="addimg" class="btn btn-success" onchange="getImage(this)">
                            </div>

                        </div>
                        <div class="col-md-6">
                            <label>Description</label>
                            <textarea required class="form-control" name="desc"></textarea>
                        </div>
                    </div>
                    <div class="panel panel-footer">
                        <input type="submit" value="Save" class="btn btn-info">

                    </div>
                </div>
            </form>
            <table class="table table-condensed">
                <tr>
                    <th>Image</th>
                    <th>Description</th>
                    <th>State</th>
                </tr>
                <%
                    Session session1 = new classes.SessionConect().testConnection();

                    Criteria criteria = session1.createCriteria(pojos.Advertisement.class);

                    List<pojos.Advertisement> advertisements = criteria.list();

                    if (!advertisements.isEmpty()) {
                        for (pojos.Advertisement advertisement : advertisements) {
                            if (advertisement.getState().equals("inactive")) {
                %>
                <tr>
                    <td>
                        <img src="<%=advertisement.getImage()%>" alt="add" class="img-thumbnail" width="200" height="200">
                    </td>
                    <td><%=advertisement.getDescription()%></td>
                <form method="post" action="ChangeAdvertisementState">
                    <input type="hidden" name="changeto" value="active">
                    <input type="hidden" name="addid" value="<%= advertisement.getIdAdvertisement() %>">
                    <td><input type="submit" value="inactive" class="btn btn-danger"></td>
                </form>
                </tr>
                <%
                } else if (advertisement.getState().equals("active")) {
                %>
                <tr>
                    <td>
                        <img src="<%=advertisement.getImage()%>" alt="add" class="img-thumbnail" width="200" height="200">
                    </td>
                <form method="post" action="ChangeAdvertisementState">
                    <input type="hidden" name="changeto" value="inactive">
                    <input type="hidden" name="addid" value="<%= advertisement.getIdAdvertisement() %>">
                    <td><%=advertisement.getDescription()%></td>
                    <td><input type="submit" value="active" class="btn btn-primary"></td>
                </form>
                </tr>
                <%
                            }
                        }
                    }
                %>
            </table>
        </div>
    </body>
</html>
