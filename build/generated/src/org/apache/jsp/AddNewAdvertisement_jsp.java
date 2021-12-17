package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class AddNewAdvertisement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>Advertisement</title>\n");
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
      out.write("            function logout1() {\n");
      out.write("                CreateRequest();\n");
      out.write("                xhttp.onreadystatechange = function() {\n");
      out.write("\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("                        window.location = \"index.jsp\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"Logout\", true);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getImage(input) {\n");
      out.write("                var c = 0;\n");
      out.write("                for (var i = 0; i < input.files.length; i++) {\n");
      out.write("\n");
      out.write("                    if (input.files[i] !== null) {\n");
      out.write("\n");
      out.write("                        var reader = new FileReader();\n");
      out.write("\n");
      out.write("                        reader.onload = function(e) {\n");
      out.write("\n");
      out.write("                            var elem = document.getElementById(\"image\");\n");
      out.write("                            elem.src = e.target.result;\n");
      out.write("                            elem.width = \"300\";\n");
      out.write("                            elem.height = \"200\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                            c++;\n");
      out.write("\n");
      out.write("                        };\n");
      out.write("                        reader.readAsDataURL(input.files[i]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-default navbar-collapse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"><img src=\"img/LOGO.png\" width=\"100\" height=\"30\" alt=\"My Watch.lk\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                            HttpSession hs = request.getSession();

                            if (hs.getAttribute("admin") != null) {

                        
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> My Account\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( hs.getAttribute("admin"));
      out.write("</li>\n");
      out.write("                                <li onclick=\"logout1()\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        ");


                            } else {
                                response.sendRedirect("adminLogin.jsp");
                            }

                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Add New Advertisements</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
                if (request.getParameter("stat") != null) {
                    if (request.getParameter("stat").equals("1")) {
            
      out.write("\n");
      out.write("            <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                Successfully Saved...!\n");
      out.write("            </div>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <div class=\"alert alert-danger fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                Something Went Wrong...!\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("            <form method=\"post\" enctype=\"multipart/form-data\" action=\"AddNewAdd\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel panel-heading\">\n");
      out.write("                        <h4>Create New Advertisement</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-body\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <label>Image</label>\n");
      out.write("                            <div class=\"col-md-12 text-center\" id=\"images\">\n");
      out.write("                                <img src=\"icons/add_image.png\" alt=\"img\" class=\"img-thumbnail\" id=\"image\">\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <input required type=\"file\" name=\"addimg\" class=\"btn btn-success\" onchange=\"getImage(this)\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <label>Description</label>\n");
      out.write("                            <textarea required class=\"form-control\" name=\"desc\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-footer\">\n");
      out.write("                        <input type=\"submit\" value=\"Save\" class=\"btn btn-info\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <table class=\"table table-condensed\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>State</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    Session session1 = new classes.SessionConect().testConnection();

                    Criteria criteria = session1.createCriteria(pojos.Advertisement.class);

                    List<pojos.Advertisement> advertisements = criteria.list();

                    if (!advertisements.isEmpty()) {
                        for (pojos.Advertisement advertisement : advertisements) {
                            if (advertisement.getState().equals("inactive")) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <img src=\"");
      out.print(advertisement.getImage());
      out.write("\" alt=\"add\" class=\"img-thumbnail\" width=\"200\" height=\"200\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>");
      out.print(advertisement.getDescription());
      out.write("</td>\n");
      out.write("                    <td><input type=\"submit\" value=\"inactive\" class=\"btn btn-danger\"></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                } else if (advertisement.getState().equals("active")) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <img src=\"");
      out.print(advertisement.getImage());
      out.write("\" alt=\"add\" class=\"img-thumbnail\" width=\"200\" height=\"200\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>");
      out.print(advertisement.getDescription());
      out.write("</td>\n");
      out.write("                    <td><input type=\"submit\" value=\"active\" class=\"btn btn-primary\"></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                            }
                        }
                    }
                
      out.write("\n");
      out.write("            </table>\n");
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
