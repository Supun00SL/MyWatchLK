<%-- 
    Document   : ViewOneProduct
    Created on : Nov 18, 2016, 11:45:23 AM
    Author     : Supun Madushanka
--%>

<%@page import="mvc.LastSeen"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <link type="text/css" rel="stylesheet" href="css/Magnify.css">       
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/magnify.js"></script>
        <script  type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="myjs/ViewProduct.js"></script>

        <style>
            .thumbnail img{
                width: 300px;
                height: 175px;

            }
        </style>

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
                var stattop = document.getElementById("stattop");
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
                                document.getElementById("stattop").innerHTML = "";
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
                                document.getElementById("stattop").innerHTML = "";
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

        </script>
        <title>View One Product</title>
    </head>
    <body>
        <%
            Session session2 = new classes.SessionConect().testConnection();
            HttpSession hs = request.getSession();

            if (request.getParameter("ideka") != null) {

                System.out.println("Id Eka :" + request.getParameter("ideka"));

                if (hs.getAttribute("lastseen") != null) {
                    LastSeen lastSeen = (LastSeen) hs.getAttribute("lastseen");
                    lastSeen.AddToLastSeen(request.getParameter("ideka") + "");

                    hs.setAttribute("lastseen", lastSeen);
                } else {
                    LastSeen lastSeen = new LastSeen();
                    lastSeen.AddToLastSeen(request.getParameter("ideka") + "");

                    hs.setAttribute("lastseen", lastSeen);
                }

            }

            if (hs.getAttribute("lastseen") != null) {
                LastSeen lastSeen = (LastSeen) hs.getAttribute("lastseen");
                System.out.println("lastseen data size :" + lastSeen.getLastSeen().size());
                for (int i = 0; i < lastSeen.getLastSeen().size(); i++) {
                    System.out.println("lastseen :" + lastSeen.getLastSeen().get(i));

                }
            }


        %>

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                    </ul>
                    <%                        if (hs.getAttribute("client") != null) {
                            pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                            pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                            Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                            if (!clientlogins.isEmpty()) {
                                for (pojos.Clientlogin clientlogin : clientlogins) {
                    %>
                    <ul class="nav navbar-nav navbar-right">
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
                        <li><a  href="clientRegistration.jsp"><span class="glyphicon glyphicon-user"></span> <%= clientlogin.getUsername()%></a></li>
                    </ul>

                    <%
                                break;
                            }
                        }
                    } else {
                    %>
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
                                <li><a href="#m2" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> 
                            </ul>
                        </li>

                    </ul>

                    <%
                        }

                    %>

                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <h3>Product Detail</h3>
            <div  id="stattop" class="hidden">
                <div class="alert alert-success fade in" id="status1"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                </div>
            </div>

            <%                    Session session1 = new classes.SessionConect().testConnection();
                pojos.Stock stock = null;
                try {
                    if (request.getParameter("ideka") != null) {
                        stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(request.getParameter("ideka")));

                        if (stock != null) {

            %>
            <div class="col-md-12  well">

                <div class="col-md-4 text-center">
                    <div class="magnify">
                        <div class="large"></div>
                        <img src="<%= stock.getProduct().getImage()%>" alt="1" width="300" height="300" class="small">
                    </div>
                </div>
                <div class="col-md-8">
                    <h3 class="text-capitalize"><%= stock.getProduct().getSearchWord()%></h3> 
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

                    <%
                        Criteria sellerCriteria = session1.createCriteria(pojos.SupplierHasStock.class);
                        sellerCriteria.add(Restrictions.eq("stock", stock));

                        List<pojos.SupplierHasStock> hasStocks = sellerCriteria.list();

                        if (!hasStocks.isEmpty()) {
                            pojos.SupplierHasStock hasStock = hasStocks.get(0);
                    %>
                    <h4 class="text-info">Seller :<%= hasStock.getSupplier().getCompanyName()%></h4>
                    <%
                        }

                    %>
                    <div class="col-md-12 well">
                        <h5 class="col-md-4">Qty: </h5>
                        <input type="number" class=" form-control col-md-6" id="<%= stock.getIdStock()%>_qty" value="1" max="<%= stock.getQty()%>" style="width: 50%;"><br>
                    </div>

                    <div>
                        <button class="btn btn-info" onclick="AddProductToCart(<%= stock.getIdStock()%>)">Add To Cart</button>
                        
                    </div>
                    <br>


                </div>


            </div>
            <%                            } else {
                            out.write("eliye");
                        }
                    } else {
                        response.sendRedirect("ProductView.jsp");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            <div class="container">
                <h3>More Details</h3>
                <div class="col-md-12 well">
                    <img src="<%= stock.getProduct().getImage()%>" alt="<%= stock.getProduct().getSearchWord()%>" class="img-thumbnail col-md-6" >
                    <div class="col-md-6">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#home">SPECS</a></li>
                            <li><a data-toggle="tab" href="#menu1">DESIGN</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                                <hr>
                                <p><strong>Watch Type :</strong><%= stock.getProduct().getAnalogdigital().getAnalogDigital()%></p>
                                <p><strong>Movement :</strong><%= stock.getProduct().getMovement().getMovement()%></p>
                                <p><strong>Case Size :</strong><%="Height =" + stock.getProduct().getCasesize().getCaseHeight() + "cm/ Width =" + stock.getProduct().getCasesize().getCaseWidth() + "cm/ Weight =" + stock.getProduct().getCasesize().getCaseWeight() + "g"%></p>
                                <p><strong>Case Type :</strong><%=stock.getProduct().getCasetype().getCaseType()%></p>
                                <p><strong>Packaging :</strong><%=stock.getProduct().getPackaging().getPackagingType()%></p>
                                <p><strong>Strap Type:</strong><%= stock.getProduct().getStraptype().getStrapType()%></p>
                                <p><strong>Grade :</strong><%= stock.getProduct().getGrade().getGrade()%></p>
                                <p><strong>Water Resistency :</strong><%= stock.getProduct().getWaterresistency().getRate()%></p>
                                <p><strong>Weight :</strong><%= stock.getProduct().getWeight().getWeight() + "g"%></p>
                            </div>
                            <div id="menu1" class="tab-pane fade">
                                <hr>
                                <p><strong>Special For :</strong><%= stock.getProduct().getGendertype().getGenderType() + " " + stock.getProduct().getAgelimit().getAgeLimit()%></p>
                                <p><strong>Color :</strong><%= stock.getProduct().getMaincolor().getColor()%></p>
                                <p><strong>Strap Color :</strong><%= stock.getProduct().getStrapcolor().getStrapColor()%></p>
                                <p><strong>Dial Color :</strong><%= stock.getProduct().getDialcolor().getDialColor()%></p>
                                <p><strong>Watch Shape :</strong><%= stock.getProduct().getWatchshape().getWatchShape()%></p>
                            </div>

                        </div>
                    </div> 
                </div>

            </div>

            <div class="container col-md-6">
                <div class="panel panel-success">
                    <div class="panel panel-heading text-center">
                        <h4>Leave a Comment</h4> 
                    </div>
                    <div class="panel panel-body">
                        <div class="text-center">
                            <p> Please Leave comment For the Product. It is very helpful to those who willing by those..!</p>
                        </div>
                        <table class="table table-hover">

                            <%
                                Criteria commentCriteria = session2.createCriteria(pojos.Comment.class);

                                commentCriteria.add(Restrictions.eq("stock", stock));
                                commentCriteria.addOrder(Order.desc("date"));
                                commentCriteria.addOrder(Order.desc("time"));
                                commentCriteria.setMaxResults(5);

                                List<pojos.Comment> comments = commentCriteria.list();

                                if (!comments.isEmpty()) {
                                    for (pojos.Comment comment : comments) {


                            %>
                            <tr>
                                <td class="col-md-4"><p class="text-capitalize"><img src="<%= comment.getClient().getImage()%>" alt="1" width="30" height="30" class="img-circle"><%=" " + comment.getClient().getFname().concat(" " + comment.getClient().getLname())%></p></td><br>
                            <td class="text-primary"><%= comment.getComment()%></td>

                            <%

                            %>
                            <td class="text-right col-md-2"><p class="label label-info bottom bottom-right"><%= new classes.Common().getdaysCount(new SimpleDateFormat("yyyy-MM-dd").format(comment.getDate()), new SimpleDateFormat("HH:mm:ss").format(comment.getTime()))%></p></td>
                            </tr>

                            <%                                    }
                                }


                            %>

                        </table>
                    </div>
                    <div class="panel panel-footer">
                        <form action="AddComment" method="post">
                            <label>Enter Your Message Here :</label>
                            <input type="hidden" value="<%= stock.getIdStock()%>" name="sto">
                            <textarea required class="form-control" rows="2" name="comment"></textarea><br>
                            <%
                                if (hs.getAttribute("client") != null) {
                            %>
                            <input type="submit" value="Comment" class="btn btn-success col-md-offset-10">

                            <%
                            } else {
                            %>
                            <input type="button" value="Login first" class="btn btn-success col-md-offset-10 disabled">

                            <%
                                }
                            %>
                        </form>
                    </div>
                </div>
            </div>
            <div class="container col-md-6">
                <div class="page-header">
                    <h4>Photo Gallery</h4>

                </div>
                <div class="row">
                    <%
                        if (stock != null) {
                            if (stock.getProduct().getImage() != null) {
                    %>
                    <div class="col-md-4">
                        <a href="#m1" data-toggle="modal" class="thumbnail">
                            <img src="<%= stock.getProduct().getImage()%>">
                        </a>
                        <div class="modal fade" id="m1">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header text-capitalize"><%= stock.getProduct().getSearchWord()%></div>
                                    <!--Add here For loop for images-->
                                    <div class="modal-body text-center">
                                        <img src="<%= stock.getProduct().getImage()%>" class="img-thumbnail">
                                    </div>
                                    <div class="modal-footer">
                                        <p>
                                            <%= stock.getProduct().getSearchWord()%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <%
                    }
                            if (stock.getProduct().getImage1() != null) {
                    %>
                    <div class="col-md-4">
                        <a href="#m2" data-toggle="modal" class="thumbnail">
                            <img src="<%= stock.getProduct().getImage1()%>">
                        </a>
                        <div class="modal fade" id="m2">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header text-capitalize"><%= stock.getProduct().getSearchWord()%></div>
                                    <!--Add here For loop for images-->
                                    <div class="modal-body text-center">
                                        <img src="<%= stock.getProduct().getImage1()%>" class="img-thumbnail">
                                    </div>
                                    <div class="modal-footer">
                                        <p>
                                            <%= stock.getProduct().getSearchWord()%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                    }
                            if (stock.getProduct().getImage2() != null) {
                    %>
                    <div class="col-md-4">
                        <a href="#m3" data-toggle="modal" class="thumbnail">
                            <img src="<%= stock.getProduct().getImage2()%>">
                        </a>
                        <div class="modal fade" id="m3">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header text-capitalize"><%= stock.getProduct().getSearchWord()%></div>
                                    <!--Add here For loop for images-->
                                    <div class="modal-body text-center">
                                        <img src="<%= stock.getProduct().getImage2()%>" class="img-thumbnail">
                                    </div>
                                    <div class="modal-footer">
                                        <p>
                                            <%= stock.getProduct().getSearchWord()%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        } else {
                            response.sendRedirect("ProductView.jsp");
                        }
                    %>


                </div>
            </div>
        </div>
        <div class="modal fade" id="m2">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post" action="SimpleRegistrationClient">
                        <div class="modal-header text-capitalize" style="font-size: x-large;"><span class="glyphicon glyphicon-user"></span>  Sign Up</div>
                        <div class="modal-body">
                            <div  id="stattop" class="hidden">
                                <div class="alert alert-success fade in row" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                                </div>

                            </div> 

                            <div class="form-group col-md-6">
                                <label>First Name :</label> 
                                <input required type="text"  class="form-control" placeholder="First Name" name="fname" id="fname">
                            </div>

                            <div class="form-group col-md-6">
                                <label>Last Name :</label> 
                                <input type="text" name="lname" id="lname" class="form-control" placeholder="Last Name">
                            </div>
                            <div class="form-group col-md-12">
                                <label>Email :</label> 
                                <input required type="text"  name="email" id="email" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group col-md-12">
                                <label>User Name :</label>
                                <input required type="text" name="username" id="username" class="form-control" placeholder="User Name">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Password :</label> 
                                <input required type="password" name="password" id="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Re Enter Password :</label> 
                                <input required type="password" name="reenterpassword" id="reenterpassword" class="form-control" placeholder="Re Enter Password">
                            </div>  
                        </div>
                        <div class="modal-footer">
                            <input type="submit" value="Save" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="PageFooter.jsp" %>
    </body>
</html>
