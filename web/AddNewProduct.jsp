<%-- 
    Document   : AddNewProduct
    Created on : Nov 21, 2016, 12:27:27 PM
    Author     : Supun Madushanka
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Set"%>
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
        <script type="text/javascript" src="myjs/AddNewproduct.js"></script>

        <%
            Session session1 = new classes.SessionConect().testConnection();
        %>
        <title>Add New Product</title>
    </head>
    <body>

        <div class="container-fluid">
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
                            <li class="active"><a href="AddNewProduct.jsp">Add New Product</a></li>
                            <li><a href="AddToStock.jsp">Add To Stock</a></li>
                             <li><a href="AllStock_Sup.jsp">Stock</a></li>
                             <li><a href="SupplierProfit.jsp">Supplier Profit</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <%                            HttpSession hs = request.getSession();

                                if (hs.getAttribute("supplier") != null) {
                                    pojos.Supplier supplier1 = (pojos.Supplier) hs.getAttribute("supplier");
                                    pojos.Supplier supplier = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier1.getIdSupplier());

                                    Set<pojos.Supplierlogin> supplierlogins = supplier.getSupplierlogins();
                                    if (!supplierlogins.isEmpty()) {
                                        for (pojos.Supplierlogin supplierlogin : supplierlogins) {
                            %>
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
            <%                if (request.getParameter("statid") != null) {
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
                <form method="post" enctype="multipart/form-data" action="SaveUpdateProductDetails">
                    <div class="panel panel-default">
                        <div class="panel panel-heading">
                            <h3 class="page-header"> Product Registration</h3>
                        </div>

                        <div class="panel panel-body">
                            <div class="col-md-12 text-center" id="images">

                            </div><br>
                            <div class="form-group col-md-6">
                                <label>Image :</label> 
                                <input required type="file"  class="form-control" name="img" id="img" onchange="getImage(this)" multiple>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Item Code :</label> 
                                <input readonly type="text"  class="form-control" name="itemcode" id="itemcode" value="<%= new mvc.AddNewProduct().ItemCode()%>">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Product Name :</label> 
                                <input required type="text"  class="form-control" placeholder="Product Name" name="proname" id="proname">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Brand Name :</label> 
                                <!--<input required type="text"  class="form-control" placeholder="Brand Name" name="brandname" id="brandname">-->
                                <%
                                    Criteria brandCriteria = session1.createCriteria(pojos.Brand.class);
                                    List<pojos.Brand> brands = brandCriteria.list();
                                    pojos.Brand brand = null;
                                %>
                                <input list="brands" name="brand" class="form-control" id="brand">
                                <datalist id="brands">
                                    <%
                                        if (!brands.isEmpty()) {
                                            for (int i = 0; i < brands.size(); i++) {
                                                brand = brands.get(i);
                                    %>
                                    <option value="<%= brand.getBrand()%>" id="<%= brand.getIdBrand()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div>                       
                            <div class="form-group col-md-6">
                                <label>Target Gender :</label> 
                                <select class="form-control" name="targetgen" id="targetgen">
                                    <%
                                        Criteria genderCriteria = session1.createCriteria(pojos.Gendertype.class);
                                        List<pojos.Gendertype> genders = genderCriteria.list();

                                        if (!genders.isEmpty()) {
                                            for (pojos.Gendertype gender : genders) {
                                    %>
                                    <option><%= gender.getGenderType()%></option>
                                    <%
                                            }

                                        }


                                    %>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Min QTY :</label> 
                                <input required type="number" min="0" value="1"  class="form-control" placeholder="Min QTY" name="minqty" id="minqty">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Product Status :</label> 
                                <select class="form-control" name="productstatus" id="productstatus">
                                    <%                                        Criteria productstatusCriteria = session1.createCriteria(pojos.Productstatus.class);
                                        List<pojos.Productstatus> productstatuses = productstatusCriteria.list();

                                        if (!productstatuses.isEmpty()) {
                                            for (pojos.Productstatus productstatus : productstatuses) {
                                    %>
                                    <option><%= productstatus.getProductStatus()%></option>
                                    <%
                                            }

                                        }


                                    %>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Strap Type :</label> 
                                <%                                    Criteria straptypeCriteria = session1.createCriteria(pojos.Straptype.class);
                                    List<pojos.Straptype> straptypes = straptypeCriteria.list();
                                    pojos.Straptype straptype = null;
                                %>
                                <input list="straptypes" name="straptype" class="form-control" id="straptype">
                                <datalist id="straptypes">
                                    <%
                                        if (!straptypes.isEmpty()) {
                                            for (int i = 0; i < straptypes.size(); i++) {
                                                straptype = straptypes.get(i);
                                    %>
                                    <option value="<%= straptype.getStrapType()%>" id="<%= straptype.getIdStrapType()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div>

                            <div class=" col-md-6">
                                <div class="panel panel-default">
                                    <div class="panel panel-heading" >
                                        Case Details
                                    </div>
                                    <div class="panel panel-body" >
                                        <div class="form-group col-md-6">
                                            <label>Case Type :</label>
                                            <%
                                                Criteria CaseTypeCriteria = session1.createCriteria(pojos.Casetype.class);
                                                List<pojos.Casetype> casetypes = CaseTypeCriteria.list();
                                                pojos.Casetype casetype = null;
                                            %>
                                            <input list="casetypes" name="casetype" class="form-control" id="casetype">
                                            <datalist id="casetypes">
                                                <%
                                                    if (!casetypes.isEmpty()) {
                                                        for (int i = 0; i < casetypes.size(); i++) {
                                                            casetype = casetypes.get(i);
                                                %>
                                                <option value="<%= casetype.getCaseType()%>" id="<%= casetype.getIdCaseType()%>">
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Case Weight :</label> 
                                            <input required type="text"  class="form-control" placeholder="Case Weight" name="caseweight" id="caseweight">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Case Width :</label> 
                                            <input required type="text"  class="form-control" placeholder="Case Width" name="casewidth" id="casewidth">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Case Height :</label> 
                                            <input required type="text"  class="form-control" placeholder="Case Height" name="caseheight" id="caseheight">
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class=" col-md-6">
                                <div class="panel panel-default">
                                    <div class="panel panel-heading" >
                                        Watch Color Details
                                    </div>
                                    <div class="panel panel-body" >
                                        <div class="form-group col-md-6">
                                            <label>Main Color :</label> 
                                            <%                                    Criteria MainColorCriteria = session1.createCriteria(pojos.Maincolor.class);
                                                List<pojos.Maincolor> maincolors = MainColorCriteria.list();
                                                pojos.Maincolor maincolor = null;
                                            %>
                                            <input list="mcolors" name="mcolor" class="form-control" id="mcolor">
                                            <datalist id="mcolors">
                                                <%
                                                    if (!maincolors.isEmpty()) {
                                                        for (int i = 0; i < maincolors.size(); i++) {
                                                            maincolor = maincolors.get(i);
                                                %>
                                                <option value="<%= maincolor.getColor()%>" id="<%= maincolor.getIdMainColor()%>">
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div> 
                                        <div class="form-group col-md-6">
                                            <label>Strap Color :</label> 
                                            <%
                                                Criteria strapcolorCriteria = session1.createCriteria(pojos.Strapcolor.class);
                                                List<pojos.Strapcolor> strapcolors = strapcolorCriteria.list();
                                                pojos.Strapcolor strapcolor = null;
                                            %>
                                            <input list="strapcolors" name="strapcolor" class="form-control" id="strapcolor">
                                            <datalist id="strapcolors">
                                                <%
                                                    if (!strapcolors.isEmpty()) {
                                                        for (int i = 0; i < strapcolors.size(); i++) {
                                                            strapcolor = strapcolors.get(i);
                                                %>
                                                <option value="<%= strapcolor.getStrapColor()%>" id="<%= strapcolor.getIdStrapColor()%>">
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div> 
                                        <div class="form-group col-md-6">
                                            <label>Dial Color :</label> 
                                            <%
                                                Criteria dialcolorCriteria = session1.createCriteria(pojos.Dialcolor.class);
                                                List<pojos.Dialcolor> dialcolors = dialcolorCriteria.list();
                                                pojos.Dialcolor dialcolor = null;
                                            %>
                                            <input list="dialcolors" name="dialcolor" class="form-control" id="dialcolor">
                                            <datalist id="dialcolors">
                                                <%
                                                    if (!dialcolors.isEmpty()) {
                                                        for (int i = 0; i < dialcolors.size(); i++) {
                                                            dialcolor = dialcolors.get(i);
                                                %>
                                                <option value="<%= dialcolor.getDialColor()%>" id="<%= dialcolor.getIdDialColor()%>">
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Movement :</label> 
                                <%
                                    Criteria MovementCriteria = session1.createCriteria(pojos.Movement.class);
                                    List<pojos.Movement> movements = MovementCriteria.list();
                                    pojos.Movement movement = null;
                                %>
                                <input list="movements" name="movement" class="form-control" id="movement">
                                <datalist id="movements">
                                    <%
                                        if (!movements.isEmpty()) {
                                            for (int i = 0; i < movements.size(); i++) {
                                                movement = movements.get(i);
                                    %>
                                    <option value="<%= movement.getMovement()%>" id="<%= movement.getIdmovement()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Grade :</label> 
                                <%
                                    Criteria gradeCriteria = session1.createCriteria(pojos.Grade.class);
                                    List<pojos.Grade> grades = gradeCriteria.list();
                                    pojos.Grade grade = null;
                                %>
                                <input list="grades" name="grade" class="form-control" id="grade">
                                <datalist id="grades">
                                    <%
                                        if (!grades.isEmpty()) {
                                            for (int i = 0; i < grades.size(); i++) {
                                                grade = grades.get(i);
                                    %>
                                    <option value="<%= grade.getGrade()%>" id="<%= grade.getIdGrade()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Age Limit :</label> 
                                <%
                                    Criteria agelimitCriteria = session1.createCriteria(pojos.Agelimit.class);
                                    List<pojos.Agelimit> agelimits = agelimitCriteria.list();
                                    pojos.Agelimit agelimit = null;
                                %>
                                <input list="agelimits" name="agelimit" class="form-control" id="agelimit">
                                <datalist id="agelimits">
                                    <%
                                        if (!agelimits.isEmpty()) {
                                            for (int i = 0; i < agelimits.size(); i++) {
                                                agelimit = agelimits.get(i);
                                    %>
                                    <option value="<%= agelimit.getAgeLimit()%>" id="<%= agelimit.getIdAgeLimit()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Water Resist :</label> 
                                <%
                                    Criteria WaterResistCriteria = session1.createCriteria(pojos.Waterresistency.class);
                                    List<pojos.Waterresistency> waterresistencys = WaterResistCriteria.list();
                                    pojos.Waterresistency waterresistency = null;
                                %>
                                <input list="waterresistencys" name="waterresistency" class="form-control" id="waterresistency">
                                <datalist id="waterresistencys">
                                    <%
                                        if (!waterresistencys.isEmpty()) {
                                            for (int i = 0; i < waterresistencys.size(); i++) {
                                                waterresistency = waterresistencys.get(i);
                                    %>
                                    <option value="<%= waterresistency.getRate()%>" id="<%= waterresistency.getIdWaterResistency()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Weight  :</label> 
                                <%
                                    Criteria WeightCriteria = session1.createCriteria(pojos.Weight.class);
                                    List<pojos.Weight> weights = WeightCriteria.list();
                                    pojos.Weight weight = null;
                                %>
                                <input list="weights" name="weight" class="form-control" id="weight">
                                <datalist id="weights">
                                    <%
                                        if (!weights.isEmpty()) {
                                            for (int i = 0; i < weights.size(); i++) {
                                                weight = weights.get(i);
                                    %>
                                    <option value="<%= weight.getWeight()%>" id="<%= weight.getIdWeight()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Watch Shape  :</label> 
                                <%
                                    Criteria WatchshapeCriteria = session1.createCriteria(pojos.Watchshape.class);
                                    List<pojos.Watchshape> watchshapes = WatchshapeCriteria.list();
                                    pojos.Watchshape watchshape = null;
                                %>
                                <input list="watchshapes" name="watchshape" class="form-control" id="watchshape">
                                <datalist id="watchshapes">
                                    <%
                                        if (!watchshapes.isEmpty()) {
                                            for (int i = 0; i < watchshapes.size(); i++) {
                                                watchshape = watchshapes.get(i);
                                    %>
                                    <option value="<%= watchshape.getWatchShape()%>" id="<%= watchshape.getIdWatchShape()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Packaging  :</label> 
                                <%
                                    Criteria PackagingCriteria = session1.createCriteria(pojos.Packaging.class);
                                    List<pojos.Packaging> packagings = PackagingCriteria.list();
                                    pojos.Packaging packaging = null;
                                %>
                                <input list="packagings" name="packaging" class="form-control" id="packaging">
                                <datalist id="packagings">
                                    <%
                                        if (!packagings.isEmpty()) {
                                            for (int i = 0; i < packagings.size(); i++) {
                                                packaging = packagings.get(i);
                                    %>
                                    <option value="<%= packaging.getPackagingType()%>" id="<%= packaging.getIdPackaging()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 
                            <div class="form-group col-md-6">
                                <label>Watch Type :</label> 
                                <%
                                    Criteria analogdigitalCriteria = session1.createCriteria(pojos.Analogdigital.class);
                                    List<pojos.Analogdigital> analogdigitals = analogdigitalCriteria.list();
                                    pojos.Analogdigital analogdigital = null;
                                %>
                                <input list="analogdigitals" name="analogdigital" class="form-control" id="analogdigital">
                                <datalist id="analogdigitals">
                                    <%
                                        if (!analogdigitals.isEmpty()) {
                                            for (int i = 0; i < analogdigitals.size(); i++) {
                                                analogdigital = analogdigitals.get(i);
                                    %>
                                    <option value="<%= analogdigital.getAnalogDigital()%>" id="<%= analogdigital.getIdAnalogDigital()%>">
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div> 




                        </div>
                        <div class="panel-footer">
                            <div class="form-inline col-md-offset-10">
                                <input type="submit" name="submited" multiple="true" class="btn btn-primary" id="save" value="Save">
                            </div>

                        </div>
                    </div>

                </form>
            </div>
        </div>
        <%
            session1.close();
        %>
    </body>
    <script>
            var xhttp;

            function CreateRequest() {
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();

                } else if (window.ActiveXObject) {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

            }
            function logout() {
                CreateRequest();
                xhttp.onreadystatechange = function () {

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
</html>
