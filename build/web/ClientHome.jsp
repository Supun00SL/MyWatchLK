<%-- 
    Document   : ClientHome
    Created on : Dec 13, 2016, 3:11:39 PM
    Author     : Supun Madushanka
--%>

<%@page import="pojos.Advertisement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvc.LastSeen"%>
<%@page import="java.util.Set"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
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
        <script  type="text/javascript" src="js/nanobar.js"></script>
        <script type="text/javascript" src="myjs/ViewProduct.js"></script>



        <title>My Watch.lk</title>

        <script>
            var xhttp;

            function CreateRequest() {
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();

                } else if (window.ActiveXObject) {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

            }
            function AddProductToCart(item) {
                var id = item;

                var qty = document.getElementById(id + "_qty").value;

                var available = document.getElementById(id + "_avqty").innerHTML;


                CreateRequest();
                var stattop = document.getElementById("stattop1");
                xhttp.onreadystatechange = function() {

                    if (xhttp.readyState === 4 & xhttp.status === 200) {


                        var text = xhttp.responseText;
                        if (text === "1") {
                            stattop.className = "show";

                            if (document.getElementById("status1") == null) {
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-success fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Successfully Added to The Cart..!';
                                stattop.appendChild(elem);

                            } else {
                                document.getElementById("stattop1").innerHTML = "";
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-success fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Successfully Added to The Cart..!';
                                stattop.appendChild(elem);
                            }



                            document.getElementById(id + "_avqty").innerHTML = ((available * 1) - (qty * 1));

                        } else if (text === "0") {
                            stattop.className = "show";
                            if (document.getElementById("status1") == null) {
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-danger fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Quantity is Not Available..!';
                                stattop.appendChild(elem);
                            } else {
                                document.getElementById("stattop1").innerHTML = "";
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-danger fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Quantity is Not Available..!';
                                stattop.appendChild(elem);
                            }
                        }
                    }
                };
                xhttp.open("POST", "AddToCart", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("id=" + id + "&qty=" + qty);
            }

            function Watch(item) {
                var id = item;
                CreateRequest();
                var stattop = document.getElementById("stattop1");
                xhttp.onreadystatechange = function() {

                    if (xhttp.readyState === 4 & xhttp.status === 200) {


                        var text = xhttp.responseText;
                        if (text === "1") {
                            stattop.className = "show";

                            if (document.getElementById("status1") == null) {
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-success fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Successfully Added to The Watch List..!';
                                stattop.appendChild(elem);

                            } else {
                                document.getElementById("stattop1").innerHTML = "";
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-success fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Successfully Added to The Watch List..!';
                                stattop.appendChild(elem);
                            }





                        } else if (text === "0") {
                            stattop.className = "show";
                            if (document.getElementById("status1") == null) {
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-danger fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Something Went Wrong..!';
                                stattop.appendChild(elem);
                            } else {
                                document.getElementById("stattop1").innerHTML = "";
                                var elem = document.createElement("div");
                                elem.id = "status1";
                                elem.className = "alert alert-danger fade in row";
                                elem.innerHTML = '<a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>Something Went Wrong..!';
                                stattop.appendChild(elem);
                            }
                        }
                    }
                };
                xhttp.open("POST", "AddToWatch", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("id=" + id);

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
                        <li class="active"><a href="ClientHome.jsp">Client Home</a></li>
                        <li><a href="ClientInvoiceHistory.jsp">Client Invoice History</a></li>
                        <li><a href="CompleteOrders.jsp">Complete Orders</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                                        HttpSession hs = request.getSession();

                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        %>
                        <li>
                            <div class="well-sm">
                                <form class="form-inline">
                                    <input type="text" class="form-control" placeholder="I'm shopping for.....">
                                    <button class="btn btn-info glyphicon glyphicon-search form-control"></button>
                                </form>
                            </div>

                        </li>
                        <li><a  href="ClientWatchList.jsp"><span class="glyphicon glyphicon-eye-open"><span class="badge" id="wb"><%= new mvc.ClientHome().ReturnWatchListBadgeCount(client)%></span></span> </a></li>
                        <li><a href="ViewCart.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge" id="cb"><%= new mvc.ClientHome().ReturnCartBadgeCount(client)%></span></span></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> My Account
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>
                                <li onclick="logout()"><span class="glyphicon glyphicon-log-out"></span> Logout</li>

                            </ul>
                        </li>

                        <%
                                        break;
                                    }
                                }
                            } else {
                                response.sendRedirect("index.jsp");
                            }

                        %>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <%                if (request.getParameter("stat") != null) {
                    if (request.getParameter("stat").equals("2")) {
            %>
            <div  id="stattop">
                <div class="alert alert-success fade in row" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>
                    Please Verify Your Email before Continue !
                </div>

            </div> 
            <%
                    }
                }

            %>
            <div class="col-md-3">
                <div class="well bg-primary col-md-12" >
                    <%                        HttpSession hs1 = request.getSession();

                        if (hs1.getAttribute("client") != null) {
                            pojos.Client client1 = (pojos.Client) hs1.getAttribute("client");
                            pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                    %>
                    <div class="col-md-6">
                        <img src="<%= client.getImage()%>" class="img-circle img-thumbnail" style="width: 100px; height: 95px;">
                    </div>
                    <h4 class="text-capitalize text-left" style="color: black;"><%= client.getFname() + " " + client.getLname()%></h4>
                    <h6 class="text-capitalize text-left" style="color: #666666">(Client)</h6>
                    <span><img src="icons/822.png"></span>
                    <span class="text-capitalize text-left label label-info">
                        <%=client.getPoints()%> Points !!!
                    </span>
                    <%                        }
                    %>
                </div>
                <div class="well well-sm">
                    <ul class="list-inline">
                        <li> <h4> Categories</h4></li>
                        <li> <a href="" style="color: #666666;">See All >></a></li>
                    </ul>

                </div>
                <div class="panel-group" id="according1">                   
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla1" data-toggle="collapse" data-parent="#according1">Gender Type</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla1">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%                                        Criteria gendertypeCriteria = session2.createCriteria(pojos.Gendertype.class);
                                        List<pojos.Gendertype> gendertypes = gendertypeCriteria.list();

                                        if (!gendertypes.isEmpty()) {
                                            for (pojos.Gendertype gendertype : gendertypes) {
                                    %>
                                    <a href="index.jsp?p=gen_<%= gendertype.getIdGenderType()%>"><li class="list-group-item"><%= gendertype.getGenderType()%></li></a>
                                            <%
                                                    }
                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla2" data-toggle="collapse" data-parent="#according1">Brand</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla2">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%                                        Criteria brandCriteria = session2.createCriteria(pojos.Brand.class);
                                        List<pojos.Brand> brands = brandCriteria.list();

                                        if (!brands.isEmpty()) {
                                            for (pojos.Brand brand : brands) {
                                                if (brand != null) {
                                    %>
                                    <a href="index.jsp?p=br_<%= brand.getIdBrand()%>"><li class="list-group-item"><%= brand.getBrand()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla3" data-toggle="collapse" data-parent="#according1">Colors</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla3">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria maincolorCriteria = session2.createCriteria(pojos.Maincolor.class);
                                        List<pojos.Maincolor> maincolors = maincolorCriteria.list();

                                        if (!maincolors.isEmpty()) {
                                            for (pojos.Maincolor maincolor : maincolors) {
                                                if (maincolor != null) {
                                    %>
                                    <a href="index.jsp?p=co_<%= maincolor.getIdMainColor()%>"><li class="list-group-item"><%= maincolor.getColor()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla4" data-toggle="collapse" data-parent="#according1">Movement</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla4">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria movementCriteria = session2.createCriteria(pojos.Movement.class);
                                        List<pojos.Movement> movements = movementCriteria.list();

                                        if (!movements.isEmpty()) {
                                            for (pojos.Movement movement : movements) {
                                                if (movement != null) {
                                    %>
                                    <a href="index.jsp?p=mo_<%= movement.getIdmovement()%>"><li class="list-group-item"><%= movement.getMovement()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla5" data-toggle="collapse" data-parent="#according1">Watch Shape</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla5">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria WatchshapeCriteria = session2.createCriteria(pojos.Watchshape.class);
                                        List<pojos.Watchshape> watchshapes = WatchshapeCriteria.list();

                                        if (!watchshapes.isEmpty()) {
                                            for (pojos.Watchshape watchshape : watchshapes) {
                                                if (watchshape != null) {
                                    %>
                                    <a href="index.jsp?p=ws_<%= watchshape.getIdWatchShape()%>"><li class="list-group-item"><%= watchshape.getWatchShape()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla6" data-toggle="collapse" data-parent="#according1">Grade</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla6">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria gradeCriteria = session2.createCriteria(pojos.Grade.class);
                                        List<pojos.Grade> grades = gradeCriteria.list();

                                        if (!grades.isEmpty()) {
                                            for (pojos.Grade grade : grades) {
                                                if (grade != null) {
                                    %>
                                    <a href="index.jsp?p=gr_<%= grade.getIdGrade()%>"><li class="list-group-item"><%= grade.getGrade()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla7" data-toggle="collapse" data-parent="#according1">Age Limit</a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla7">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria agelimitCriteria = session2.createCriteria(pojos.Agelimit.class);
                                        List<pojos.Agelimit> agelimits = agelimitCriteria.list();

                                        if (!agelimits.isEmpty()) {
                                            for (pojos.Agelimit agelimit : agelimits) {
                                                if (agelimit != null) {
                                    %>
                                    <a href="index.jsp?p=al_<%= agelimit.getIdAgeLimit()%>"><li class="list-group-item"><%= agelimit.getAgeLimit()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla8" data-toggle="collapse" data-parent="#according1">Water Resistency </a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla8">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria waterresistCriteria = session2.createCriteria(pojos.Waterresistency.class);
                                        List<pojos.Waterresistency> waterresistencys = waterresistCriteria.list();

                                        if (!waterresistencys.isEmpty()) {
                                            for (pojos.Waterresistency waterresistency : waterresistencys) {
                                                if (waterresistency != null) {
                                    %>
                                    <a href="index.jsp?p=wr_<%= waterresistency.getIdWaterResistency()%>"><li class="list-group-item"><%= waterresistency.getRate()%>%</li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla9" data-toggle="collapse" data-parent="#according1">Watch Type </a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla9">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria watchtypeCriteria = session2.createCriteria(pojos.Analogdigital.class);
                                        List<pojos.Analogdigital> analogdigitals = watchtypeCriteria.list();

                                        if (!analogdigitals.isEmpty()) {
                                            for (pojos.Analogdigital analogdigital : analogdigitals) {
                                                if (analogdigital != null) {
                                    %>
                                    <a href="index.jsp?p=ad_<%= analogdigital.getIdAnalogDigital()%>"><li class="list-group-item"><%= analogdigital.getAnalogDigital()%></li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">            
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#cla10" data-toggle="collapse" data-parent="#according1">Weight </a>
                            </h4>
                        </div>
                        <div class="collapse panel-collapse" id="cla10">
                            <div class="panel-body">
                                <ul class="list-group">
                                    <%
                                        Criteria weightCriteria = session2.createCriteria(pojos.Weight.class);
                                        List<pojos.Weight> weights = weightCriteria.list();

                                        if (!weights.isEmpty()) {
                                            for (pojos.Weight weight : weights) {
                                                if (weight != null) {
                                    %>
                                    <a href="index.jsp?p=we_<%= weight.getIdWeight()%>"><li class="list-group-item"><%= weight.getWeight()%> grams</li></a>
                                            <%
                                                        }
                                                    }

                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h5>Last Seen</h5>
                    </div>
                    <div class="panel-body">
                        <%
                            if (hs.getAttribute("lastseen") != null) {

                                LastSeen lastSeen = (LastSeen) hs.getAttribute("lastseen");
                                ArrayList<String> arrayList = lastSeen.getLastSeen();
                                System.out.println("On Page : " + arrayList);
                                int i = 0;
                                for (String id : arrayList) {
                                    pojos.Stock stock = (pojos.Stock) session2.load(pojos.Stock.class, Integer.parseInt(id));
                                    System.out.println("Product : " + stock.getProduct().getSearchWord());
                                    if (i == 3) {
                                        break;
                                    }
                        %>
                        <div class="well well-sm">

                            <label><%= stock.getProduct().getSearchWord()%></label>
                            <img src="<%= stock.getProduct().getImage()%>" alt="<%= stock.getProduct().getSearchWord()%>" class="img-rounded" height="200">
                            <br><br> <button class="btn btn-success col-md-offset-7" onclick="View1(<%= stock.getIdStock()%>)">View Again</button>
                        </div>
                        <%
                                    i++;
                                }
                            }

                        %>

                    </div>


                </div>
            </div>

            <div class="col-md-9">
                <div class="col-md-9">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="img/slider_1.jpg" alt="Chania">
                                <div class="carousel-caption">
                                    <h2 class="animated bounceInRight">Best Watchers In the World</h2>
                                    <p class="animated fadeInUp">TIOSST the best Sellers with Luxury Watchers.</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img/slider_2.jpg" alt="Chania">
                                <div class="carousel-caption">
                                    <h2 class="animated bounceInLeft">Best Watchers In the World</h2>
                                    <p class="animated fadeInUp">TIOSST the best Sellers with Luxury Watchers.</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img/slider_3.jpg" alt="Flower">
                                <div class="carousel-caption">
                                    <h2 class="animated bounceInUp">Best Watchers In the World</h2>
                                    <p class="animated fadeInUp">TIOSST the best Sellers with Luxury Watchers.</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img/slider_4.jpg" alt="Flower">
                                <div class="carousel-caption">
                                    <h2 class="animated bounceInDown">Best Watchers In the World</h2>
                                    <p class="animated fadeInUp">TIOSST the best Sellers with Luxury Watchers.</p>
                                </div>
                            </div>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col-md-3 well">
                    <h5 class="text-center" style="font:'HolidayPi BT';">Advertisements <span class="label label-danger">New !!!</span></h5>
                    <hr>

                    <%                        Criteria addcriteria = session2.createCriteria(pojos.Advertisement.class);
                        addcriteria.add(Restrictions.eq("state", "active"));
                        List<pojos.Advertisement> advertisements = addcriteria.list();
                        pojos.Advertisement advertisement = null;
                        int addid = 0;
                        if (!advertisements.isEmpty()) {
                            for (int i = 0; i < advertisements.size(); i++) {
                                advertisement = advertisements.get(0);
                                addid = advertisement.getIdAdvertisement();

                            }
                        }

                        if (addid != 0) {

                            pojos.Advertisement advertisement1 = (Advertisement) session2.load(pojos.Advertisement.class, addid);
                    %>
                    <img src="<%=advertisement1.getImage()%>" class="img-rounded" width='200' heigh='350'>
                    <hr>
                    <p class="p small text-center">
                        <%=advertisement1.getDescription()%>
                    </p>
                    <%
                    } else {
                    %>
                    <img src="img/advertse1.jpg" class="img-rounded" width='200' heigh='350'>
                    <hr>
                    <p class="p small text-center">
                        New Ladies Watch is going to be Introduce on 23rd of Feb in 2016.
                    </p>
                    <%
                        }
                    %>


                </div>
                <div class="row">

                </div>
                <hr>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3>Featured List</h3>
                    </div>
                    <div class="panel-body">
                        <div>
                            <div  id="stattop1" class="hidden">
                                <!--                                <div class="alert alert-success fade in row" id="status1"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                                                                </div>-->

                            </div>  
                            <%                                int FirstResult = 0;
                                int MaxResult = 6;

                                if (request.getParameter("fr") != null) {
                                    int x = Integer.parseInt(request.getParameter("fr"));
                                    FirstResult = x * MaxResult;
                                }
                                Session session1 = new classes.SessionConect().testConnection();
                                Criteria productCriteria = session1.createCriteria(pojos.Stock.class);

                                Criteria productCriteria1 = session1.createCriteria(pojos.Product.class);
                                pojos.Product product = null;

                                if (request.getParameter("p") != null) {
                                    System.out.print("asd0");

                                    if (request.getParameter("p").split("_")[0].equals("gen")) {
                                        System.out.print("asd1");

                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Gendertype gendertype = (pojos.Gendertype) session1.load(pojos.Gendertype.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("gendertype", gendertype));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("br")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Brand brand = (pojos.Brand) session1.load(pojos.Brand.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("brand", brand));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("co")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Maincolor maincolor = (pojos.Maincolor) session1.load(pojos.Maincolor.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("maincolor", maincolor));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("mo")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Movement movement = (pojos.Movement) session1.load(pojos.Movement.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("movement", movement));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("ws")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Watchshape watchshape = (pojos.Watchshape) session1.load(pojos.Watchshape.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("watchshape", watchshape));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("gr")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Grade grade = (pojos.Grade) session1.load(pojos.Grade.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("grade", grade));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("al")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Agelimit agelimit = (pojos.Agelimit) session1.load(pojos.Agelimit.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("agelimit", agelimit));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("wr")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Waterresistency waterresistency = (pojos.Waterresistency) session1.load(pojos.Waterresistency.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("waterresistency", waterresistency));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("ad")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Analogdigital analogdigital = (pojos.Analogdigital) session1.load(pojos.Analogdigital.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("analogdigital", analogdigital));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("we")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Weight weight = (pojos.Weight) session1.load(pojos.Weight.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("weight", weight));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    }
                                }

                                int ResultSize = productCriteria.list().size();
                                productCriteria.setFirstResult(FirstResult);
                                productCriteria.setMaxResults(MaxResult);
                                List<pojos.Stock> stocks = productCriteria.list();

                                if (!stocks.isEmpty()) {
                                    for (pojos.Stock stock : stocks) {
                            %>

                            <div class="col-md-4">
                                <div class="panel panel-info">
                                    <div class="panel-heading">

                                        <h5 style="font-weight: bold;"><%= stock.getProduct().getSearchWord()%></h5>
                                    </div>
                                    <div class="panel-body text-center">
                                        <img src=" <%= stock.getProduct().getImage()%>" height="200"  alt="1" class="img-rounded">



                                    </div>
                                    <div class="panel-footer">
                                        <h4 class="text-danger" style="font-weight: bold;"> RS <%= classes.Common.VALUE_FORMAT.format(stock.getFinalPrice())%></h4>
                                        <%
                                            System.out.println("final :" + stock.getFinalPrice());
                                            System.out.println("sell :" + stock.getSellingPrice());
                                            if (!stock.getFinalPrice().toString().equals(stock.getSellingPrice().toString())) {
                                        %>

                                        <del class="text-danger"> RS <%= classes.Common.VALUE_FORMAT.format(stock.getSellingPrice())%></del>
                                        <%
                                        } else {
                                        %>
                                        <br>
                                        <%
                                            }
                                        %>
                                        <h5 > Available Quantity:<p id="<%= stock.getIdStock()%>_avqty"> <%= stock.getQty()%><p></h5>
                                        <div class="col-md-12 well">
                                            <h5 class="col-md-4">Qty: </h5>
                                            <input type="number" class=" form-control col-md-6" id="<%= stock.getIdStock()%>_qty" value="1" max="<%= stock.getQty()%>" style="width: 50%;"><br>
                                        </div>
                                        <div>
                                            <button class="btn btn-info" onclick="AddProductToCart(<%= stock.getIdStock()%>)">Add To Cart</button>
                                            <button class="btn btn-primary" onclick="View1(<%= stock.getIdStock()%>)">View More</button>
                                            <button class="btn btn-success" onclick="Watch(<%= stock.getIdStock()%>)"><span class="glyphicon glyphicon-eye-open"></span></button>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <%
                                    }

                                }
                            %>
                            <div class="panel panel-footer col-md-12 text-center">
                                <ul class="pagination">      
                                    <%
                                        int c = ResultSize % MaxResult;
                                        int val = 0;
                                        if (c == 0) {
                                            val = ResultSize / MaxResult;
                                        } else {
                                            val = ((ResultSize / MaxResult) + 1);
                                        }
                                        for (int i = 0; i < val; i++) {

                                    %>
                                    <li id="<%=i%>_li">
                                        <a href="ClientHome.jsp?fr=<%=i%>"><%= (i + 1)%></a>
                                    </li>
                                    <%
                                        }

                                        session1.close();
                                    %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="PageFooter.jsp" %>
    </body>
</html>
