package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ClientHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/nanobar.js\"></script>\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"myjs/ViewProduct.js\"></script>-->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        <title>My Watch.lk</title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var xhttp;\n");
      out.write("\n");
      out.write("            function CreateRequest() {\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                } else if (window.ActiveXObject) {\n");
      out.write("                    xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            function AddProductToCart(item) {\n");
      out.write("                var id = item;\n");
      out.write("\n");
      out.write("                var qty = document.getElementById(id + \"_qty\").value;\n");
      out.write("\n");
      out.write("                var available = document.getElementById(id + \"_avqty\");\n");
      out.write("\n");
      out.write("\n");
      out.write("                CreateRequest();\n");
      out.write("                var stattop = document.getElementById(\"stattop1\");\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("                        if (text === \"1\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("                            document.getElementById(\"status1\").className = \"alert alert-success fade in row\";\n");
      out.write("                            document.getElementById(\"status1\").innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Successfully Added to The Cart..!';\n");
      out.write("                            available.innerHTML = (((available.innerHTML) * 1) - qty);\n");
      out.write("                        } else if (text === \"0\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("                            document.getElementById(\"status1\").className = \"alert alert-danger fade in row\";\n");
      out.write("                            document.getElementById(\"status1\").innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Quantity is Not Available..!';\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"AddToCart\", true);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send(\"id=\" + id + \"&qty=\" + qty);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function Watch(item) {\n");
      out.write("                var id = item;\n");
      out.write("                CreateRequest();\n");
      out.write("                var stattop = document.getElementById(\"stattop1\");\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("                        if (text === \"1\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("                            document.getElementById(\"status1\").className = \"alert alert-success fade in row\";\n");
      out.write("                            document.getElementById(\"status1\").innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Successfully Added to Watch List..!';\n");
      out.write("\n");
      out.write("                        } else if (text === \"0\") {\n");
      out.write("                            stattop.className = \"show\";\n");
      out.write("                            document.getElementById(\"status1\").className = \"alert alert-danger fade in row\";\n");
      out.write("                            document.getElementById(\"status1\").innerHTML = '<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>Something Went Wrong..!';\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"AddToWatch\", true);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send(\"id=\" + id);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Session session2 = new classes.SessionConect().testConnection();

        
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-default navbar-collapse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"><img src=\"img/LOGO.png\" width=\"100\" height=\"30\" alt=\"My Watch.lk\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"#\">Home</a></li>\n");
      out.write("                        <li><a href=\"#\">Page 1</a></li>\n");
      out.write("                        <li><a href=\"#\">Page 2</a></li> \n");
      out.write("                        <li><a href=\"#\">Page 3</a></li> \n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                                        HttpSession hs = request.getSession();

                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        
      out.write("\n");
      out.write("                        <li><a  href=\"ClientWatchList.jsp\"><span class=\"glyphicon glyphicon-eye-open\"><span class=\"badge\" id=\"wb\">");
      out.print( new mvc.ClientHome().ReturnWatchListBadgeCount(client));
      out.write("</span></span> </a></li>\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\" id=\"cb\">");
      out.print( new mvc.ClientHome().ReturnCartBadgeCount(client));
      out.write("</span></span></a></li>\n");
      out.write("                        <li><a  href=\"clientRegistration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( clientlogin.getUsername());
      out.write("</a></li>\n");
      out.write("\n");
      out.write("                        ");

                                        break;
                                    }
                                }
                            } else {
                                response.sendRedirect("index.jsp");
                            }

                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            ");
                if (request.getParameter("stat") != null) {
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
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <div class=\"well bg-primary col-md-12\" >\n");
      out.write("                    ");
                        HttpSession hs1 = request.getSession();

                        if (hs1.getAttribute("client") != null) {
                            pojos.Client client1 = (pojos.Client) hs1.getAttribute("client");
                            pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                    
      out.write("\n");
      out.write("                    <div class=\"col-md-5\">\n");
      out.write("                        <img src=\"");
      out.print( client.getImage());
      out.write("\" class=\"img-circle img-thumbnail\" style=\"width: 100px; height: 95px;\">\n");
      out.write("                    </div>\n");
      out.write("                    <h4 class=\"text-capitalize text-left\" style=\"color: black;\">");
      out.print( client.getFname() + " " + client.getLname());
      out.write("</h4>\n");
      out.write("                    <h6 class=\"text-capitalize text-left\" style=\"color: #666666\">(Client)</h6>\n");
      out.write("                    <span><img src=\"icons/822.png\"></span>\n");
      out.write("                    <span class=\"text-capitalize text-left label label-info\">\n");
      out.write("                        ");

                            if (client.getPoints() < 1) {
                        
      out.write("\n");
      out.write("                        ");
      out.print(client.getPoints());
      out.write(" Points !!!\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </span>\n");
      out.write("                    ");
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("               <div class=\"panel-group\" id=\"according1\">                   \n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla1\" data-toggle=\"collapse\" data-parent=\"#according1\">Gender Type</a>\n");
      out.write("                            </h4>\n");
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla2\" data-toggle=\"collapse\" data-parent=\"#according1\">Brand</a>\n");
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla3\" data-toggle=\"collapse\" data-parent=\"#according1\">Colors</a>\n");
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla4\" data-toggle=\"collapse\" data-parent=\"#according1\">Movement</a>\n");
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla5\" data-toggle=\"collapse\" data-parent=\"#according1\">Watch Shape</a>\n");
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla6\" data-toggle=\"collapse\" data-parent=\"#according1\">Grade</a>\n");
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
      out.print( grade.getIdGrade() );
      out.write("\"><li class=\"list-group-item\">");
      out.print( grade.getGrade() );
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla7\" data-toggle=\"collapse\" data-parent=\"#according1\">Age Limit</a>\n");
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
      out.print( agelimit.getIdAgeLimit() );
      out.write("\"><li class=\"list-group-item\">");
      out.print( agelimit.getAgeLimit() );
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla8\" data-toggle=\"collapse\" data-parent=\"#according1\">Water Resistency </a>\n");
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
      out.print( waterresistency.getIdWaterResistency() );
      out.write("\"><li class=\"list-group-item\">");
      out.print( waterresistency.getRate() );
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla9\" data-toggle=\"collapse\" data-parent=\"#according1\">Watch Type </a>\n");
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
      out.print( analogdigital.getIdAnalogDigital() );
      out.write("\"><li class=\"list-group-item\">");
      out.print( analogdigital.getAnalogDigital() );
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
      out.write("                    <div class=\"panel panel-default\">            \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h4 class=\"panel-title\">\n");
      out.write("                                <a href=\"#cla10\" data-toggle=\"collapse\" data-parent=\"#according1\">Weight </a>\n");
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
      out.print( weight.getIdWeight() );
      out.write("\"><li class=\"list-group-item\">");
      out.print( weight.getWeight() );
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
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                    <!-- Indicators -->\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("                        <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("                    </ol>\n");
      out.write("\n");
      out.write("                    <!-- Wrapper for slides -->\n");
      out.write("                    <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("                        <div class=\"item active\">\n");
      out.write("                            <img src=\"img/slider_1.jpg\" alt=\"Chania\">\n");
      out.write("                            <div class=\"carousel-caption\">\n");
      out.write("                                <h2 class=\"animated bounceInRight\">Chania</h2>\n");
      out.write("                                <p class=\"animated fadeInUp\">The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"img/slider_2.jpg\" alt=\"Chania\">\n");
      out.write("                            <div class=\"carousel-caption\">\n");
      out.write("                                <h2 class=\"animated bounceInRight\">Chania</h2>\n");
      out.write("                                <p class=\"animated fadeInUp\">The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"img/slider_3.jpg\" alt=\"Flower\">\n");
      out.write("                            <div class=\"carousel-caption\">\n");
      out.write("                                <h2 class=\"animated bounceInRight\">Chania</h2>\n");
      out.write("                                <p class=\"animated fadeInUp\">The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"img/slider_4.jpg\" alt=\"Flower\">\n");
      out.write("                            <div class=\"carousel-caption\">\n");
      out.write("                                <h2 class=\"animated bounceInRight\">Chania</h2>\n");
      out.write("                                <p class=\"animated fadeInUp\">The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Left and right controls -->\n");
      out.write("                    <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("                        <span class=\"sr-only\">Previous</span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("                        <span class=\"sr-only\">Next</span>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div>\n");
      out.write("                            <div  id=\"stattop1\" class=\"hidden\">\n");
      out.write("                                <div class=\"alert alert-success fade in row\" id=\"status1\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>  \n");
      out.write("                            ");

                                int FirstResult = 0;
                                int MaxResult = 6;

                                if (request.getParameter("fr") != null) {
                                    int x = Integer.parseInt(request.getParameter("fr"));
                                    FirstResult = x * MaxResult;
                                }
                                Session session1 = new classes.SessionConect().testConnection();
                                Criteria productCriteria = session1.createCriteria(pojos.Stock.class);

                                Criteria productCriteria1 = session1.createCriteria(pojos.Product.class);
                                pojos.Product product = null;

                                if (request.getParameter("p") != null) {
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
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <div class=\"panel panel-primary\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("                                        <h3>Item Code :");
      out.print( stock.getBarcode());
      out.write("</h3>\n");
      out.write("                                        <h4>");
      out.print( stock.getProduct().getSearchWord());
      out.write("</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel-body text-center\">\n");
      out.write("                                        <img src=\" ");
      out.print( stock.getProduct().getImage());
      out.write("\" width=\"200\" height=\"150\" alt=\"1\" class=\"img-rounded\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel-footer\">\n");
      out.write("                                        <h4> Product Price:  ");
      out.print( stock.getSellingPrice());
      out.write("LKR</h4>\n");
      out.write("                                        <h4> Available Quantity: <span id=\"");
      out.print( stock.getIdStock());
      out.write("_avqty\">");
      out.print( stock.getQty());
      out.write("</span></h4>\n");
      out.write("                                        <h4> Add to Cart Qty: </h4>\n");
      out.write("                                        <input type=\"number\" class=\" form-control\" id=\"");
      out.print( stock.getIdStock());
      out.write("_qty\" value=\"1\" max=\"");
      out.print( stock.getQty());
      out.write("\"><br>\n");
      out.write("                                        <div class=\"text-right\">\n");
      out.write("                                            <button class=\"btn btn-default\" onclick=\"AddProductToCart(");
      out.print( stock.getIdStock());
      out.write(")\">Add To Cart  <span class=\"glyphicon glyphicon-shopping-cart\"></span> </button>\n");
      out.write("                                            <button class=\"btn btn-default\" onclick=\"View1(");
      out.print( stock.getIdStock());
      out.write(")\">View This Product</button>\n");
      out.write("                                            <button class=\"btn btn-default\" onclick=\"Watch(");
      out.print( stock.getIdStock());
      out.write(")\"><span class=\"glyphicon glyphicon-eye-open\"></span></button>\n");
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
                                        if (c == 0) {
                                            val = ResultSize / MaxResult;
                                        } else {
                                            val = ((ResultSize / MaxResult) + 1);
                                        }
                                        for (int i = 0; i < val; i++) {

                                    
      out.write("\n");
      out.write("                                    <li id=\"");
      out.print(i);
      out.write("_li\">\n");
      out.write("                                        <a href=\"ClientHome.jsp?fr=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    ");

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
