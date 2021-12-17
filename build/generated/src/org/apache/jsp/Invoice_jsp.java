package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class Invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">         \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>Invoice</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Session session2 = new classes.SessionConect().testConnection();
        
      out.write("\n");
      out.write("        <div class=\"page-header\">\n");
      out.write("            <h3>Invoice</h3>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-offset-9\">\n");
      out.write("                ");

                    HttpSession hs4 = request.getSession();
                    if (hs4.getAttribute("client") != null) {
                        pojos.Client client = (pojos.Client) hs4.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());

                    

                
      out.write("\n");
      out.write("                <label>Name :");
      out.print( client1.getFname()+ " "+client1.getLname() );
      out.write("</label><br>\n");
      out.write("                <label>Address :");
      out.print( client1.getAddressno() + " "+client1.getStreet1()+" "+client1.getStreet2() );
      out.write("</label><br>\n");
      out.write("                <label>Contact :");
      out.print( client1.getMobileno() + " / "+client1.getTelephoneno() );
      out.write("</label><br>\n");
      out.write("                <label>Email :");
      out.print( client1.getEmail() );
      out.write("</label><br>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("                <hr>\n");
      out.write("            <div>\n");
      out.write("                <table class=\"table table-hover col-md-12\">\n");
      out.write("                    <tr class=\"bg-info\">\n");
      out.write("                        <th style=\"color: #999999;\">Product Name & Details</th>\n");
      out.write("                        <th style=\"color: #999999;\">Quantity</th>\n");
      out.write("                        <th style=\"color: #999999;\">Price</th>\n");
      out.write("                        <th style=\"color: #999999;\">Shipping Details</th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    ");
                        try {
                            HttpSession hs2 = request.getSession();
                            if (hs2.getAttribute("client") != null) {
                                pojos.Client client = (pojos.Client) hs2.getAttribute("client");

                                pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());

                                Criteria cartCriteria = session2.createCriteria(pojos.Cart.class);
                                cartCriteria.add(Restrictions.eq("client", client1));

                                List<pojos.Cart> carts = cartCriteria.list();

                                if (!carts.isEmpty()) {
                                    pojos.Cart cart = carts.get(0);

                                    Criteria cartItem = session2.createCriteria(pojos.CartHasStock.class);
                                    cartItem.add(Restrictions.eq("cart", cart));

                                    List<pojos.CartHasStock> cartsHasStocks = cartItem.list();

                                    if (!cartsHasStocks.isEmpty()) {
                                        for (pojos.CartHasStock cartHasStock : cartsHasStocks) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"col-md-3\">\n");
      out.write("                            <img src=\"");
      out.print( cartHasStock.getStock().getProduct().getImage());
      out.write("\" class=\"img-rounded\" alt=\"1\" width=\"100\" height=\"75\">\n");
      out.write("                            <h5 class=\"text-capitalize\">");
      out.print( cartHasStock.getStock().getProduct().getSearchWord());
      out.write("</h5>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <label class=\"text-danger\">");
      out.print( cartHasStock.getQty());
      out.write("</label>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <label>RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal()));
      out.write(" </label>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <label style=\"color: #999999;\">Sub Total :</label>\n");
      out.write("                            <label>RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal()));
      out.write("</label>\n");
      out.write("                            <br>\n");
      out.write("                            <label style=\"color: #999999;\">Shipping Cost :</label>\n");
      out.write("                            <label>RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(0.00));
      out.write("</label>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-offset-9 \">\n");
      out.write("                                <label style=\"color: #999999;\">Total :</label>\n");
      out.write("                                <label class=\"text-primary\">RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(cartHasStock.getTotal()));
      out.write("</label>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
                                        }
                                    }
                                }
                            } else {
                                response.sendRedirect("clientLogin.jsp");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"well text-right\">\n");
      out.write("                ");
                HttpSession hs3 = request.getSession();
                    if (hs3.getAttribute("client") != null) {

                        pojos.Client client = (pojos.Client) hs3.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session2.load(pojos.Client.class, client.getIdClient());
                        Criteria cartCriteria = session2.createCriteria(pojos.Cart.class);
                        cartCriteria.add(Restrictions.eq("client", client1));

                        List<pojos.Cart> carts = cartCriteria.list();

                        if (!carts.isEmpty()) {
                            pojos.Cart cart = carts.get(0);
                
      out.write("\n");
      out.write("                <div class=\"col-md-offset-9\">\n");
      out.write("                    <label  style=\"color: #999999;\">Sub Total (");
      out.print( cart.getCartHasStocks().size());
      out.write(" Items):</label>\n");
      out.write("                    <label class=\"text-primary\">RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(cart.getNetTotal()));
      out.write("</label>\n");
      out.write("\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("                    <label  style=\"color: #999999;\">Shipping Cost (");
      out.print( cart.getCartHasStocks().size());
      out.write(" Items):</label>\n");
      out.write("                    <label class=\"text-primary\">RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(0.00));
      out.write("</label>\n");
      out.write("\n");
      out.write("                    <hr>\n");
      out.write("                    <label  style=\"color: #999999; font-size: large;\">All Total :</label>\n");
      out.write("                    <label class=\"text-success\" style=\"font-size: x-large;\">RS ");
      out.print( new classes.Common().VALUE_FORMAT.format(cart.getNetTotal()));
      out.write("</label>\n");
      out.write("                    <br>\n");
      out.write("                    <form method=\"post\" action=\"PaymentInvoice\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-warning\"><span class=\"glyphicon glyphicon-usd\"></span>  Payment</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");

                        }
                    }
                    session2.close();
                
      out.write(" \n");
      out.write("\n");
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
