package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class clientRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"myjs/ClientRegistration.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Client Registration Form</title>\n");
      out.write("        <script>\n");
      out.write("            function setValues() {\n");
      out.write("            ");

                HttpSession hs = request.getSession();
                if (hs.getAttribute("status") != null) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) hs.getAttribute("ClientDetails");
                    String status = hs.getAttribute("status").toString();
            
      out.write("\n");
      out.write("\n");
      out.write("                document.getElementById(\"fname\").value = \"");
      out.print( hashMap.get("fname"));
      out.write("\";\n");
      out.write("                document.getElementById(\"lname\").value = \"");
      out.print( hashMap.get("lname"));
      out.write("\";\n");
      out.write("                document.getElementById(\"email\").value = \"");
      out.print( hashMap.get("email"));
      out.write("\";\n");
      out.write("                document.getElementById(\"gender\").value = \"");
      out.print( hashMap.get("gender"));
      out.write("\";\n");
      out.write("                document.getElementById(\"mobileno\").value = \"");
      out.print( hashMap.get("mobileno"));
      out.write("\";\n");
      out.write("                document.getElementById(\"telephone\").value = \"");
      out.print( hashMap.get("telephoneno"));
      out.write("\";\n");
      out.write("                document.getElementById(\"addressno\").value = \"");
      out.print( hashMap.get("addressno"));
      out.write("\";\n");
      out.write("                document.getElementById(\"addressstreet1\").value = \"");
      out.print( hashMap.get("street1"));
      out.write("\";\n");
      out.write("                document.getElementById(\"addressstreet2\").value = \"");
      out.print( hashMap.get("street2"));
      out.write("\";\n");
      out.write("                document.getElementById(\"addressstreet3\").value = \"");
      out.print( hashMap.get("street3"));
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
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"setValues()\">\n");
      out.write("        ");

            Session session2 = new classes.SessionConect().testConnection();
            pojos.Client client = null;

        
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-default navbar-collapse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"><img src=\"img/LOGO.png\" width=\"100\" height=\"30\" alt=\"My Watch.lk\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"ClientHome.jsp\">Client Home</a></li>\n");
      out.write("                        <li  class=\"active\"><a href=\"ClientInvoiceHistory.jsp\">Client Invoice History</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

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
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                <div class=\"alert alert-danger fade in\" id=\"stat\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal fade\" id=\"m1\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header text-capitalize\">Upload Your Profile Picture</div>\n");
      out.write("                        <div class=\"modal-body text-center\">\n");
      out.write("                            <img src=\"icons/business_user.png\" alt=\"img\" class=\"img-circle img-thumbnail\" id=\"image1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <form method=\"post\" enctype=\"multipart/form-data\" action=\"UploadClientImage\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <input type=\"hidden\" value=\"n\" name=\"n\">\n");
      out.write("                                    <input required type=\"file\" class=\"btn btn-success\" onchange=\"getImage(this)\" name=\"img\">                                               \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\"><input type=\"submit\" multiple=\"true\" class=\"btn btn-info\" value=\"Upload\"></div>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <form action=\"ClientSaveUpdate\" method=\"post\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h3 class=\"page-header\"> Client Registration Form</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div class=\"form-group col-md-12 text-center\">\n");
      out.write("                            <a href=\"#m1\" data-toggle=\"modal\">\n");
      out.write("                                <img src=\"");
      out.print( new classes.Common().SetDefaultImageSupplier(client.getImage()));
      out.write("\" alt=\"img\" class=\"img-circle img-thumbnail\" id=\"image\" width=\"200\" height=\"150\">\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>First Name :</label> \n");
      out.write("                            <input type=\"text\"  class=\"form-control\" placeholder=\"First Name\" name=\"fname\" id=\"fname\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getFname()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Last Name :</label> \n");
      out.write("                            <input type=\"text\" name=\"lname\" id=\"lname\" class=\"form-control\" placeholder=\"Last Name\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getLname()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Email :</label> \n");
      out.write("                            <input type=\"text\"  name=\"email\" id=\"email\" class=\"form-control\" placeholder=\"Email\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getEmail()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Gender :</label> \n");
      out.write("                            <select class=\"form-control\" name=\"gender\" id=\"gender\">\n");
      out.write("                                ");

                                    Criteria genderCriteria = session2.createCriteria(pojos.Gender.class);

                                    List<pojos.Gender> genders = genderCriteria.list();

                                    if (!genders.isEmpty()) {
                                        for (pojos.Gender gender : genders) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print( gender.getGender());
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Mobile Number :</label> \n");
      out.write("                            <input type=\"text\"  name=\"mobileno\" id=\"mobileno\" class=\"form-control\" placeholder=\"Mobile Number\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getMobileno()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Telephone :</label> \n");
      out.write("                            <input type=\"text\" name=\"telephone\" id=\"telephone\" class=\"form-control\" placeholder=\"Telephone\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getTelephoneno()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Address No :</label> \n");
      out.write("                            <input type=\"text\"  name=\"addressno\" id=\"addressno\" class=\"form-control\" placeholder=\"Address Number\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getAddressno()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Address Street1 :</label> \n");
      out.write("                            <input type=\"text\"  name=\"addressstreet1\" id=\"addressstreet1\" class=\"form-control\" placeholder=\"Address Street1\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getStreet1()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Address Street2 :</label> \n");
      out.write("                            <input type=\"text\" name=\"addressstreet2\" id=\"addressstreet2\" class=\"form-control\" placeholder=\"Address Street2\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getStreet2()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Address Street3 :</label> \n");
      out.write("                            <input type=\"text\" name=\"addressstreet3\" id=\"addressstreet3\" class=\"form-control\" placeholder=\"Address Street3\" value=\"");
      out.print( new classes.Common().checkNullablility(client.getStreet3()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>User Name :</label>\n");
      out.write("                            <input type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"User Name\" value=\"");
      out.print( new classes.Common().Set_UsernameClient(client.getClientlogins()));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Password :</label> \n");
      out.write("                            <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-md-3\">\n");
      out.write("                            <label>Re Enter Password :</label> \n");
      out.write("                            <input type=\"password\" name=\"reenterpassword\" id=\"reenterpassword\" class=\"form-control\" placeholder=\"Re Enter Password\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-footer\">\n");
      out.write("                        <div class=\"form-inline col-md-offset-10\">\n");
      out.write("                            <input type=\"submit\" name=\"submited\" class=\"btn btn-primary\" id=\"save\" value=\"Save\">\n");
      out.write("                            <input type=\"submit\" name=\"submited\" class=\"btn btn-primary\" id=\"update\" value=\"Update\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
