<%-- 
    Document   : ProductView
    Created on : Nov 17, 2016, 7:59:36 PM
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
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js">
        </script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <!--<script type="text/javascript" src="myjs/ViewProduct.js"></script>-->
        <script>



        </script>
        <title>Product View</title>
    </head>
    <body>

<!--        <div class="container-fluid">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">My Watch</a>
                    </div>
                    <div>
                        <ul class="nav navbar-nav">
                            <li><a href="#">Home</a></li>
                            <li><a href="ViewCart.jsp">Cart</a></li>
                            <li><a href="#">Page 2</a></li> 
                            <li><a href="#">Page 3</a></li> 
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li  class="active"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>

                    </div>
                </div>
            </nav>
            <div class="page-header">
                <h3>Product Details</h3>
            </div>
        </div>-->
        <!--<div class="container">-->
            <div>
                <div  id="stattop" class="hidden">
                    <div class="alert alert-success fade in row" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                    </div>

                </div>  
                <%                int FirstResult = 0;
                    int MaxResult = 6;

                    if (request.getParameter("fr") != null) {
                        int x = Integer.parseInt(request.getParameter("fr"));
                        FirstResult = x * MaxResult;
                    }
                    Session session1 = new classes.SessionConect().testConnection();
                    
                    Criteria genCriteria=session1.createCriteria(pojos.Gendertype.class);
                    

                    Criteria productCriteria = session1.createCriteria(pojos.Stock.class);
                    int ResultSize = productCriteria.list().size();
                    productCriteria.setFirstResult(FirstResult);
                    productCriteria.setMaxResults(MaxResult);
                    List<pojos.Stock> stocks = productCriteria.list();

                    if (!stocks.isEmpty()) {
                        for (pojos.Stock stock : stocks) {
                %>

                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3>Item Code :<%= stock.getBarcode()%></h3>
                            <h4><%= stock.getProduct().getSearchWord()%></h4>
                        </div>
                        <div class="panel-body text-center">
                            <img src=" <%= stock.getProduct().getImage()%>" width="200" height="200" alt="1" class="img-rounded">
                        </div>
                        <div class="panel-footer">
                            <h4> Product Price:  <%= stock.getSellingPrice()%>LKR</h4>
                            <h4> Available Quantity: <%= stock.getQty()%></h4>
                            <h4> Add to Cart Qty: </h4>
                            <input type="number" class=" form-control" id="<%= stock.getIdStock()%>_qty" value="1" max="<%= stock.getQty()%>"><br>
                            <div class="text-right">
                                <button class="btn btn-default" onclick="AddToCart(<%= stock.getIdStock()%>)">Add To Cart  <span class="glyphicon glyphicon-eye-open"></span> </button>
                                <button class="btn btn-default" onclick="View(<%= stock.getIdStock()%>)">View This Product</button>
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
                            <a href="index.jsp?fr=<%=i%>"><%= (i + 1)%></a>
                        </li>
                        <%
                            }
                            
                            session1.close();
                        %>
                    </ul>
                </div>
            </div>
        <!--</div>-->
    </body>
</html>
