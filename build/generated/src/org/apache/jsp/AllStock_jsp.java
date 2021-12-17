package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AllStock_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>All Stock</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("                <h3>All Stock</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"well well-lg col-md-12\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <label class=\"control-label\"><input type=\"radio\" name=\"stype\" id=\"name\" value=\"name\" ><b>Search Name</b></label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <label class=\"control-label\"><input type=\"radio\" name=\"stype\" id=\"bar\" value=\"bar\" ><b>Search Barcode</b></label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-4 form-group\" style=\"padding-top: 1%;\">\n");
      out.write("                    <input type=\"text\" class=\"text-right text-capitalize form-control\" onkeyup=\"filterSearch(this)\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"tabledata\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--            <table class=\"table table-condensed\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Product Image</th>\n");
      out.write("                                <th>Product Name</th>\n");
      out.write("                                <th>Barcode</th>\n");
      out.write("                                <th>Available Quantity</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                                <th>Supplier</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>-->\n");
      out.write("            <!--<img src=\"img/DSCF3798.JPG\" class=\"img-thumbnail\" width=\"200\" height=\"150\">-->\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        //Creating Xhttp Request------------------------------\n");
      out.write("        var xhttp;\n");
      out.write("        function CreateXHTTPRequest() {\n");
      out.write("\n");
      out.write("            if (window.XMLHttpRequest) {\n");
      out.write("                xhttp = new XMLHttpRequest();\n");
      out.write("            } else {\n");
      out.write("                xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        //-----------------------------------------------------\n");
      out.write("        function filterSearch(text) {\n");
      out.write("            var name = document.getElementById(\"name\").checked;\n");
      out.write("            var bar = document.getElementById(\"bar\").checked;\n");
      out.write("            var text = text.value;\n");
      out.write("\n");
      out.write("            var stype = \"\";\n");
      out.write("            if (name) {\n");
      out.write("                stype = \"name\";\n");
      out.write("            } else if (bar) {\n");
      out.write("                stype = \"bar\";\n");
      out.write("            }\n");
      out.write("            CreateXHTTPRequest();\n");
      out.write("            xhttp.onreadystatechange = function() {\n");
      out.write("                if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    document.getElementById(\"tabledata\").innerHTML = xhttp.responseText;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            };\n");
      out.write("            xhttp.open(\"POST\", \"AllStock\", true);\n");
      out.write("            xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhttp.send(\"type=\" + stype + \"&value=\" + text);\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
