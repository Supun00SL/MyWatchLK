<%-- 
    Document   : AdminProfit
    Created on : Jul 27, 2017, 8:36:04 AM
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
        <script  type="text/javascript" src="js/Chart.js"></script>



        <title>Admin Profit</title>
    </head>
    <body onload="load()">
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="AdminHome.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="AdminHome.jsp">Admin Home</a></li>
                        <li  ><a href="AllStock.jsp">Stock</a></li>
                        <li ><a href="AddNewAdvertisement.jsp">Add New Advertisement</a></li>
                        <li class="active"><a href="AdminProfit.jsp">Admin Profit</a></li>
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
                <h3>Admin Profit</h3>
            </div>
            <div class="col-md-6">
                <canvas id="myChart" width="100" height="100"></canvas>
            </div>

            <div class="well well-lg col-lg-6" style="background-color: #00cc66; color: #ffffff;">
                <div><h4>Your Admin Profit is,</h4></div>
                <hr>

                <%                    Session session1 = new classes.SessionConect().testConnection();
                    double profit = 0.0;
                    Criteria profitCriteria = session1.createCriteria(pojos.Profit.class);

                    List<pojos.Profit> profits = profitCriteria.list();

                    if (!profits.isEmpty()) {
                        for (pojos.Profit profit1 : profits) {
                            profit += profit1.getProfit();
                        }
                    }

                %>

                <h2><%=profit%> LKR</h2>
            </div>

            <div class="col-md-6 text-center">
                <h4>Most Products Sell by Suppliers</h4>
                <hr>
                <div class="col-md-9 text-center">

                    <canvas id="myChartpie" width="100" height="100"></canvas>
                </div>
            </div>

        </div>
        <br>
        <%@include file="PageFooter.jsp" %>
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

        function charteka() {

            CreateRequest();
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
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255,99,132,1)',
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
            xhttp.open("POST", "GetAdminProfitToChart", false);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send();



        }
        function chartekapie() {

            CreateRequest();
            xhttp.onreadystatechange = function() {

                if (xhttp.readyState === 4 & xhttp.status === 200) {

                    var json = eval(' ( ' + xhttp.responseText + ' ) ');
                    var vec = json['data'];

                    var labels = new Array();
                    var values = new Array();
                    for (var i = 0; i < vec.length; i++) {
                        var hm = vec[i];

                        labels.push(hm['supplier']);
                        values.push(hm['count']);
                    }
                    var ctx = document.getElementById("myChartpie").getContext('2d');
                    var myChart = new Chart(ctx, {
                        type: 'doughnut',
                        options: {
                            animation: {
                                animateScale: true
                            }
                        },
                        data: {
                            labels: labels,
                            datasets: [{
                                    label: '# of Selled Count',
                                    data: values,
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255,1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderColor: [
                                        'rgba(255,99,132,1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 1
                                }]
                        }
                    });

                }
            };
            xhttp.open("POST", "GetMostSelledProductbySupplier", false);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send();



        }

        function load() {
            chartekapie();
            charteka();

        }
    </script>

</html>
