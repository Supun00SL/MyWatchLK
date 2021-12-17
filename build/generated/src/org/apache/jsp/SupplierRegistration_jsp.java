package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;

public final class SupplierRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function setValues() {\n");
      out.write("            ");

                HttpSession hs = request.getSession();
                if (hs.getAttribute("status") != null) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) hs.getAttribute("SupplierDetails");
                    String status = hs.getAttribute("status").toString();
            
      out.write("\n");
      out.write("\n");
      out.write("                document.getElementById(\"comname\").value = \"");
      out.print( hashMap.get("comname"));
      out.write("\";\n");
      out.write("                document.getElementById(\"grccode\").value = \"");
      out.print( hashMap.get("grccode"));
      out.write("\";\n");
      out.write("                document.getElementById(\"mobilenumber\").value = \"");
      out.print( hashMap.get("mobilenumber"));
      out.write("\";\n");
      out.write("                document.getElementById(\"telephonenumber\").value = \"");
      out.print( hashMap.get("telephonenumber"));
      out.write("\";\n");
      out.write("                document.getElementById(\"addressno\").value = \"");
      out.print( hashMap.get("addressno"));
      out.write("\";\n");
      out.write("                document.getElementById(\"street1\").value = \"");
      out.print( hashMap.get("street1"));
      out.write("\";\n");
      out.write("                document.getElementById(\"street2\").value = \"");
      out.print( hashMap.get("street2"));
      out.write("\";\n");
      out.write("                document.getElementById(\"street3\").value = \"");
      out.print( hashMap.get("street3"));
      out.write("\";\n");
      out.write("                document.getElementById(\"email\").value = \"");
      out.print( hashMap.get("email"));
      out.write("\";\n");
      out.write("                document.getElementById(\"username\").value = \"");
      out.print( hashMap.get("username"));
      out.write("\";\n");
      out.write("                document.getElementById(\"password\").value = \"\";\n");
      out.write("                document.getElementById(\"reenterpassword\").value = \"\";\n");
      out.write("                var stat = document.getElementById(\"stat\");\n");
      out.write("                var stattop = document.getElementById(\"stattop\");\n");
      out.write("                var stata = \"");
      out.print( status);
      out.write("\";\n");
      out.write("                if (stata !== \"\") {\n");
      out.write("                    stat.innerHTML = stata;\n");
      out.write("                    stattop.className = \"show\";\n");
      out.write("                }\n");
      out.write("            ");

                  
                }
            
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title>Supplier Registration</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"setValues()\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\">My Watch</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"#\">Page 1</a></li>\n");
      out.write("                            <li><a href=\"#\">Page 2</a></li> \n");
      out.write("                            <li><a href=\"#\">Page 3</a></li> \n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n");
      out.write("                            <li  class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("             <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                <div class=\"alert alert-danger fade in\" id=\"stat\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <form method=\"post\" action=\"SupplierRegistration\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel panel-heading\">\n");
      out.write("                        <h3 class=\"page-header\"> Supplier Registration</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-body\">\n");
      out.write("                        <div>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Company Name :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Company Name\" name=\"comname\" id=\"comname\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Government Registration Code :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Government Registration Code\" name=\"grccode\" id=\"grccode\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Mobile Number :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Mobile Number\" name=\"mobilenumber\" id=\"mobilenumber\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Telephone Number :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Telephone Number\" name=\"telephonenumber\" id=\"telephonenumber\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Address No :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Address No\" name=\"addressno\" id=\"addressno\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Street1 :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Street1\" name=\"street1\" id=\"street1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Street2 :</label> \n");
      out.write("                            <input type=\"text\"  class=\"form-control\" placeholder=\"Street2\" name=\"street2\" id=\"street2\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Street3 :</label> \n");
      out.write("                            <input type=\"text\"  class=\"form-control\" placeholder=\"Street3\" name=\"street3\" id=\"street3\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-12\">\n");
      out.write("                            <label>Email :</label> \n");
      out.write("                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Email\" name=\"email\" id=\"email\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>User Name :</label>\n");
      out.write("                            <input required type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"User Name\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Password :</label> \n");
      out.write("                            <input required type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Re Enter Password :</label> \n");
      out.write("                            <input required type=\"password\" name=\"reenterpassword\" id=\"reenterpassword\" class=\"form-control\" placeholder=\"Re Enter Password\">\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-footer\">\n");
      out.write("                        <div class=\"form-inline col-md-offset-11\">\n");
      out.write("                            <input type=\"submit\" name=\"submited\" class=\"btn btn-primary\" id=\"save\" value=\"Register\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </form>\n");
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
