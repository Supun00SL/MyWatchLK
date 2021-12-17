<%-- 
    Document   : SupplierProfit
    Created on : Jul 30, 2017, 6:42:44 AM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
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
        <script  type="text/javascript" src="js/Chart.js"></script>
        <title>Supplier Profit</title>
    </head>
    <body onload="charteka()">
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
                        <li><a href="SupplierHome.jsp">Home</a></li>
                        <li><a href="AddNewProduct.jsp">Add New Product</a></li>
                        <li><a href="AddToStock.jsp">Add To Stock</a></li> 
                        <li><a href="AllStock_Sup.jsp">Stock</a></li> 
                        <li  class="active"><a href="SupplierProfit.jsp">Supplier Profit</a></li> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            HttpSession hs = request.getSession();
                            int suppid;
                            pojos.Supplier supplier = null;
                            if (hs.getAttribute("supplier") != null) {
                                pojos.Supplier supplier1 = (pojos.Supplier) hs.getAttribute("supplier");
                                supplier = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier1.getIdSupplier());

                                suppid = supplier.getIdSupplier();

                                Set<pojos.Supplierlogin> supplierlogins = supplier.getSupplierlogins();
                                if (!supplierlogins.isEmpty()) {
                                    for (pojos.Supplierlogin supplierlogin : supplierlogins) {
                        %>
                        <input type="hidden" value="<%=suppid%>" id="suppid">
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

        <div class="container-fluid">
            <div class="page-header">
                <h3>Supplier Profit</h3>
            </div>
            <div class="col-md-6">
                <canvas id="myChart" width="100" height="100"></canvas>
            </div>

            <div class="well well-lg col-lg-6" style="background-color: #66ccff; color: #ffffff;">
                <div><h4>Dear '<%=supplier.getCompanyName()%>' Your Profit is,</h4></div>
                <hr>

                <%                    Session session1 = new classes.SessionConect().testConnection();
                    double profit = 0.0;
                    Criteria profitCriteria = session1.createCriteria(pojos.Supplierpayment.class);
                    profitCriteria.add(Restrictions.eq("supplier", supplier));

                    List<pojos.Supplierpayment> profits = profitCriteria.list();

                    if (!profits.isEmpty()) {
                        for (pojos.Supplierpayment profit1 : profits) {
                            profit += profit1.getSupplierPayment();
                        }
                    }

                %>

                <h2><%=profit%> LKR</h2>
            </div>

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

        function charteka() {

            CreateRequest();
            var suppid = document.getElementById("suppid").value;
            xhttp.onreadystatechange = function() {

                if (xhttp.readyState === 4 & xhttp.status === 200) {


                    var json = eval(' ( ' + xhttp.responseText + ' ) ');
                    var vec = json['data'];

                    var labels = new Array();
                    var values = new Array();
                    for (var i = 0; i < vec.length; i++) {
                        var hm = vec[i];

                        labels.push(hm['date']);
                        values.push(hm['profit']);
                    }
                    var ctx = document.getElementById("myChart").getContext('2d');
                    var myChart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: labels,
                            datasets: [{
                                    label: '# of Profit',
                                    data: values,
                                    backgroundColor: [
                                        'rgba(0, 0, 255, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(0,0,128,1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 1
                                }]
                        },
                        options: {
                            scales: {
                                yAxes: [{
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }]
                            }
                        }
                    });

                }
            };
            xhttp.open("POST", "GetSupplierProfitToChart", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("suppid=" + suppid);



        }
    </script>
</html>
