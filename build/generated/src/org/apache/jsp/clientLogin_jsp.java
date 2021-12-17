package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import java.util.Set;

public final class clientLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head  onload=\"noBack()\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>Log In</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .positionimg{\n");
      out.write("                float: left;\n");
      out.write("                position: relative;\n");
      out.write("                margin-top: 3%;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .warinintxt{\n");
      out.write("                color: #ff3333;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("        function getData() {\n");
      out.write("            var xhttp;\n");
      out.write("\n");
      out.write("            var rem = \"\";\n");
      out.write("            var remcomp = document.getElementById(\"rem\");\n");
      out.write("            if (remcomp.checked) {\n");
      out.write("                rem = \"rem\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (window.XMLHttpRequest) {\n");
      out.write("                xhttp = new XMLHttpRequest();\n");
      out.write("            } else {\n");
      out.write("                xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("            var stat = document.getElementById(\"status\");\n");
      out.write("\n");
      out.write("            xhttp.onreadystatechange = function() {\n");
      out.write("                if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("                    var text = xhttp.responseText;\n");
      out.write("                    if (text.length > 1) {\n");
      out.write("                        stat.innerHTML = xhttp.responseText;\n");
      out.write("                        document.getElementById(\"uname\").value = '';\n");
      out.write("                        document.getElementById(\"pword\").value = '';\n");
      out.write("                    } else {\n");
      out.write("                        //alert(xhttp.responseText);\n");
      out.write("                        if (xhttp.responseText == \"1\") {\n");
      out.write("\n");
      out.write("                            window.location = \"CartCheckout.jsp\";\n");
      out.write("\n");
      out.write("                        } else {\n");
      out.write("                            window.location = \"ClientHome.jsp\";\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            };\n");
      out.write("            xhttp.open(\"POST\", \"ClientLoginStatus\", true);\n");
      out.write("            xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhttp.send(\"u=\" + document.getElementById(\"uname\").value + \"&p=\" + document.getElementById(\"pword\").value + \"&r=\" + rem);//\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        function noBack() {\n");
      out.write("            window.history.forward();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head >\n");
      out.write("    <body onload=\"noBack()\">\n");
      out.write("        ");

            //Session session2 = new classes.SessionConect().testConnection();
            HttpSession hs = request.getSession();

            if (hs.getAttribute("client") != null) {
                response.sendRedirect("ClientHome.jsp");

            } else if (hs.getAttribute("admin") != null) {

                response.sendRedirect("AdminHome.jsp");
            } else if (hs.getAttribute("supplier") != null) {

                response.sendRedirect("SupplierHome.jsp");
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
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\"></span></span></a></li>\n");
      out.write("                        <!--<li><a  href=\"#m1\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>-->\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Login\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"clientLogin.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Log In</a></li>\n");
      out.write("                                <li><a href=\"#m2\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li> \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <h2 style=\"font-family: fantasy; color: #666666\">Welcome Back !!!</h2>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"img\" class=\"positionimg\">\n");
      out.write("            <img src=\"img/log.jpg\" alt=\"img1\" class=\"img-responsive\">             \n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-1\"></div>\n");
      out.write("        <div class=\"col-md-5\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h1><span class=\"glyphicon glyphicon-log-in\"> </span> Login</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div id=\"status\" class=\"warinintxt\"> \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <label><span class=\"glyphicon glyphicon-user\"> </span> User Name : </label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"uname\" placeholder=\"User Name\"><br><br>\n");
      out.write("                    <label><span class=\"glyphicon glyphicon-lock\"> </span> Password  :  </label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"pword\" placeholder=\"Password\"><br><br>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"checkbox\" id=\"rem\" class=\"checkbox-inline\">\n");
      out.write("                        <label class=\"label label-primary\">Remember Me </label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("\n");
      out.write("                    <input type=\"button\" class=\"btn btn-success col-md-offset-10\" id=\"login\" onclick=\"getData()\" value=\"Login\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
