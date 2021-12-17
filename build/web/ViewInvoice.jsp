<%-- 
    Document   : ViewInvoice
    Created on : Jan 4, 2017, 12:18:42 PM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
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
        <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>JSP Page</title>
        
    </head>
    <body >
        <%
            Session session2 = new classes.SessionConect().testConnection();
        %>
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>


                </div>
            </div>
        </nav>
        <div class="container">
            <div class="page-header">
                <h3>Invoice</h3>
            </div>

            <div class="col-md-offset-9">
                <%
                    HttpSession hs = request.getSession();
                    if (hs.getAttribute("client") != null) {
                        pojos.Client client = (pojos.Client) hs.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());


                %>
                <label>Name :<%= client1.getFname() + " " + client1.getLname()%></label><br>
                <label>Address :<%= client1.getAddressno() + " " + client1.getStreet1() + " " + client1.getStreet2()%></label><br>
                <label>Contact :<%= client1.getMobileno() + " / " + client1.getTelephoneno()%></label><br>
                <label>Email :<%= client1.getEmail()%></label><br>
                <%
                    }
                %>


            </div>
            <hr>
            <div>
                <table class="table table-hover col-md-12">
                    <tr class="bg-info">
                        <th style="color: #999999;">Product Name & Details</th>
                        <th style="color: #999999;">Quantity</th>
                        <th style="color: #999999;">Price</th>
                        <th style="color: #999999;">Shipping Details</th>
                    </tr>

                    <%                        try {

                            if (hs.getAttribute("client") != null) {
                                pojos.Invoice invoice = (pojos.Invoice) hs.getAttribute("invoice");

                                pojos.Invoice invoice1 = (pojos.Invoice) session2.load(pojos.Invoice.class, invoice.getIdInvoice());

                                System.out.println("Other row :" +invoice1.getIdInvoice());
                                System.out.println("Other row :" +invoice1.getInvoiceHasStocks());
                                Set<pojos.InvoiceHasStock> hasStocks = invoice1.getInvoiceHasStocks();
                                for (pojos.InvoiceHasStock invoiceHasStock : hasStocks) {

                    %>
                    <tr>
                        <td class="col-md-3">
                            <img src="<%= invoiceHasStock.getStock().getProduct().getImage()%>" class="img-rounded" alt="1" width="100" height="75">
                            <h5 class="text-capitalize"><%= invoiceHasStock.getStock().getProduct().getSearchWord()%></h5>

                        </td>
                        <td>
                            <label class="text-danger"><%= invoiceHasStock.getQty()%></label>

                        </td>
                        <td>
                            <label>RS <%= new classes.Common().VALUE_FORMAT.format(invoiceHasStock.getTotal())%> </label>

                        </td>
                        <td>
                            <label style="color: #999999;">Sub Total :</label>
                            <label>RS <%= new classes.Common().VALUE_FORMAT.format(invoiceHasStock.getTotal())%></label>
                            <br>
                            <label style="color: #999999;">Shipping Cost :</label>
                            <label>RS <%= new classes.Common().VALUE_FORMAT.format(0.00)%></label>

                            <div class="col-md-offset-9 ">
                                <label style="color: #999999;">Total :</label>
                                <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(invoiceHasStock.getTotal())%></label>
                            </div>
                        </td>

                    </tr>
                    <%

                                }
                            } else {
                                response.sendRedirect("clientLogin.jsp");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    %>
                </table>

            </div>
                        <div class="container">
            <div class="well text-right">
                <%                    HttpSession hs3 = request.getSession();
                    if (hs3.getAttribute("client") != null) {
                        if (hs3.getAttribute("invoice") != null) {

                            pojos.Client client = (pojos.Client) hs3.getAttribute("client");

                            pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());
                            Criteria invoiceCriteria = session2.createCriteria(pojos.Invoice.class);

                            pojos.Invoice invoice = (pojos.Invoice) hs3.getAttribute("invoice");
                            pojos.Invoice invoice1 = (pojos.Invoice) session2.load(pojos.Invoice.class, invoice.getIdInvoice());
                            invoiceCriteria.add(Restrictions.eq("idInvoice", invoice1.getIdInvoice()));

                            List<pojos.Invoice> invoices = invoiceCriteria.list();

                            if (!invoices.isEmpty()) {
                                pojos.Invoice invoice2 = invoices.get(0);
                %>
                <div class="col-md-offset-9">
                    <label  style="color: #999999;">Sub Total (<%= invoice2.getInvoiceHasStocks().size()%> Items):</label>
                    <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(invoice2.getNetTotal())%></label>

                    <br>

                    <label  style="color: #999999;">Shipping Cost (<%= invoice2.getInvoiceHasStocks().size()%> Items):</label>
                    <label class="text-primary">RS <%= new classes.Common().VALUE_FORMAT.format(0.00)%></label>

                    <hr>
                    <label  style="color: #999999; font-size: large;">All Total :</label>
                    <label class="text-success" style="font-size: x-large;">RS <%= new classes.Common().VALUE_FORMAT.format(invoice2.getNetTotal())%></label>
                    <br>

                    <button type="button" class="btn btn-success" onclick="printinvoice()"><span class="glyphicon glyphicon-usd"></span>  Print</button>

                </div>

                <%
                            }
                        }
                    }
                    session2.close();
                %> 

            </div>
        </div>

        </div>
       <script>

            function printinvoice() {
                window.print();

            }


        </script>

    </body>
    
</html>
