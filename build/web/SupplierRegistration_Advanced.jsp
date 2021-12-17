<%-- 
    Document   : SupplierRegistration
    Created on : Nov 19, 2016, 8:30:10 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <script  type="text/javascript" src="myjs/SupplierRegistration.js"></script>

        <script>
            function logout() {

                var xhttp;

                function CreateRequest() {
                    if (window.XMLHttpRequest) {
                        xhttp = new XMLHttpRequest();

                    } else if (window.ActiveXObject) {
                        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }

                }
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
            function setValues() {
            <%
                HttpSession hs = request.getSession();
                if (hs.getAttribute("status") != null) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) hs.getAttribute("SupplierDetails");
                    String status = hs.getAttribute("status").toString();
            %>

                document.getElementById("comname").value = "<%= hashMap.get("comname")%>";
                document.getElementById("grccode").value = "<%= hashMap.get("grccode")%>";
                document.getElementById("mobilenumber").value = "<%= hashMap.get("mobilenumber")%>";
                document.getElementById("telephonenumber").value = "<%= hashMap.get("telephonenumber")%>";
                document.getElementById("addressno").value = "<%= hashMap.get("addressno")%>";
                document.getElementById("street1").value = "<%= hashMap.get("street1")%>";
                document.getElementById("street2").value = "<%= hashMap.get("street2")%>";
                document.getElementById("street3").value = "<%= hashMap.get("street3")%>";
                document.getElementById("email").value = "<%= hashMap.get("email")%>";
                document.getElementById("username").value = "<%= hashMap.get("username")%>";
                document.getElementById("password").value = "";
                document.getElementById("reenterpassword").value = "";
                var stat = document.getElementById("stat");
                var stattop = document.getElementById("stattop");
                var stata = "<%= status%>";
                if (stata !== "") {
                    stat.innerHTML = stata;
                    stattop.className = "show";
                }
            <%

                }
            %>
            }
        </script>
        <title>Supplier Registration</title>
    </head>
    <body onload="setValues()">

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
                        <li><a href="SupplierProfit.jsp">Supplier Profit</a></li> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            int suppid;
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
            <div  id="stattop" class="hidden">
                <div class="alert alert-danger fade in" id="stat"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  

                </div>
            </div>
            <div class="modal fade" id="m1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header text-capitalize">Upload Your Profile Picture</div>
                        <div class="modal-body text-center">
                            <img src="<%=new classes.Common().SetDefaultImageSupplier(supplier.getSupplierlogo())%>" alt="img" class="img-circle img-thumbnail" id="image1">
                        </div>
                        <div class="modal-footer">
                            <form method="post" enctype="multipart/form-data" action="UploadSupplierImage">
                                <div class="col-md-6">
                                    <input type="hidden" value="n" name="n">
                                    <input required type="file" class="btn btn-success" onchange="getImage(this)" name="img">                                               
                                </div>
                                <div class="col-md-6"><input type="submit" multiple="true" class="btn btn-info" value="Upload"></div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <form method="post" action="SupplierRegistration">
                <div class="panel panel-default">
                    <div class="panel panel-heading">
                        <h3 class="page-header"> Supplier Registration</h3>
                    </div>
                    <div class="panel panel-body">
                        <div class="form-group col-md-12 text-center">
                            <a href="#m1" data-toggle="modal">

                                <img src="icons/add_image.png" alt="img" class="img-rounded img-thumbnail" id="image"  width="300" height="300">
                            </a>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Company Name :</label> 
                            <input required type="text"  class="form-control" placeholder="Company Name" name="comname" id="comname" value="<%= new classes.Common().checkNullablility(supplier.getCompanyName())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Government Registration Code :</label> 
                            <input required type="text"  class="form-control" placeholder="Government Registration Code" name="grccode" id="grccode" value="<%= new classes.Common().checkNullablility(supplier.getGovRegistrationCode())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Mobile Number :</label> 
                            <input required type="text"  class="form-control" placeholder="Mobile Number" name="mobilenumber" id="mobilenumber" value="<%= new classes.Common().checkNullablility(supplier.getMobileno())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Telephone Number :</label> 
                            <input required type="text"  class="form-control" placeholder="Telephone Number" name="telephonenumber" id="telephonenumber" value="<%= new classes.Common().checkNullablility(supplier.getTelephoneno())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address No :</label> 
                            <input required type="text"  class="form-control" placeholder="Address No" name="addressno" id="addressno" value="<%= new classes.Common().checkNullablility(supplier.getAddressno())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street1 :</label> 
                            <input required type="text"  class="form-control" placeholder="Street1" name="street1" id="street1" value="<%= new classes.Common().checkNullablility(supplier.getStreet1())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street2 :</label> 
                            <input type="text"  class="form-control" placeholder="Street2" name="street2" id="street2" value="<%= new classes.Common().checkNullablility(supplier.getStreet2())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Street3 :</label> 
                            <input type="text"  class="form-control" placeholder="Street3" name="street3" id="street3" value="<%= new classes.Common().checkNullablility(supplier.getStreet3())%>">
                        </div>
                        <div class="form-group col-md-12">
                            <label>Postal Type :</label> 
                            <input required type="text"  class="form-control" placeholder="Postal Type" name="postaltype" id="postaltype" value="<%= new classes.Common().checkNullablility(supplier.getPosttype().getPostType())%>">
                        </div>
                        <div class="form-group col-md-12">
                            <label>Postal Type Description :</label> 
                            <textarea class="form-control" placeholder="Postal Description" name="postaldesc" id="postaldesc"><%= new classes.Common().checkNullablility(supplier.getPosttype().getDescription())%></textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Email :</label> 
                            <input required type="text"  class="form-control" placeholder="Email" name="email" id="email" value="<%= new classes.Common().checkNullablility(supplier.getEmail())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>User Name :</label>
                            <input required type="text" name="username" id="username" class="form-control" placeholder="User Name" value="<%= new classes.Common().Set_UsernameSupplier(supplier.getSupplierlogins())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Password :</label> 
                            <input required type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Re Enter Password :</label> 
                            <input required type="password" name="reenterpassword" id="reenterpassword" class="form-control" placeholder="Re Enter Password">
                        </div>

                    </div>
                    <div class="panel-footer">
                        <div class="form-inline col-md-offset-10">
                            <input type="submit" name="submited" class="btn btn-primary" id="save" value="Update Details">
                        </div>

                    </div>

                </div>

            </form>
        </div>

    </body>
</html>
