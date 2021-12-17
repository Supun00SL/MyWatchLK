package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import java.util.Set;
import org.hibernate.Session;

public final class SupplierHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
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
      out.write("            function logout() {\n");
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
      out.write("                        <li><a href=\"#\">Home</a></li>\n");
      out.write("                        <li><a href=\"#\">Page 1</a></li>\n");
      out.write("                        <li><a href=\"#\">Page 2</a></li> \n");
      out.write("                        <li><a href=\"#\">Page 3</a></li> \n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                                        HttpSession hs = request.getSession();
                            try {

                                if (hs.getAttribute("supplier") != null) {
                                    pojos.Supplier supplier1 = (pojos.Supplier) hs.getAttribute("supplier");
                                    pojos.Supplier supplier = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier1.getIdSupplier());

                                    Set<pojos.Supplierlogin> supplierlogins = supplier.getSupplierlogins();
                                    if (!supplierlogins.isEmpty()) {
                                        for (pojos.Supplierlogin supplierlogin : supplierlogins) {
                        
      out.write("\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> My Account\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a  href=\"SupplierRegistration_Advanced.jsp\"><span class=\"glyphicon glyphicon-user\"></span>  ");
      out.print( supplierlogin.getUsername());
      out.write("</a></li>\n");
      out.write("                                <li onclick=\"logout()\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                                            break;
                                        }
                                    }
                                } else {
                                    response.sendRedirect("SupplierLogin.jsp");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                ");
                    try {
                        HttpSession hs1 = request.getSession();
                        if (hs1.getAttribute("supplier") != null) {

                            pojos.Supplier supplier = (pojos.Supplier) hs1.getAttribute("supplier");

                            pojos.Supplier supplier1 = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier.getIdSupplier());
                
      out.write("\n");
      out.write("                <div class=\"well well-lg col-md-5\" style=\"background-color: #00cc66;\">\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <span><img src=\"");
      out.print( supplier1.getSupplierlogo());
      out.write("\" class=\"img-circle img-thumbnail\" style=\"width: 100px; height: 100px;\"></span> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <h2 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(00.00));
      out.write("</h2>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("                        <h3 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> ");
      out.print( supplier1.getCompanyName());
      out.write("</h3>\n");
      out.write("                        <!--<h5 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> Hurry Purchase Those Items !!!</h5>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <h4>Delivery Waiting List</h4>\n");
      out.write("                ");
                if (request.getParameter("id") != null) {
                        if (request.getParameter("id").equals("0")) {
                
      out.write("\n");
      out.write("                <div  id=\"stattop\">\n");
      out.write("                    <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                        Successfully Saved...!\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <div  id=\"stattop\">\n");
      out.write("                    <div class=\"alert alert-danger fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                        Not Saved Please Try Again...!\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                        }

                    }

                
      out.write("\n");
      out.write("                <table class=\"table table-condensed\">\n");
      out.write("                    <tr class=\" bg-info\">\n");
      out.write("                        <th>\n");
      out.write("                            Delivery Product\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Client Name\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Client address\n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                        <th>\n");
      out.write("                            Contact\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Delivery Status\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
                        int FirstResult = 0;
                        int MaxResult = 5;
                        int ResultSize = 0;

                        if (request.getParameter("fr") != null) {
                            int x = Integer.parseInt(request.getParameter("fr"));
                            FirstResult = x * MaxResult;
                        }

                        try {
                            HttpSession hs1 = request.getSession();

                            if (hs1.getAttribute("supplier") != null) {

                                pojos.Supplier supplier = (pojos.Supplier) hs1.getAttribute("supplier");

                                pojos.Supplier supplier1 = (pojos.Supplier) session2.load(pojos.Supplier.class, supplier.getIdSupplier());

                                //Set<pojos.Stock> stocks = supplier1.getStocks();
                                Criteria stockCriteria = session2.createCriteria(pojos.Stock.class);
                                stockCriteria.add(Restrictions.eq("supplier", supplier1));

                                List<pojos.Stock> stocks = stockCriteria.list();

                                if (!stocks.isEmpty()) {

                                    for (pojos.Stock stock : stocks) {
                                        Criteria invoicehassstockCriteria = session2.createCriteria(pojos.InvoiceHasStock.class);
                                        invoicehassstockCriteria.add(Restrictions.eq("stock", stock));

                                        List<pojos.InvoiceHasStock> invoiceHasStocks = invoicehassstockCriteria.list();

                                        //Set<pojos.InvoiceHasStock> invoiceHasStocks = stock.getInvoiceHasStocks();
                                        if (!invoiceHasStocks.isEmpty()) {
                                            for (pojos.InvoiceHasStock invoiceHasStock : invoiceHasStocks) {
                                                Criteria deliveryCriteria = session2.createCriteria(pojos.Deliveryitem.class);
                                                deliveryCriteria.add(Restrictions.eq("invoiceHasStock", invoiceHasStock));
                                                ResultSize = invoicehassstockCriteria.list().size();
                                                invoicehassstockCriteria.setFirstResult(FirstResult);
                                                invoicehassstockCriteria.setMaxResults(MaxResult);
                                                List<pojos.Deliveryitem> deliveryitems = deliveryCriteria.list();
                                                //Set<pojos.Deliveryitem> deliveryitems = invoiceHasStock.getDeliveryitems();

                                                if (!deliveryitems.isEmpty()) {
                                                    System.out.println("7");
                                                    for (pojos.Deliveryitem deliveryitem : deliveryitems) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"text-left col-md-4\">\n");
      out.write("                            <div class=\"well col-md-12\">\n");
      out.write("                                <div class=\"col-md-5 text-center\">\n");
      out.write("                                    <img src=\"");
      out.print( deliveryitem.getInvoiceHasStock().getStock().getProduct().getImage());
      out.write("\" alt=\"");
      out.print( deliveryitem.getInvoiceHasStock().getStock().getProduct().getSearchWord());
      out.write("\" class=\"img-rounded img-thumbnail\" width=\"200\" height=\"75\">                           \n");
      out.write("                                    <br><button type=\"submit\" class=\"btn btn-info\" style=\"margin-top: 5%; font-size: small;\"><span class=\"glyphicon glyphicon-eye-open\"></span> View More</button>\n");
      out.write("                                </div>\n");
      out.write("                                <div  class=\"col-md-7\">\n");
      out.write("                                    <label style=\"color: #333333\">Bar Code : ");
      out.print( deliveryitem.getInvoiceHasStock().getStock().getBarcode());
      out.write("</label>\n");
      out.write("                                    <hr><label style=\"color: #666666\">");
      out.print( deliveryitem.getInvoiceHasStock().getStock().getProduct().getSearchWord());
      out.write("</label>\n");
      out.write("                                    <label style=\"color: #666666\">Qty :");
      out.print( deliveryitem.getInvoiceHasStock().getQty());
      out.write("</label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"text-capitalize\">\n");
      out.write("                                <label style=\"margin-top: 35%;\">");
      out.print( deliveryitem.getInvoiceHasStock().getInvoice().getClient().getFname() + " " + deliveryitem.getInvoiceHasStock().getInvoice().getClient().getLname());
      out.write("</label>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"text-capitalize\">\n");
      out.write("                                <label style=\"margin-top: 16%;\">");
      out.print( deliveryitem.getNo() + " " + deliveryitem.getStreet() + " " + deliveryitem.getCity() + " " + deliveryitem.getDistrict());
      out.write("</label>\n");
      out.write("                                <br> <label>");
      out.print( deliveryitem.getCountry());
      out.write("</label>\n");
      out.write("                                <br> <label>Postal Code: ");
      out.print( deliveryitem.getPostalCode());
      out.write("</label>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"margin-top: 55%;\">");
      out.print( deliveryitem.getMobile());
      out.write("</label>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                        <td>\n");
      out.write("                            ");

                                if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Not Delivered")) {
                            
      out.write("\n");
      out.write("                            <form method=\"post\" action=\"ProductDelivery\">\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print( deliveryitem.getIdDeliveryItem());
      out.write("\" name=\"delid\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success\" style=\"margin-top: 40%;\"><span class=\"glyphicon glyphicon-send\"></span> Ship Now</button>\n");
      out.write("                            </form>\n");
      out.write("                            ");

                            } else if (deliveryitem.getDeliverystatus().getDeliveryStatus().equals("Shipped")) {
                            
      out.write("\n");
      out.write("                            <button disabled type=\"submit\" class=\"btn btn-danger\"  style=\"margin-top: 55%;\">Shipped</button>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>         \n");
      out.write("                    ");

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            } else {
                                response.sendRedirect("SupplierLogin.jsp");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <div class=\"panel panel-footer col-md-12 text-center\">\n");
      out.write("                    <ul class=\"pagination\">      \n");
      out.write("                        ");

                            int c = ResultSize % MaxResult;
                            int val = 0;
                            if (c == 0) {
                                val = ResultSize / MaxResult;
                            } else {
                                val = ((ResultSize / MaxResult) + 1);
                            }
                            for (int i = 0; i < val; i++) {

                        
      out.write("\n");
      out.write("                        <li id=\"");
      out.print(i);
      out.write("_li\">\n");
      out.write("                            <a href=\"SupplierHome.jsp?fr=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            }

                            session2.close();
                        
      out.write("\n");
      out.write("                    </ul>\n");
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
