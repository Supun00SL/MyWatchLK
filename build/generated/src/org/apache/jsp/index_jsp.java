package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pojos.Advertisement;
import mvc.CartHasStockModel;
import mvc.SessionCart;
import java.util.ArrayList;
import mvc.LastSeen;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/PageFooter.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/nanobar.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"myjs/ViewProduct.js\"></script>\n");
      out.write("\n");
      out.write("        <title>My Watch.lk</title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            var xhttp;\n");
      out.write("            function CreateRequest() {\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp = new XMLHttpRequest();\n");
      out.write("                } else if (window.ActiveXObject) {\n");
      out.write("                    xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            function SaveClient() {\n");
      out.write("\n");
      out.write("                var fname = document.getElementById(\"fname\").value;\n");
      out.write("                var lname = document.getElementById(\"lname\").value;\n");
      out.write("                var email = document.getElementById(\"email\").value;\n");
      out.write("                var username = document.getElementById(\"username\").value;\n");
      out.write("                var password = document.getElementById(\"password\").value;\n");
      out.write("                var reenterpassword = document.getElementById(\"reenterpassword\").value;\n");
      out.write("                CreateRequest();\n");
      out.write("                var stattop = \"\";\n");
      out.write("                var stattop = document.getElementById(\"stattop\");\n");
      out.write("                var status = document.getElementById(\"status\");\n");
      out.write("                xhttp.onreadystatechange = function() {\n");
      out.write("\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"SimpleRegistrationClient\", true);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send(\"fname=\" + fname + \"&lname=\" + lname + \"&email=\" + email + \"&username=\" + username + \"&password=\" + password + \"&reenterpassword=\" + reenterpassword);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function setModal() {\n");
      out.write("                $('#m1').on('hidden.bs.modal', function() {\n");
      out.write("\n");
      out.write("                    this.modal('show');\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            object.onload = function ba() {\n");
      out.write("\n");
      out.write("                var options = {\n");
      out.write("                    classname: 'bar',\n");
      out.write("                    id: 'bar'\n");
      out.write("                };\n");
      out.write("                var nanobar = new Nanobar(options);\n");
      out.write("                nanobar.go(100);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function AddProductToCart(item) {\n");
      out.write("                var id = item;\n");
      out.write("                var qty = document.getElementById(id + \"_qty\").value;\n");
      out.write("                var available = document.getElementById(id + \"_avqty\").innerHTML;\n");
      out.write("                CreateRequest();\n");
      out.write("                var stattop = document.getElementById(\"stattop\");\n");
      out.write("                xhttp.onreadystatechange = function() {\n");
      out.write("\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("\n");
      out.write("                        if (text === \"1\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("\n");
      out.write("                            if (document.getElementById(\"status1\") == null) {\n");
      out.write("                                var elem = document.createElement(\"div\");\n");
      out.write("                                elem.id = \"status1\";\n");
      out.write("                                elem.className = \"alert alert-success fade in row\";\n");
      out.write("                                elem.innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Successfully Added to The Cart..!';\n");
      out.write("                                stattop.appendChild(elem);\n");
      out.write("\n");
      out.write("                            } else {\n");
      out.write("                                document.getElementById(\"stattop\").innerHTML = \"\";\n");
      out.write("                                var elem = document.createElement(\"div\");\n");
      out.write("                                elem.id = \"status1\";\n");
      out.write("                                elem.className = \"alert alert-success fade in row\";\n");
      out.write("                                elem.innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Successfully Added to The Cart..!';\n");
      out.write("                                stattop.appendChild(elem);\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            document.getElementById(id + \"_avqty\").innerHTML = ((available * 1) - (qty * 1));\n");
      out.write("\n");
      out.write("                        } else if (text === \"0\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("                            if (document.getElementById(\"status1\") == null) {\n");
      out.write("                                var elem = document.createElement(\"div\");\n");
      out.write("                                elem.id = \"status1\";\n");
      out.write("                                elem.className = \"alert alert-danger fade in row\";\n");
      out.write("                                elem.innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Quantity is Not Available..!';\n");
      out.write("                                stattop.appendChild(elem);\n");
      out.write("                            } else {\n");
      out.write("                                document.getElementById(\"stattop\").innerHTML = \"\";\n");
      out.write("                                var elem = document.createElement(\"div\");\n");
      out.write("                                elem.id = \"status1\";\n");
      out.write("                                elem.className = \"alert alert-danger fade in row\";\n");
      out.write("                                elem.innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Quantity is Not Available..!';\n");
      out.write("                                stattop.appendChild(elem);\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"AddToCart\", true);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send(\"id=\" + id + \"&qty=\" + qty);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            Session session2 = new classes.SessionConect().testConnection();
            HttpSession hs = request.getSession();

            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    System.out.println("Name :"+cookie.getName());
                    if (cookie.getName().equals("cus")) {

                        Criteria clientlogin = session2.createCriteria(pojos.Clientlogin.class);
                        clientlogin.add(Restrictions.eq("username", cookie.getValue()));

                        List<pojos.Clientlogin> clientlogins = clientlogin.list();

                        if (!clientlogins.isEmpty()) {
                            pojos.Clientlogin clientlogin1 = clientlogins.get(0);
                            hs.setAttribute("client", clientlogin1.getClient());
                        }
                    }

                }
            }

            if (hs.getAttribute("client") != null) {
                System.out.println("in");
                response.sendRedirect("ClientHome.jsp");
            }

            if (hs.getAttribute("supplier") != null) {
                response.sendRedirect("SupplierHome.jsp");
            }

            int count = 0;
            if (hs.getAttribute("cart") != null) {
                SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                for (int i = 0; i < cartHasStocks.size(); i++) {
                    CartHasStockModel cartHasStock = cartHasStocks.get(i);
                    count += cartHasStock.getQty();
                }
            }


        
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-default navbar-collapse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"><img src=\"img/LOGO.png\" width=\"100\" height=\"30\" alt=\"My Watch.lk\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"SupplierRegistration.jsp\">Sell With Us</a></li>\n");
      out.write("                        <li><a href=\"#\">Help & Contact</a></li> \n");
      out.write("                        <li><a href=\"#\">About My Watch.LK</a></li> \n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"well-sm\">\n");
      out.write("                                <form class=\"form-inline\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"I'm shopping for.....\">\n");
      out.write("                                    <button class=\"btn btn-info glyphicon glyphicon-search form-control\"></button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\" id=\"cb\">");
      out.print( count);
      out.write("</span></span></a></li>\n");
      out.write("                        <!--<li><a  href=\"#m1\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>-->\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Login\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"clientLogin.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Log In</a></li>\n");
      out.write("                                <li><a href=\"#m1\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li> \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            ");
                if (request.getParameter(
                        "stat") != null) {
                    if (request.getParameter("stat").equals("2")) {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-success fade in row\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>\n");
      out.write("                    Please Verify Your Email before Continue !\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("            ");

                    }
                }

            
      out.write("\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"well well-sm\" style=\"background-color: #99ccff;\">\n");
      out.write("                    <ul class=\"list-inline\">\n");
      out.write("                        <li> <h4 style=\"color: #ffffff;\"> Categories</h4></li>\n");
      out.write("                        <li> <a href=\"index.jsp\" style=\"color: #ffffff;\">See All >></a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-group\" id=\"according1\">\n");
      out.write("\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-bottom: 0%\">\n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h6 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-user\"> .</span>\n");
      out.write("                                <a href=\"#cla1\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Gender Type</a>\n");
      out.write("\n");
      out.write("                            </h6>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla1\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");
                                        Criteria gendertypeCriteria = session2.createCriteria(pojos.Gendertype.class);
                                        List<pojos.Gendertype> gendertypes = gendertypeCriteria.list();

                                        if (!gendertypes.isEmpty()) {
                                            for (pojos.Gendertype gendertype : gendertypes) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=gen_");
      out.print( gendertype.getIdGenderType());
      out.write("\"><li class=\"list-group-item\">");
      out.print( gendertype.getGenderType());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                    }
                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-briefcase\"> .</span>\n");
      out.write("                                <a href=\"#cla2\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Brand</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla2\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");
                                        Criteria brandCriteria = session2.createCriteria(pojos.Brand.class);
                                        List<pojos.Brand> brands = brandCriteria.list();

                                        if (!brands.isEmpty()) {
                                            for (pojos.Brand brand : brands) {
                                                if (brand != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=br_");
      out.print( brand.getIdBrand());
      out.write("\"><li class=\"list-group-item\">");
      out.print( brand.getBrand());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-asterisk\"> .</span>\n");
      out.write("                                <a href=\"#cla3\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Colors</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla3\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria maincolorCriteria = session2.createCriteria(pojos.Maincolor.class);
                                        List<pojos.Maincolor> maincolors = maincolorCriteria.list();

                                        if (!maincolors.isEmpty()) {
                                            for (pojos.Maincolor maincolor : maincolors) {
                                                if (maincolor != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=co_");
      out.print( maincolor.getIdMainColor());
      out.write("\"><li class=\"list-group-item\">");
      out.print( maincolor.getColor());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-move\"> .</span>\n");
      out.write("                                <a href=\"#cla4\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Movement</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla4\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria movementCriteria = session2.createCriteria(pojos.Movement.class);
                                        List<pojos.Movement> movements = movementCriteria.list();

                                        if (!movements.isEmpty()) {
                                            for (pojos.Movement movement : movements) {
                                                if (movement != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=mo_");
      out.print( movement.getIdmovement());
      out.write("\"><li class=\"list-group-item\">");
      out.print( movement.getMovement());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-dashboard\"> .</span>\n");
      out.write("                                <a href=\"#cla5\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Watch Shape</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla5\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria WatchshapeCriteria = session2.createCriteria(pojos.Watchshape.class);
                                        List<pojos.Watchshape> watchshapes = WatchshapeCriteria.list();

                                        if (!watchshapes.isEmpty()) {
                                            for (pojos.Watchshape watchshape : watchshapes) {
                                                if (watchshape != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=ws_");
      out.print( watchshape.getIdWatchShape());
      out.write("\"><li class=\"list-group-item\">");
      out.print( watchshape.getWatchShape());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-text-background\"> .</span>\n");
      out.write("                                <a href=\"#cla6\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Grade</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla6\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria gradeCriteria = session2.createCriteria(pojos.Grade.class);
                                        List<pojos.Grade> grades = gradeCriteria.list();

                                        if (!grades.isEmpty()) {
                                            for (pojos.Grade grade : grades) {
                                                if (grade != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=gr_");
      out.print( grade.getIdGrade());
      out.write("\"><li class=\"list-group-item\">");
      out.print( grade.getGrade());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-calendar\"> .</span>\n");
      out.write("                                <a href=\"#cla7\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Age Limit</a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla7\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria agelimitCriteria = session2.createCriteria(pojos.Agelimit.class);
                                        List<pojos.Agelimit> agelimits = agelimitCriteria.list();

                                        if (!agelimits.isEmpty()) {
                                            for (pojos.Agelimit agelimit : agelimits) {
                                                if (agelimit != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=al_");
      out.print( agelimit.getIdAgeLimit());
      out.write("\"><li class=\"list-group-item\">");
      out.print( agelimit.getAgeLimit());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-wrench\"> .</span>\n");
      out.write("                                <a href=\"#cla8\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Water Resistency </a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla8\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria waterresistCriteria = session2.createCriteria(pojos.Waterresistency.class);
                                        List<pojos.Waterresistency> waterresistencys = waterresistCriteria.list();

                                        if (!waterresistencys.isEmpty()) {
                                            for (pojos.Waterresistency waterresistency : waterresistencys) {
                                                if (waterresistency != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=wr_");
      out.print( waterresistency.getIdWaterResistency());
      out.write("\"><li class=\"list-group-item\">");
      out.print( waterresistency.getRate());
      out.write("%</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-time\"> .</span>\n");
      out.write("                                <a href=\"#cla9\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Watch Type </a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla9\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria watchtypeCriteria = session2.createCriteria(pojos.Analogdigital.class);
                                        List<pojos.Analogdigital> analogdigitals = watchtypeCriteria.list();

                                        if (!analogdigitals.isEmpty()) {
                                            for (pojos.Analogdigital analogdigital : analogdigitals) {
                                                if (analogdigital != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=ad_");
      out.print( analogdigital.getIdAnalogDigital());
      out.write("\"><li class=\"list-group-item\">");
      out.print( analogdigital.getAnalogDigital());
      out.write("</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-default\" style=\"border-radius: 0;padding-bottom:  0%;margin-top: 0%\">            \n");
      out.write("                        <div class=\"panel-heading\" style=\"background-color: #ffffff;border-radius: 0;\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-scale\"> .</span>\n");
      out.write("                                <a href=\"#cla10\" data-toggle=\"collapse\" data-parent=\"#according1\" style=\"font-family: monospace;\">Weight </a>\n");
      out.write("                            </h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse panel-collapse\" id=\"cla10\">\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <ul class=\"list-group\">\n");
      out.write("                                    ");

                                        Criteria weightCriteria = session2.createCriteria(pojos.Weight.class);
                                        List<pojos.Weight> weights = weightCriteria.list();

                                        if (!weights.isEmpty()) {
                                            for (pojos.Weight weight : weights) {
                                                if (weight != null) {
                                    
      out.write("\n");
      out.write("                                    <a href=\"index.jsp?p=we_");
      out.print( weight.getIdWeight());
      out.write("\"><li class=\"list-group-item\">");
      out.print( weight.getWeight());
      out.write(" grams</li></a>\n");
      out.write("                                            ");

                                                        }
                                                    }

                                                }
                                            
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-primary\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h5>Last Seen</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        ");

                            if (hs.getAttribute(
                                    "lastseen") != null) {

                                LastSeen lastSeen = (LastSeen) hs.getAttribute("lastseen");
                                ArrayList<String> arrayList = lastSeen.getLastSeen();
                                System.out.println("On Page : " + arrayList);
                                int i = 0;
                                for (String id : arrayList) {
                                    pojos.Stock stock = (pojos.Stock) session2.load(pojos.Stock.class, Integer.parseInt(id));
                                    System.out.println("Product : " + stock.getProduct().getSearchWord());
                                    if (i == 3) {
                                        break;
                                    }
                        
      out.write("\n");
      out.write("                        <div class=\"well well-sm text-center\">\n");
      out.write("\n");
      out.write("                            <label>");
      out.print( stock.getProduct().getSearchWord());
      out.write("</label>\n");
      out.write("                            <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\" alt=\"");
      out.print( stock.getProduct().getSearchWord());
      out.write("\" class=\"img-rounded\" height=\"200\">\n");
      out.write("                            <br><br> <button class=\"btn btn-success col-md-offset-7\" onclick=\"View1(");
      out.print( stock.getIdStock());
      out.write(")\">View Again</button>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                                    i++;
                                }
                            }

                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-9\">\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                    <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                        <!-- Indicators -->\n");
      out.write("                        <ol class=\"carousel-indicators\">\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("                        </ol>\n");
      out.write("\n");
      out.write("                        <!-- Wrapper for slides -->\n");
      out.write("                        <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("                            <div class=\"item active\">\n");
      out.write("                                <img src=\"img/slider_1.jpg\" alt=\"Chania\">\n");
      out.write("                                <div class=\"carousel-caption\">\n");
      out.write("                                    <h2 class=\"animated bounceInRight\">Best Watchers In the World</h2>\n");
      out.write("                                    <p class=\"animated fadeInUp\">TIOSST the best Sellers with Luxury Watchers.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"img/slider_2.jpg\" alt=\"Chania\">\n");
      out.write("                                <div class=\"carousel-caption\">\n");
      out.write("                                    <h2 class=\"animated bounceInLeft\">Best Watchers In the World</h2>\n");
      out.write("                                    <p class=\"animated fadeInUp\">TIOSST the best Sellers with Luxury Watchers.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"img/slider_3.jpg\" alt=\"Flower\">\n");
      out.write("                                <div class=\"carousel-caption\">\n");
      out.write("                                    <h2 class=\"animated bounceInUp\">Best Watchers In the World</h2>\n");
      out.write("                                    <p class=\"animated fadeInUp\">TIOSST the best Sellers with Luxury Watchers.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"img/slider_4.jpg\" alt=\"Flower\">\n");
      out.write("                                <div class=\"carousel-caption\">\n");
      out.write("                                    <h2 class=\"animated bounceInDown\">Best Watchers In the World</h2>\n");
      out.write("                                    <p class=\"animated fadeInUp\">TIOSST the best Sellers with Luxury Watchers.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Left and right controls -->\n");
      out.write("                        <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span class=\"sr-only\">Previous</span>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span class=\"sr-only\">Next</span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 well\">\n");
      out.write("                    <h5 class=\"text-center\" style=\"font:'HolidayPi BT';\">Advertisements <span class=\"label label-danger\">New !!!</span></h5>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    ");
                        Criteria addcriteria = session2.createCriteria(pojos.Advertisement.class);
                        addcriteria.add(Restrictions.eq("state", "active"));
                        List<pojos.Advertisement> advertisements = addcriteria.list();
                        pojos.Advertisement advertisement = null;
                        int addid = 0;
                        if (!advertisements.isEmpty()) {
                            for (int i = 0; i < advertisements.size(); i++) {
                                advertisement = advertisements.get(0);
                                addid = advertisement.getIdAdvertisement();

                            }
                        }

                        if (addid != 0) {

                            pojos.Advertisement advertisement1 = (Advertisement) session2.load(pojos.Advertisement.class, addid);
                    
      out.write("\n");
      out.write("                    <img src=\"");
      out.print(advertisement1.getImage());
      out.write("\" class=\"img-rounded\" width='200' heigh='350'>\n");
      out.write("                    <hr>\n");
      out.write("                    <p class=\"p small text-center\">\n");
      out.write("                        ");
      out.print(advertisement1.getDescription());
      out.write("\n");
      out.write("                    </p>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <img src=\"img/advertse1.jpg\" class=\"img-rounded\" width='200' heigh='350'>\n");
      out.write("                    <hr>\n");
      out.write("                    <p class=\"p small text-center\">\n");
      out.write("                        New Ladies Watch is going to be Introduce on 23rd of Feb in 2016.\n");
      out.write("                    </p>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h3>Featured List</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div>\n");
      out.write("                            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                                <!--                                <div class=\"alert alert-success fade in row\" id=\"status1\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                                                                </div>-->\n");
      out.write("\n");
      out.write("                            </div>  \n");
      out.write("                            ");
                                int FirstResult = 0;
                                int MaxResult = 6;

                                if (request.getParameter(
                                        "fr") != null) {
                                    int x = Integer.parseInt(request.getParameter("fr"));
                                    FirstResult = x * MaxResult;
                                }
                                Session session1 = new classes.SessionConect().testConnection();
                                Criteria productCriteria = session1.createCriteria(pojos.Stock.class);

                                Criteria productCriteria1 = session1.createCriteria(pojos.Product.class);
                                pojos.Product product = null;

                                if (request.getParameter(
                                        "p") != null) {
                                    System.out.print("asd0");

                                    if (request.getParameter("p").split("_")[0].equals("gen")) {
                                        System.out.print("asd1");

                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Gendertype gendertype = (pojos.Gendertype) session1.load(pojos.Gendertype.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("gendertype", gendertype));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("br")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Brand brand = (pojos.Brand) session1.load(pojos.Brand.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("brand", brand));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("co")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Maincolor maincolor = (pojos.Maincolor) session1.load(pojos.Maincolor.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("maincolor", maincolor));

                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("mo")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Movement movement = (pojos.Movement) session1.load(pojos.Movement.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("movement", movement));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("ws")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Watchshape watchshape = (pojos.Watchshape) session1.load(pojos.Watchshape.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("watchshape", watchshape));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("gr")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Grade grade = (pojos.Grade) session1.load(pojos.Grade.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("grade", grade));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("al")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Agelimit agelimit = (pojos.Agelimit) session1.load(pojos.Agelimit.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("agelimit", agelimit));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("wr")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Waterresistency waterresistency = (pojos.Waterresistency) session1.load(pojos.Waterresistency.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("waterresistency", waterresistency));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("ad")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Analogdigital analogdigital = (pojos.Analogdigital) session1.load(pojos.Analogdigital.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("analogdigital", analogdigital));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    } else if (request.getParameter("p").split("_")[0].equals("we")) {
                                        String id = request.getParameter("p").split("_")[1];
                                        System.out.print(id);

                                        pojos.Weight weight = (pojos.Weight) session1.load(pojos.Weight.class, Integer.parseInt(id));
                                        productCriteria1.add(Restrictions.eq("weight", weight));
                                        List<pojos.Product> products = productCriteria1.list();
                                        if (!products.isEmpty()) {
                                            product = products.get(0);
                                            System.out.print("asd");
                                            productCriteria.add(Restrictions.eq("product", product));
                                        }

                                    }
                                }

                                int ResultSize = productCriteria.list().size();

                                productCriteria.setFirstResult(FirstResult);

                                productCriteria.setMaxResults(MaxResult);
                                List<pojos.Stock> stocks = productCriteria.list();

                                if (!stocks.isEmpty()) {
                                    for (pojos.Stock stock : stocks) {
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"panel panel-info\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("\n");
      out.write("                                        <h5 style=\"font-weight: bold;\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel-body text-center\">\n");
      out.write("                                        <img src=\" ");
      out.print( stock.getProduct().getImage());
      out.write("\" height=\"200\" alt=\"1\" class=\"img-rounded\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel-footer\">\n");
      out.write("                                        <h4 class=\"text-danger\" style=\"font-weight: bold;\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(stock.getFinalPrice()));
      out.write("</h4>\n");
      out.write("                                        ");


                                            if (!stock.getFinalPrice().toString().equals(stock.getSellingPrice().toString())) {
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <del class=\"text-danger\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(stock.getSellingPrice()));
      out.write("</del>\n");
      out.write("                                        ");

                                        } else {
                                        
      out.write("\n");
      out.write("                                        <br>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                        <h5 > Available Quantity:<p id=\"");
      out.print( stock.getIdStock());
      out.write("_avqty\"> ");
      out.print( stock.getQty());
      out.write("<p></h5>\n");
      out.write("                                        <div class=\"col-md-12 well\">\n");
      out.write("                                            <h5 class=\"col-md-4\">Qty: </h5>\n");
      out.write("                                            <input type=\"number\" class=\" form-control col-md-6\" id=\"");
      out.print( stock.getIdStock());
      out.write("_qty\" value=\"1\" max=\"");
      out.print( stock.getQty());
      out.write("\" style=\"width: 50%;\"><br>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div>\n");
      out.write("                                            <button class=\"btn btn-info\" onclick=\"AddProductToCart(");
      out.print( stock.getIdStock());
      out.write(")\">Add To Cart</button>\n");
      out.write("                                            <button class=\"btn btn-primary\" onclick=\"View1(");
      out.print( stock.getIdStock());
      out.write(")\">View More</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                                    }

                                }
                            
      out.write("\n");
      out.write("                            <div class=\"panel panel-footer col-md-12 text-center\">\n");
      out.write("                                <ul class=\"pagination\">      \n");
      out.write("                                    ");

                                        int c = ResultSize % MaxResult;
                                        int val = 0;
                                        if (c
                                                == 0) {
                                            val = ResultSize / MaxResult;
                                        } else {
                                            val = ((ResultSize / MaxResult) + 1);
                                        }
                                        for (int i = 0;
                                                i < val;
                                                i++) {
                                            if (request.getParameter("p") != null) {
                                                String para = request.getParameter("p");
                                    
      out.write("\n");
      out.write("                                    <li id=\"");
      out.print(i);
      out.write("_li\">\n");
      out.write("                                        <a href=\"index.jsp?fr=");
      out.print(i);
      out.write("&p=");
      out.print(para);
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    ");

                                    } else {
                                    
      out.write("\n");
      out.write("                                    <li id=\"");
      out.print(i);
      out.write("_li\">\n");
      out.write("                                        <a href=\"index.jsp?fr=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    ");

                                            }

                                        }

                                        session1.close();
                                    
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"m1\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <form method=\"post\" action=\"SimpleRegistrationClient\">\n");
      out.write("                        <div class=\"modal-header text-capitalize\" style=\"font-size: x-large;\"><span class=\"glyphicon glyphicon-user\"></span>  Sign Up</div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                                <div class=\"alert alert-success fade in row\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>First Name :</label> \n");
      out.write("                                <input required type=\"text\"  class=\"form-control\" placeholder=\"First Name\" name=\"fname\" id=\"fname\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Last Name :</label> \n");
      out.write("                                <input type=\"text\" name=\"lname\" id=\"lname\" class=\"form-control\" placeholder=\"Last Name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-12\">\n");
      out.write("                                <label>Email :</label> \n");
      out.write("                                <input required type=\"text\"  name=\"email\" id=\"email\" class=\"form-control\" placeholder=\"Email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-12\">\n");
      out.write("                                <label>User Name :</label>\n");
      out.write("                                <input required type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"User Name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Password :</label> \n");
      out.write("                                <input required type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Re Enter Password :</label> \n");
      out.write("                                <input required type=\"password\" name=\"reenterpassword\" id=\"reenterpassword\" class=\"form-control\" placeholder=\"Re Enter Password\">\n");
      out.write("                            </div>  \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <input type=\"submit\" value=\"Save\" class=\"btn btn-success\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"text-center\">\n");
      out.write("\n");
      out.write("            <div class=\"well well-sm\" style=\"background-color: #333333;\">\n");
      out.write("                <p class=\"small\" style=\"color: #cccccc;\">\n");
      out.write("                    My Watch.LK is Web Site that amazing collection of watchers. While using this site, you agree to have read and accepted our terms of use, cookie and privacy policy. Copyright 2016-2017 by Refsnes Data.\n");
      out.write("                     \n");
      out.write("                </p>\n");
      out.write("                <p class=\"small\" style=\"color: #cccccc;\">\n");
      out.write("                     &#169 All Rights Reserved.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
