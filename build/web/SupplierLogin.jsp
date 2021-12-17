<%-- 
    Document   : SupplierLogin
    Created on : Nov 24, 2016, 7:22:06 PM
    Author     : Supun Madushanka
--%>

<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head onload="noBack()">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Login</title>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        
        <script>
//            window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </script>
    </head>
    <body> 
         <%
          
             HttpSession hs = request.getSession();
             
             if(hs.getAttribute("client")!=null){
                response.sendRedirect("index.jsp");            
             }
             
             if(hs.getAttribute("admin")!=null){
                response.sendRedirect("AdminHome.jsp");
             }
             
             if(hs.getAttribute("supplier")!=null){
                response.sendRedirect("SupplierHome.jsp");
             }
            
        %>
        <div class="container-fluid">
            <div style="margin-left: 30%; margin-top: 12%;">
                <div class="panel panel-default" style="width: 50%;">
                    <div class="panel-heading text-center">
                        <h3 class="page-header"> Supplier Login</h3>
                    </div>
                    <form action="SupplierLogin" method="post">
                        <div class="panel-body">
                            <%
                                if(request.getParameter("id")!=null){
                                if (request.getParameter("id").equals("1")) {

                            %>
                            <div>
                                <div class="alert alert-danger fade in" id="status1"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                                    Your User Name or Password is Incorrect
                                </div>

                            </div>
                            <%                            } else if (request.getParameter("id").equals("2")) {
                            %>
                            <div>
                                <div class="alert alert-danger fade in" id="status2"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="b">&times;</a>  
                                    Your account is not Activated..!
                                </div>

                            </div>
                            <%
                                }
                                }
                            %>
                            <div class="form-group col-md-12">
                                <label>User Name :</label> 
                                <input required type="text"  class="form-control" placeholder="User Name" name="username" id="username">
                            </div>
                            <div class="form-group col-md-12">
                                <label>Password :</label> 
                                <input required type="password"  class="form-control" placeholder="Password" name="password" id="password">
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="form-inline col-md-offset-10">
                                <input type="submit" value="Login" class="btn btn-info" >   
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
