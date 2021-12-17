package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>Admin Login</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .panel{\n");
      out.write("                text-align: center;\n");
      out.write("                width: 40%;\n");
      out.write("                position: relative;\n");
      out.write("                margin-left: 27%;\n");
      out.write("                margin-top: 10%;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .label{\n");
      out.write("                background-color: #663300;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .label-default{\n");
      out.write("                float: left;\n");
      out.write("                font-family: \"Century Gothic\";\n");
      out.write("                font-size: 20px;\n");
      out.write("                background-color: transparent;\n");
      out.write("                color: #333333;\n");
      out.write("            }\n");
      out.write("            .form-control{\n");
      out.write("                float: right;\n");
      out.write("                width: 50%\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .btn-info{\n");
      out.write("                float: right;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .warinintxt{\n");
      out.write("                color: #ff3333;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function getData() {\n");
      out.write("                var xhttp;\n");
      out.write("\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                var stat = document.getElementById(\"status\");\n");
      out.write("\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("                        var text = xhttp.responseText;\n");
      out.write("                        if (text.length > 0) {\n");
      out.write("                            stat.innerHTML = xhttp.responseText;\n");
      out.write("                            document.getElementById(\"uname\").value = '';\n");
      out.write("                            document.getElementById(\"pword\").value = '';\n");
      out.write("                        } else {\n");
      out.write("                            window.location = \"AdminHome.jsp\";\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", \"AdminLoginStatus\", false);\n");
      out.write("                xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xhttp.send(\"u=\" + document.getElementById(\"uname\").value + \"&p=\" + document.getElementById(\"pword\").value);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            window.history.forward();\n");
      out.write("            function noBack() {\n");
      out.write("                window.history.forward();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"noBack()\" onpageshow=\"if (event.persisted) noBack();\" onunload=\"\">\n");
      out.write("        ");

          
             HttpSession hs = request.getSession();
             
             if(hs.getAttribute("client")!=null){
                response.sendRedirect("index.jsp");            
             }
             
             if(hs.getAttribute("admin")!=null){
                response.sendRedirect("AdminHome.jsp");
             }
             
             if(hs.getAttribute("supplier")!=null){
                response.sendRedirect("SupplierHome.jsp");
             }
            
        
      out.write("\n");
      out.write("        <div class=\"panel\">\n");
      out.write("            <div class=\"panel-title\">\n");
      out.write("                <h1>Admin Login</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                <label class=\"label label-default\">User Name : </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"uname\" placeholder=\"User Name\"><br><br>\n");
      out.write("                <label class=\" label label-default\">Password  :  </label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" id=\"pword\" placeholder=\"Password\"><br><br>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"status\" class=\"warinintxt\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-footer\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-info\" id=\"login\" onclick=\"getData()\">Login</button>\n");
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
