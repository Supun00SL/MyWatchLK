<%-- 
    Document   : AddToStock
    Created on : Nov 22, 2016, 6:32:52 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <style>
            .thumbnail img{
                width: 300px;
                height: 175px;

            }
        </style>
        <script>
            function update(val) {
                document.getElementById('val').innerHTML = val + "%";
            }
        </script>

        <title>Add To Stock</title>
    </head>
    <body>
        <%
            HttpSession hs = request.getSession();
            Session session1 = new classes.SessionConect().testConnection();
            if (hs.getAttribute("supplier") != null) {
                pojos.Supplier supplier = (pojos.Supplier) hs.getAttribute("supplier");
                pojos.Supplier supplier1 = (pojos.Supplier) session1.load(pojos.Supplier.class, supplier.getIdSupplier());
            } else {

                response.sendRedirect("SupplierLogin.jsp");
            }

        %>

        <div class="container-fluid">
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
                            <li><a href="AddNewProduct.jsp">Add New Product</a></li>
                            <li class="active"><a href="AddToStock.jsp">Add To Stock</a></li>
                             <li><a href="AllStock_Sup.jsp">Stock</a></li>
                             <li><a href="SupplierProfit.jsp">Supplier Profit</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <%                                if (hs.getAttribute("supplier") != null) {
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
                                    <li><a  href="SupplierRegistration_Advanced.jsp"><span class="glyphicon glyphicon-user"></span>  <%= supplierlogin.getUsername()%></a></li>
                                    <li onclick="logout()"><span class="glyphicon glyphicon-log-out"></span> Logout</li>

                                </ul>
                            </li>
                            <%
                                            break;
                                        }
                                    }
                                } else {
                                    response.sendRedirect("SupplierLogin.jsp");
                                }


                            %>
                        </ul>

                    </div>
                </div>
            </nav>
            <%                if (request.getParameter("msg") != null) {
                    if (request.getParameter("msg").equals("3")) {
            %>
            <div  id="stattop">
                <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    Successfully Saved...!
                </div>
            </div>
            <%
            } else if (request.getParameter("msg").equals("1")) {
            %>
            <div  id="stattop">
                <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    Please Choose Valid Selling Price...!
                </div>
            </div>
            <%
            } else {
            %>
            <div  id="stattop">
                <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    Please Choose Valid QTY...!
                </div>
            </div>

            <%
                    }

                }


            %>
            <div class="panel panel-default">
                <div class="panel panel-heading">
                    <h3 class="page-header"> Add To Stock</h3>
                </div>
                <div class="panel panel-body">
                    <div class="col-md-12 text-center" id="images">

                    </div><br>
                    <form action="ViewDetails" method="post">
                        <div class="form-group col-md-6">
                            <label>Select Your Item :</label>
                            <%                                Criteria itemCriteria = session1.createCriteria(pojos.Product.class);
                                List<pojos.Product> products = itemCriteria.list();
                                pojos.Product product = null;
                            %>

                            <input list="items" name="item" class="form-control" id="name">
                            <datalist id="items">
                                <%
                                    if (!products.isEmpty()) {
                                        for (int i = 0; i < products.size(); i++) {
                                            product = products.get(i);
                                %>
                                <option value="<%= product.getItemCode() + " : " + product.getSearchWord()%>" id="<%= product.getIdProduct()%>">
                                    <%
                                            }
                                        }
                                    %>
                            </datalist><br>

                            <input type="submit" class="btn btn-info col-lg-offset-10" value="Search" >
                        </div >
                    </form>
                    <%
                        if (request.getParameter("id") != null) {

                            pojos.Product product2 = (pojos.Product) session1.load(pojos.Product.class, Integer.parseInt(request.getParameter("id")));

                    %>
                    <div class="form-group col-md-6" id="images">

                    </div>
                    <div class=" col-md-12">
                        <table class="table table-bordered">
                            <tr>
                                <td class="col-md-4 text-center">
                                    <img src="<%= product2.getImage()%>" class="img-thumbnail" width="200" height="200"> 

                                </td>
                                <td>
                                    <h3 class="text-capitalize"><%= product2.getSearchWord()%></h3> 
                                    <h4 class="text-success">Item Code :<%= product2.getItemCode()%></h4>                                                          

                                    <br>

                                </td>

                            </tr>
                        </table>
                        <form action="AddTOStock" method="post">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="page-header"> Add Product To Stock Form</h3>
                                </div>
                                <div class="panel-body"> 
                                    <div class="form-group col-md-6">
                                        <label>Bar Code :</label> 
                                        <input required type="text"  class="form-control" placeholder="Bar Code" name="barcode" id="barcode">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Qty :</label> 
                                        <input required type="number" min="0"  class="form-control" placeholder="Qty" name="qty" id="qty">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Selling Price :</label> 
                                        <input required type="number" step="0.01" class="form-control" placeholder="Selling Price" name="sellingprice" id="sellingprice">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Discount Percentage :</label> 
                                        <input required type="number" step="0.01" class="form-control" placeholder="Discount" name="discount" id="discount" value="0">
                                    </div>
                                    <div class="form-group">
                                        <hr>
                                        <h4>Add Delivery Districts</h4>
                                        <div class="well well-sm">
                                            <%
                                                if (hs.getAttribute("supplier") != null) {
                                                    pojos.Supplier supplier = (pojos.Supplier) hs.getAttribute("supplier");
                                                    pojos.Supplier supplier1 = (pojos.Supplier) session1.load(pojos.Supplier.class, supplier.getIdSupplier());

                                                    Set<pojos.SupplierHasDeliverydistrict> deliverydistricts = supplier1.getSupplierHasDeliverydistricts();
                                                    int i = 0;
                                                    for (pojos.SupplierHasDeliverydistrict deliverydistrict : deliverydistricts) {

                                            %>
                                            <div>
                                                <label><%= deliverydistrict.getDeliverydistrict().getDistrict()%></label>
                                                <input type="checkbox" name="dis_<%= i%>">
                                            </div>
                                            <%
                                                        i++;
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer">
                                    <div class="form-inline col-md-offset-10">
                                        <input type="hidden" name="product" value="<%= product2.getIdProduct()%>">
                                        <input type="submit" name="submited" class="btn btn-primary" id="save" value="Save">
                                    </div>

                                </div>
                            </div>
                        </form>
                    </div>


                    <%                        }


                    %>

                </div>
            </div>
        </div>
        <%            session1.close();
        %>
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
