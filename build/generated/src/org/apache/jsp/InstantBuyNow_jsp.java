package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mvc.CartHasStockModel;
import java.util.ArrayList;
import mvc.SessionCart;

public final class InstantBuyNow_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Instant Buy Now</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default navbar-collapse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"><img src=\"img/LOGO.png\" width=\"100\" height=\"30\" alt=\"My Watch.lk\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\"></span></span></a></li>\n");
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
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Payment</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"well well-lg col-md-5\" style=\"background-color: #00cc66; margin: 10px;\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <span><img src=\"img/business_user.png\" class=\"img-circle img-thumbnail\" style=\"width: 100px; height: 100px;\"></span> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    ");

                        HttpSession hs=request.getSession();
                        double tot=0.0;
                        if (hs.getAttribute("cart") != null) {
                            SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                            ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                            for (int i = 0; i < cartHasStocks.size(); i++) {
                                CartHasStockModel cartHasStock = cartHasStocks.get(i);
                                tot+=cartHasStock.getTotal();
                            }
                        }
                    
      out.write("\n");
      out.write("                    <h2 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(tot));
      out.write("</h2>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <h3 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> Dear Customer,</h3>\n");
      out.write("                    <h5 class=\"text-info text-capitalize\" style=\"color: #ffffff;\"> Hurry Purchase Those Items !!!</h5>\n");
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
