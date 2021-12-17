package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import org.hibernate.Session;
import java.util.Set;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class AdminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/SupplierActivation.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("         <script>\n");
      out.write("                 var xhttp;\n");
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
      out.write("             function logout() {\n");
      out.write("                CreateRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
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
      out.write("        </script>\n");
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
      out.write("                                <li onclick=\"logout()\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</li>\n");
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
      out.write("                <h3>Admin Home</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("                        ");
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
      out.write("        \n");
      out.write("        <title>Supplier Activation</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Session session1 = new classes.SessionConect().testConnection();

        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Supplier Activation</h3>\n");
      out.write("            </div>\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>GovReg Code</th>\n");
      out.write("                    <th>Company Name</th>\n");
      out.write("                    <th>Mobile</th>\n");
      out.write("                    <th>Telephone</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Status</th>\n");
      out.write("                    <th>Verification</th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");
                    Criteria supplierCriteria = session1.createCriteria(pojos.Supplier.class);

                    List<pojos.Supplier> suppliers = supplierCriteria.list();

                    if (!suppliers.isEmpty()) {
                        for (pojos.Supplier supplier : suppliers) {
                
      out.write("\n");
      out.write("                <form method=\"post\" action=\"SupplierActivation\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( supplier.getGovRegistrationCode());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getCompanyName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getMobileno());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getTelephoneno());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getAddressno() + " " + supplier.getStreet1() + " " + supplier.getStreet2() + " " + supplier.getStreet3());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getEmail());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supplier.getUserstatus().getUserStatus());
      out.write("</td>\n");
      out.write("                    <input type=\"hidden\" name=\"supplierid\" value=\"");
      out.print( supplier.getIdSupplier());
      out.write("\">\n");
      out.write("                    ");


                        if (supplier.getUserstatus().getIdUserStatus() == 2) {
                            Set<pojos.Supplierverificationcode> s = supplier.getSupplierverificationcodes();

                            if (s.size() == 0) {
                    
      out.write("\n");
      out.write("                    <td><input type=\"submit\" value=\"Send Verification Code\" class=\"btn btn-success\"></td>\n");
      out.write("\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <td><input disabled type=\"submit\" value=\"Verification Code Sended\" class=\"btn btn-primary\"></td>\n");
      out.write("\n");
      out.write("                    ");

                        }
                    } else {

                    
      out.write("\n");
      out.write("                    <td><input type=\"submit\" value=\"Deactivate User\" class=\"btn btn-danger\"></td>\n");
      out.write("\n");
      out.write("                    ");
                        }
                    
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("                ");

                        }
                    }

                
      out.write("\n");
      out.write("            </table>\n");
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
