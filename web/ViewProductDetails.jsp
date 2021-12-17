<%-- 
    Document   : ViewProductDetails
    Created on : Nov 23, 2016, 9:34:27 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.List"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
                <%
                    Session session1 = new classes.SessionConect().testConnection();
                    pojos.Stock stock = null;
                    try {
                        if (request.getParameter("ideka") != null) {
                            stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(request.getParameter("ideka")));

                            if (stock != null) {

                %>
                <table class="table table-bordered">
                    <tr>
                        <td class="text-center">
                            <div class="magnify">
                                <div class="large"></div>
                                <img src="img/watch-fresh-new-hd-best-quality-596680.jpg" alt="1" width="200" height="150" class="small">
                            </div>
                        </td>
                        <td>
                            <h3 class="text-capitalize"><%= stock.getProduct().getSearchWord()%></h3> 
                            <h4 class="text-success">Item Code :<%= stock.getBarcode()%></h4>                                                          
                            <!--<h4>Brand :</h4>-->                               
                            <h4 class="text-danger">Available QTY :<%= stock.getQty()%></h4>
                            <h4 class="text-info">Unit Price :<%= stock.getFinalPrice() %> LKR</h4>
                            <br>
                            <%
                                Criteria sellerCriteria = session1.createCriteria(pojos.SupplierHasStock.class);
                                sellerCriteria.add(Restrictions.eq("stock", stock));

                                List<pojos.SupplierHasStock> hasStocks = sellerCriteria.list();

                                if (!hasStocks.isEmpty()) {
                                    pojos.SupplierHasStock hasStock = hasStocks.get(0);
                            %>
                            <h3 class="text-info">Seller :<%= hasStock.getSupplier().getCompanyName()%></h3>
                            <%
                                }

                            %>

                        </td>
                    </tr>

                </table>
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

            </div>
    </body>
</html>
