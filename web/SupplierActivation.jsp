<%-- 
    Document   : SupplierActivation
    Created on : Dec 17, 2016, 2:25:49 PM
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
        
        <title>Supplier Activation</title>
    </head>
    <body>
        <%
            Session session1 = new classes.SessionConect().testConnection();

        %>
        <div class="container">
            <div class="page-header">
                <h3>Supplier Activation</h3>
            </div>
            <table class="table table-striped">
                <tr>
                    <th>GovReg Code</th>
                    <th>Company Name</th>
                    <th>Mobile</th>
                    <th>Telephone</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Verification</th>

                </tr>
                <%                    Criteria supplierCriteria = session1.createCriteria(pojos.Supplier.class);

                    List<pojos.Supplier> suppliers = supplierCriteria.list();

                    if (!suppliers.isEmpty()) {
                        for (pojos.Supplier supplier : suppliers) {
                %>
                <form method="post" action="SupplierActivation">
                    <tr>
                        <td><%= supplier.getGovRegistrationCode()%></td>
                        <td><%= supplier.getCompanyName()%></td>
                        <td><%= supplier.getMobileno()%></td>
                        <td><%= supplier.getTelephoneno()%></td>
                        <td><%= supplier.getAddressno() + " " + supplier.getStreet1() + " " + supplier.getStreet2() + " " + supplier.getStreet3()%></td>
                        <td><%= supplier.getEmail()%></td>
                        <td><%= supplier.getUserstatus().getUserStatus()%></td>
                    <input type="hidden" name="supplierid" value="<%= supplier.getIdSupplier()%>">
                    <%

                        if (supplier.getUserstatus().getIdUserStatus() == 2) {
                            Set<pojos.Supplierverificationcode> s = supplier.getSupplierverificationcodes();

                            if (s.size() == 0) {
                    %>
                    <td><input type="submit" value="Send Verification Code" class="btn btn-success"></td>

                    <%
                    } else {
                    %>
                    <td><input disabled type="submit" value="Verification Code Sended" class="btn btn-primary"></td>

                    <%
                        }
                    } else {

                    %>
                    <td><input type="submit" value="Deactivate User" class="btn btn-danger"></td>

                    <%                        }
                    %>
                    </tr>
                </form>
                <%
                        }
                    }

                %>
            </table>
        </div>
    </body>
</html>
