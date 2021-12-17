package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import java.util.Set;

public final class CompleteOrders_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Complete Orders</title>\n");
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
      out.write("                        <li><a href=\"ClientHome.jsp\">Client Home</a></li>\n");
      out.write("                        <li><a href=\"ClientInvoiceHistory.jsp\">Client Invoice History</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                                        HttpSession hs = request.getSession();
                            pojos.Client client = null;
                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"well-sm\">\n");
      out.write("                                <form class=\"form-inline\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"I'm shopping for.....\">\n");
      out.write("                                    <button class=\"btn btn-info glyphicon glyphicon-search form-control\"></button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><a  href=\"ClientWatchList.jsp\"><span class=\"glyphicon glyphicon-eye-open\"><span class=\"badge\" id=\"wb\">");
      out.print( new mvc.ClientHome().ReturnWatchListBadgeCount(client));
      out.write("</span></span> </a></li>\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\" id=\"cb\">");
      out.print( new mvc.ClientHome().ReturnCartBadgeCount(client));
      out.write("</span></span></a></li>\n");
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
      out.write("        <div class=\"container\">\n");
      out.write("            ");
                if (request.getParameter("id") != null) {
                    if (request.getParameter("id").equals("0")) {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    Successfully Saved...!\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-danger fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    Not Saved Please Try Again...!\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                    }

                }

            
      out.write("\n");
      out.write("            <table class=\"table table-condensed\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Item</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Order State</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
                Set<pojos.Invoice> invoices = client.getInvoices();

                    for (pojos.Invoice invoice : invoices) {
                        Set<pojos.InvoiceHasStock> hasStocks = invoice.getInvoiceHasStocks();

                        for (pojos.InvoiceHasStock hasStock : hasStocks) {
                            Set<pojos.Deliveryitem> deliveryitems = hasStock.getDeliveryitems();

                            for (pojos.Deliveryitem deliveryitem : deliveryitems) {
                                if (!deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Delivered")) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"");
      out.print( hasStock.getStock().getProduct().getImage());
      out.write("\" class=\"img-rounded\" height=\"100\"></td>\n");
      out.write("                    <td>");
      out.print(hasStock.getStock().getProduct().getSearchWord());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(hasStock.getQty());
      out.write("</td>\n");
      out.write("                    ");

                        if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Shipped")) {
                    
      out.write("\n");
      out.write("                <form method=\"post\" action=\"settofound\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(deliveryitem.getIdDeliveryItem());
      out.write("\" name=\"delid\">\n");
      out.write("                    <input type=\"submit\" value=\"Found Order\" class=\"btn btn-success\">\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                ");

                } else if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Not Delivered")) {
                
      out.write("\n");
      out.write("                <input disabled type=\"button\" value=\"Not Delievered by Supplie Yet\" class=\"btn btn-warning\">\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");

                                }
                            }
                        }
                    }

                
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        var xhttp;\n");
      out.write("\n");
      out.write("        function CreateRequest() {\n");
      out.write("            if (window.XMLHttpRequest) {\n");
      out.write("                xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("            } else if (window.ActiveXObject) {\n");
      out.write("                xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function logout() {\n");
      out.write("            CreateRequest();\n");
      out.write("            xhttp.onreadystatechange = function() {\n");
      out.write("\n");
      out.write("                if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                    var text = xhttp.responseText;\n");
      out.write("                    window.location = \"index.jsp\";\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xhttp.open(\"POST\", \"Logout\", true);\n");
      out.write("            xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhttp.send();\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
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
