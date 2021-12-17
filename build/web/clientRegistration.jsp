<%-- 
    Document   : clientRegistration
    Created on : Oct 13, 2016, 7:21:17 AM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <script  type="text/javascript" src="myjs/ClientRegistration.js"></script>

        <title>Client Registration Form</title>
        <script>
            function setValues() {
            <%
                HttpSession hs = request.getSession();
                if (hs.getAttribute("status") != null) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) hs.getAttribute("ClientDetails");
                    String status = hs.getAttribute("status").toString();
            %>

                document.getElementById("fname").value = "<%= hashMap.get("fname")%>";
                document.getElementById("lname").value = "<%= hashMap.get("lname")%>";
                document.getElementById("email").value = "<%= hashMap.get("email")%>";
                document.getElementById("gender").value = "<%= hashMap.get("gender")%>";
                document.getElementById("mobileno").value = "<%= hashMap.get("mobileno")%>";
                document.getElementById("telephone").value = "<%= hashMap.get("telephoneno")%>";
                document.getElementById("addressno").value = "<%= hashMap.get("addressno")%>";
                document.getElementById("addressstreet1").value = "<%= hashMap.get("street1")%>";
                document.getElementById("addressstreet2").value = "<%= hashMap.get("street2")%>";
                document.getElementById("addressstreet3").value = "<%= hashMap.get("street3")%>";
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

    </head>
    <body onload="setValues()">
        <%
            Session session2 = new classes.SessionConect().testConnection();
            pojos.Client client = null;

        %>

        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="ClientHome.jsp">Client Home</a></li>
                        <li  class="active"><a href="ClientInvoiceHistory.jsp">Client Invoice History</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        %>
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

            <div  id="stattop" class="hidden">
                <div class="alert alert-danger fade in" id="stat"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  

                </div>
            </div>
            <div class="modal fade" id="m1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header text-capitalize">Upload Your Profile Picture</div>
                        <div class="modal-body text-center">
                            <img src="icons/business_user.png" alt="img" class="img-circle img-thumbnail" id="image1">
                        </div>
                        <div class="modal-footer">
                            <form method="post" enctype="multipart/form-data" action="UploadClientImage">
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

            <form action="ClientSaveUpdate" method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="page-header"> Client Registration Form</h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-group col-md-12 text-center">
                            <a href="#m1" data-toggle="modal">
                                <img src="<%= new classes.Common().SetDefaultImageSupplier(client.getImage())%>" alt="img" class="img-circle img-thumbnail" id="image" width="200" height="150">
                            </a>
                        </div>




                        <div class="form-group col-md-6">
                            <label>First Name :</label> 
                            <input type="text"  class="form-control" placeholder="First Name" name="fname" id="fname" value="<%= new classes.Common().checkNullablility(client.getFname())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Last Name :</label> 
                            <input type="text" name="lname" id="lname" class="form-control" placeholder="Last Name" value="<%= new classes.Common().checkNullablility(client.getLname())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Email :</label> 
                            <input type="text"  name="email" id="email" class="form-control" placeholder="Email" value="<%= new classes.Common().checkNullablility(client.getEmail())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Gender :</label> 
                            <select class="form-control" name="gender" id="gender">
                                <%
                                    Criteria genderCriteria = session2.createCriteria(pojos.Gender.class);

                                    List<pojos.Gender> genders = genderCriteria.list();

                                    if (!genders.isEmpty()) {
                                        for (pojos.Gender gender : genders) {
                                %>
                                <option><%= gender.getGender()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Mobile Number :</label> 
                            <input type="text"  name="mobileno" id="mobileno" class="form-control" placeholder="Mobile Number" value="<%= new classes.Common().checkNullablility(client.getMobileno())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Telephone :</label> 
                            <input type="text" name="telephone" id="telephone" class="form-control" placeholder="Telephone" value="<%= new classes.Common().checkNullablility(client.getTelephoneno())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address No :</label> 
                            <input type="text"  name="addressno" id="addressno" class="form-control" placeholder="Address Number" value="<%= new classes.Common().checkNullablility(client.getAddressno())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address Street1 :</label> 
                            <input type="text"  name="addressstreet1" id="addressstreet1" class="form-control" placeholder="Address Street1" value="<%= new classes.Common().checkNullablility(client.getStreet1())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address Street2 :</label> 
                            <input type="text" name="addressstreet2" id="addressstreet2" class="form-control" placeholder="Address Street2" value="<%= new classes.Common().checkNullablility(client.getStreet2())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Address Street3 :</label> 
                            <input type="text" name="addressstreet3" id="addressstreet3" class="form-control" placeholder="Address Street3" value="<%= new classes.Common().checkNullablility(client.getStreet3())%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label>User Name :</label>
                            <input type="text" name="username" id="username" class="form-control" placeholder="User Name" value="<%= new classes.Common().Set_UsernameClient(client.getClientlogins())%>">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Password :</label> 
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Re Enter Password :</label> 
                            <input type="password" name="reenterpassword" id="reenterpassword" class="form-control" placeholder="Re Enter Password">
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="form-inline col-md-offset-10">
                            <input type="submit" name="submited" class="btn btn-primary" id="save" value="Save">
                            <input type="submit" name="submited" class="btn btn-primary" id="update" value="Update">
                        </div>

                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
