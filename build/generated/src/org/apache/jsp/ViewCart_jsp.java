package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import mvc.CartHasStockModel;
import java.util.ArrayList;
import mvc.SessionCart;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ViewCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Session session2 = new classes.SessionConect().testConnection();
        
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

                            if (hs.getAttribute("client") != null) {
                                pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                                pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                                Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                                if (!clientlogins.isEmpty()) {
                                    for (pojos.Clientlogin clientlogin : clientlogins) {
                        
      out.write("\n");
      out.write("                        <li class=\"active\"><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\">");
      out.print( new mvc.ClientHome().ReturnCartBadgeCount(client));
      out.write("</span></span></a></li>\n");
      out.write("                        <li><a  href=\"clientRegistration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( clientlogin.getUsername());
      out.write("</a></li>\n");
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
      out.write("            <h3>Cart</h3>\n");
      out.write("            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>  \n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            ");
                Session session1 = new classes.SessionConect().testConnection();
                try {
                    HttpSession hs1 = request.getSession();
                    if (hs1.getAttribute("client") != null) {

                        pojos.Client client = (pojos.Client) hs1.getAttribute("client");

                        pojos.Client client1 = (pojos.Client) session1.load(pojos.Client.class, client.getIdClient());

//                        if (hs.getAttribute("cart") != null) {
//                            SessionCart cart = (SessionCart) hs.getAttribute("cart");
//                            //new mvc.SessionCart().SaveSessionCartToTheDB(cart, client);
//                        }
                        Criteria cartCriteria = session1.createCriteria(pojos.Cart.class);
                        cartCriteria.add(Restrictions.eq("client", client1));

                        List<pojos.Cart> carts = cartCriteria.list();

                        if (!carts.isEmpty()) {
                            pojos.Cart cart = carts.get(0);
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"well well-lg col-md-5\" style=\"background-color: #00cc66;\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <span><img src=\"");
      out.print( client1.getImage());
      out.write("\" class=\"img-circle img-thumbnail\" style=\"width: 100px; height: 100px;\"></span> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <h2 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(cart.getNetTotal()));
      out.write("</h2>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <h3 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> ");
      out.print( client1.getFname() + "  " + client1.getLname());
      out.write("</h3>\n");
      out.write("                    <h5 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> Hurry Purchase Those Items !!!</h5>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"well well-lg col-md-5\" style=\"background-color: #00cc66;\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <span><img src=\"");
      out.print( client1.getImage());
      out.write("\" class=\"img-circle img-thumbnail\" style=\"width: 100px; height: 100px;\"></span> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <h2 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> RS 0.00</h2>\n");
      out.write("                    <hr>\n");
      out.write("                    <h3 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> ");
      out.print( client1.getFname() + "  " + client1.getLname());
      out.write("</h3>\n");
      out.write("                    <h5 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> Your Cart is Empty !!!</h5>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                        }
                    } else {
                        //response.sendRedirect("clientLogin.jsp");

                        if (hs.getAttribute("cart") != null) {
                            SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                            ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                            for (int i = 0; i < cartHasStocks.size(); i++) {
                                CartHasStockModel cartHasStock = cartHasStocks.get(i);
                                System.out.println("------New----------");
                                //pojos.CartHasStock cartHasStock1 = (pojos.CartHasStock) session1.load(pojos.CartHasStock.class, i);
                                System.out.println(cartHasStock.getCartHasStockid());
                                pojos.Stock stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid()));
                                System.out.println(stock.getProduct().getSearchWord());
                                System.out.println(cartHasStock.getQty());
                                System.out.println(cartHasStock.getTotal());
                                System.out.println("------End----------");
                            }
                        } else {

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            
      out.write("\n");
      out.write("            <div class=\"panel panel-body\">\n");
      out.write("                <table class=\"table table-bordered\">\n");
      out.write("\n");
      out.write("                    ");
                        try {
                            HttpSession hs2 = request.getSession();
                            if (hs2.getAttribute("client") != null) {
                                pojos.Client client = (pojos.Client) hs2.getAttribute("client");

                                pojos.Client client1 = (pojos.Client) session1.load(pojos.Client.class, client.getIdClient());

                                Criteria cartCriteria = session1.createCriteria(pojos.Cart.class);
                                cartCriteria.add(Restrictions.eq("client", client1));

                                List<pojos.Cart> carts = cartCriteria.list();

                                if (!carts.isEmpty()) {
                                    pojos.Cart cart = carts.get(0);

                                    Criteria cartItem = session1.createCriteria(pojos.CartHasStock.class);
                                    cartItem.add(Restrictions.eq("cart", cart));

                                    List<pojos.CartHasStock> cartsHasStocks = cartItem.list();

                                    if (!cartsHasStocks.isEmpty()) {
                                        for (pojos.CartHasStock cartHasStock : cartsHasStocks) {

                    
      out.write("\n");
      out.write("                    <tr class=\"col-lg-6\">\n");
      out.write("                        <td>\n");
      out.write("                            <img src=\"");
      out.print( cartHasStock.getStock().getProduct().getImage());
      out.write("\" class=\"img-rounded\" alt=\"1\" width=\"200\" height=\"150\">\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <h4 class=\"text-capitalize\">Product :");
      out.print( cartHasStock.getStock().getProduct().getSearchWord());
      out.write("</h4>\n");
      out.write("                            <h4 class=\"text-danger\">QTY     :");
      out.print( cartHasStock.getQty());
      out.write("</h4>\n");
      out.write("                            <h4 class=\"text-primary\">Total   :");
      out.print( cartHasStock.getTotal());
      out.write(" LKR</h4>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
                                        }
                                    }
                                }
                            } else {
                                //response.sendRedirect("clientLogin.jsp");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
                    Session session4 = new classes.SessionConect().testConnection();

                HttpSession hs1 = request.getSession();
                if (hs1.getAttribute("client") != null) {

                    pojos.Client client = (pojos.Client) hs1.getAttribute("client");

                    pojos.Client client1 = (pojos.Client) session4.load(pojos.Client.class, client.getIdClient());

                    Criteria cartCriteria = session4.createCriteria(pojos.Cart.class);
                    cartCriteria.add(Restrictions.eq("client", client1));

                    List<pojos.Cart> carts = cartCriteria.list();

                    if (!carts.isEmpty()) {
                        pojos.Cart cart = carts.get(0);
            
      out.write("\n");
      out.write("            <div class=\"panel panel-footer col-md-12\">\n");
      out.write("                <div class=\"col-md-offset-10\">\n");
      out.write("                    <form action=\"#\" method=\"post\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-check\"></span> Checkout</button>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
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
