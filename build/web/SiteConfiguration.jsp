<%-- 
    Document   : SiteConfiguration
    Created on : Dec 4, 2016, 8:21:17 AM
    Author     : Supun Madushanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <script  type="text/javascript" src="myjs/SiteConfiguration.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-collapse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img src="img/LOGO.png" width="100" height="30" alt="My Watch.lk"></a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Page 1</a></li>
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
        <%
            if (request.getParameter("statid") != null) {
                if (request.getParameter("statid").equals("1")) {
        %>
        <div  id="stattop">
            <div class="alert alert-success fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                Successfully Saved...!
            </div>
        </div>
        <%
        } else {
        %>
        <div  id="stattop">
            <div class="alert alert-danger fade in" id="status"><a href="#" class="close" data-dismiss="alert" aria-label="close" id="a">&times;</a>  
                Something Went Wrong...!
            </div>
        </div>
        <%
                }

            }


        %>
        <div class="container">
            <form method="post" enctype="multipart/form-data" action="SiteConfiguration">
                <div class=" panel panel-default">
                    <div class="panel panel-heading">
                        <h3 class="page-header"> Site Configuration</h3>
                    </div>
                    <div class="panel panel-body">
                        <div class="col-md-12 text-center" id="images">
                            <img src="icons/add_image.png" alt="img" class="img-thumbnail" id="image">
                        </div><br>
                        <div class="form-group col-md-6">
                            <label>Site Logo :</label> 
                            <input required type="file"  class="form-control" name="img" id="img" onchange="getImage(this)">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Site Name :</label> 
                            <input required type="text"  class="form-control" placeholder="Site Name" name="sitname" id="sitname">
                        </div>
                        <div class="form-group col-md-12">
                            <label>Email :</label> 
                            <input required type="text"  class="form-control" placeholder="Email" name="email" id="email">
                        </div>
                        <div class="form-group col-md-4">
                            <label>No :</label> 
                            <input required type="text"  class="form-control" placeholder="No" name="no" id="no">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Street :</label> 
                            <input required type="text"  class="form-control" placeholder="Street" name="street" id="street">
                        </div>
                        <div class="form-group col-md-4">
                            <label>City :</label> 
                            <input required type="text"  class="form-control" placeholder="City" name="city" id="city">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Postal Code :</label> 
                            <input required type="text"  class="form-control" placeholder="Postal Code" name="pcode" id="pcode">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Country :</label> 
                            <input required type="text"  class="form-control" placeholder="Country" name="country" id="country">
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="form-inline col-md-offset-11">
                            <input type="submit" name="submited" class="btn btn-primary" id="save" value="Save">
                        </div>

                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
