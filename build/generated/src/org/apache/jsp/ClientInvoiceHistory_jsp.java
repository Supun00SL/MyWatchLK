package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import java.util.Set;

public final class ClientInvoiceHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Client Invoice History</title>\n");
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
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> My Account\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a  href=\"clientRegistration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( clientlogin.getUsername());
      out.write("</a></li>\n");
      out.write("                                <li onclick=\"logout()\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
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
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Client Invoice History</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"well well-lg col-md-12\">\n");
      out.write("                <div class=\" col-md-4\">\n");
      out.write("                    <label>Start Date</label>\n");
      out.write("                    <input type=\"date\" id=\"startdate\" name=\"startdate\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\" col-md-4\">\n");
      out.write("                    <label>End Date</label>\n");
      out.write("                    <input type=\"date\" id=\"enddate\" name=\"enddate\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"col-lg-offset-6\">                    \n");
      out.write("                    <input type=\"button\" value=\"Search\" class=\"btn btn-primary\" onclick=\"filterSearch(this)\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"tabledata\">\n");
      out.write("\n");
      out.write("            </div>\n");
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
      out.write("        function filterSearch() {\n");
      out.write("            var startdate = document.getElementById(\"startdate\").value;\n");
      out.write("            var enddate = document.getElementById(\"enddate\").value;\n");
      out.write("\n");
      out.write("            CreateXHTTPRequest();\n");
      out.write("            xhttp.onreadystatechange = function() {\n");
      out.write("                if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                    document.getElementById(\"tabledata\").innerHTML = xhttp.responseText;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            };\n");
      out.write("            xhttp.open(\"POST\", \"ClientInvoiceHistory\", true);\n");
      out.write("            xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhttp.send(\"startdate=\" + startdate + \"&enddate=\" + enddate);\n");
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
