<%-- 
    Document   : SupplierHome
    Created on : Nov 24, 2016, 7:46:28 PM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.criterion.Order"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
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
        <title>Supplier Home</title>

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
                        <li class="active"><a href="SupplierHome.jsp">Home</a></li>
                        <li><a href="AddNewProduct.jsp">Add New Product</a></li>
                        <li><a href="AddToStock.jsp">Add To Stock</a></li> 
                        <li><a href="AllStock_Sup.jsp">Stock</a></li> 
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
        <div class="container">
            <div class="col-md-12">
                <%                    try {
                        HttpSession hs1 = request.getSession();
                        if (hs1.getAttribute("supplier") != null) {

                            pojos.Supplier supplier = (pojos.Supplier) hs1.getAttribute("supplier");

                            pojos.Supplier supplier1 = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier.getIdSupplier());

                            double profit = 0.0;
                            Criteria profitCriteria = session2.createCriteria(pojos.Supplierpayment.class);
                            profitCriteria.add(Restrictions.eq("supplier", supplier));

                            List<pojos.Supplierpayment> profits = profitCriteria.list();

                            if (!profits.isEmpty()) {
                                for (pojos.Supplierpayment profit1 : profits) {
                                    profit += profit1.getSupplierPayment();
                                }
                            }
                %>
                <div class="well well-lg col-md-5" style="background-color: #00cc66;">
                    <div class="col-md-4">
                        <span><img src="icons/add_image.png" class="img-circle img-thumbnail" style="width: 100px; height: 100px;"></span> 
                    </div>
                    <div class="col-md-8">
                        <h2 class="text-info text-capitalize" style="color: #ffffff;"> RS <%= classes.Common.VALUE_FORMAT.format(profit)%></h2>
                        <hr>

                        <h3 class="text-info text-capitalize" style="color: #ffffff;"> <%= supplier1.getCompanyName()%></h3>
                        <!--<h5 class="text-info text-capitalize" style="color: #ffffff;"> Hurry Purchase Those Items !!!</h5>-->
                    </div>
                </div>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                %>

            </div>



            <div>
                <hr>
                <h3>Delivery Waiting List</h3>
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
                    <tr class=" bg-info">
                        <th>
                            Delivery Product
                        </th>
                        <th>
                            Client Name
                        </th>
                        <th>
                            Client address
                        </th>

                        <th>
                            Contact
                        </th>
                        <th>
                            Delivery Status
                        </th>
                    </tr>
                    <%                        int FirstResult = 0;
                        int MaxResult = 5;
                        int ResultSize = 0;

                        if (request.getParameter("fr") != null) {
                            int x = Integer.parseInt(request.getParameter("fr"));
                            FirstResult = x * MaxResult;
                        }

                        try {
                            HttpSession hs1 = request.getSession();

                            if (hs1.getAttribute("supplier") != null) {

                                pojos.Supplier supplier = (pojos.Supplier) hs1.getAttribute("supplier");

                                pojos.Supplier supplier1 = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier.getIdSupplier());

                                //Set<pojos.Stock> stocks = supplier1.getStocks();
                                Criteria stockCriteria = session2.createCriteria(pojos.Stock.class);
                                stockCriteria.add(Restrictions.eq("supplier", supplier1));

                                List<pojos.Stock> stocks = stockCriteria.list();

                                if (!stocks.isEmpty()) {

                                    for (pojos.Stock stock : stocks) {
                                        Criteria invoicehassstockCriteria = session2.createCriteria(pojos.InvoiceHasStock.class);
                                        invoicehassstockCriteria.add(Restrictions.eq("stock", stock));

                                        List<pojos.InvoiceHasStock> invoiceHasStocks = invoicehassstockCriteria.list();

                                        //Set<pojos.InvoiceHasStock> invoiceHasStocks = stock.getInvoiceHasStocks();
                                        if (!invoiceHasStocks.isEmpty()) {
                                            for (pojos.InvoiceHasStock invoiceHasStock : invoiceHasStocks) {
                                                Criteria deliveryCriteria = session2.createCriteria(pojos.Deliveryitem.class);

                                                deliveryCriteria.add(Restrictions.eq("invoiceHasStock", invoiceHasStock));
                                                deliveryCriteria.addOrder(Order.desc("idDeliveryItem"));
                                                List<pojos.Deliveryitem> deliveryitems = deliveryCriteria.list();
                                                //Set<pojos.Deliveryitem> deliveryitems = invoiceHasStock.getDeliveryitems();

                                                if (!deliveryitems.isEmpty()) {
                                                    System.out.println("7");
                                                    for (pojos.Deliveryitem deliveryitem : deliveryitems) {
                                                        if (!deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Delivered")) {
                    %>
                    <tr>
                        <td class="text-left col-md-4">
                            <div class="well col-md-12">
                                <div class="col-md-5 text-center">
                                    <img src="<%= deliveryitem.getInvoiceHasStock().getStock().getProduct().getImage()%>" alt="<%= deliveryitem.getInvoiceHasStock().getStock().getProduct().getSearchWord()%>" class="img-rounded img-thumbnail" width="200" height="75">                           
                                    <br><button type="submit" class="btn btn-info" style="margin-top: 5%; font-size: small;"><span class="glyphicon glyphicon-eye-open"></span> View More</button>
                                </div>
                                <div  class="col-md-7">
                                    <label style="color: #333333">Bar Code : <%= deliveryitem.getInvoiceHasStock().getStock().getBarcode()%></label>
                                    <hr><label style="color: #666666"><%= deliveryitem.getInvoiceHasStock().getStock().getProduct().getSearchWord()%></label>
                                    <label style="color: #666666">Qty :<%= deliveryitem.getInvoiceHasStock().getQty()%></label>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="text-capitalize">
                                <label style="margin-top: 35%;"><%= deliveryitem.getInvoiceHasStock().getInvoice().getClient().getFname() + " " + deliveryitem.getInvoiceHasStock().getInvoice().getClient().getLname()%></label>
                            </div>
                        </td>
                        <td>
                            <div class="text-capitalize">
                                <label style="margin-top: 16%;"><%= deliveryitem.getNo() + " " + deliveryitem.getStreet() + " " + deliveryitem.getCity() + " " + deliveryitem.getDistrict()%></label>
                                <br> <label><%= deliveryitem.getCountry()%></label>
                                <br> <label>Postal Code: <%= deliveryitem.getPostalCode()%></label>
                            </div>
                        </td>
                        <td>
                            <div>
                                <label style="margin-top: 55%;"><%= deliveryitem.getMobile()%></label>
                            </div>
                        </td>

                        <td>
                            <%
                                if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Not Delivered")) {
                            %>
                            <form method="post" action="ProductDelivery">
                                <input type="hidden" value="<%= deliveryitem.getIdDeliveryItem()%>" name="delid">
                                <button type="submit" class="btn btn-success" style="margin-top: 40%;"><span class="glyphicon glyphicon-send"></span> Ship Now</button>
                            </form>
                            <%
                            } else if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Shipped")) {
                            %>
                            <button disabled type="submit" class="btn btn-danger"  style="margin-top: 55%;">Shipped</button>
                            <%
                                }
                            %>
                        </td>
                    </tr>         
                    <%
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            } else {
                                response.sendRedirect("SupplierLogin.jsp");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>

            </div>
        </div>
        <div class="container">
            <hr>

            <div>
                <h3>Add Districts</h3>
            </div>

            <div>
                <div class="col-md-6">
                    <%
                        if (request.getParameter("delst") != null) {
                            if (request.getParameter("delst").equals("1")) {
                    %>
                    <div  id="stattop">
                        <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                            Successfully Added...!
                        </div>
                    </div>
                    <%
                    } else if (request.getParameter("delst").equals("2")) {
                    %>
                    <div  id="stattop">
                        <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                            Something Went Wrong...!
                        </div>
                    </div>
                    <%
                            }
                        }

                    %>
                    <form method="post" action="AddDistricts">
                        <div class="form-group">
                            <label>District</label>
                            <input required type="text" class="form-control" name="district">                           
                        </div>
                        <div class="form-group">
                            <label>Max Delivery Dates</label>
                            <input required type="number" class="form-control" min="0" name="max">                           
                        </div>
                        <div class="form-group">
                            <label>Min Delivery Dates</label>
                            <input required type="number" class="form-control" min="0" name="min">                           
                        </div>
                        <input type="submit" value="Add District" class="btn btn-primary">
                    </form>
                </div>
                <div class="col-md-6">
                    <h4>All Details</h4>
                    <table class="table table-striped">
                        <tr style="background-color: #00cccc;">
                            <th>District</th>
                            <th>Min Dates</th>
                            <th>Max Dates</th>
                        </tr>
                        <%                            if (hs.getAttribute("supplier") != null) {
                                pojos.Supplier supplier1 = (pojos.Supplier) hs.getAttribute("supplier");
                                pojos.Supplier supplier = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier1.getIdSupplier());

                                Set<pojos.SupplierHasDeliverydistrict> deliverydistricts = supplier.getSupplierHasDeliverydistricts();

                                for (pojos.SupplierHasDeliverydistrict deliverydistrict : deliverydistricts) {
                        %>
                        <tr>
                            <td><%= deliverydistrict.getDeliverydistrict().getDistrict()%></td>
                            <td><%= deliverydistrict.getDeliverydistrict().getTimeDurationMinDays()%></td>
                            <td><%= deliverydistrict.getDeliverydistrict().getTimeDurationMaxDays()%></td>
                        </tr>
                        <%
                                }

                            }

                        %>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>
