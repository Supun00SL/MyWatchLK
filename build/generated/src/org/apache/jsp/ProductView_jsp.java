package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ProductView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"myjs/ViewProduct.js\"></script>-->\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <title>Product View</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("<!--        <div class=\"container-fluid\">\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\">My Watch</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"ViewCart.jsp\">Cart</a></li>\n");
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
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Product Details</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>-->\n");
      out.write("        <!--<div class=\"container\">-->\n");
      out.write("            <div>\n");
      out.write("                <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                    <div class=\"alert alert-success fade in row\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>  \n");
      out.write("                ");
                int FirstResult = 0;
                    int MaxResult = 6;

                    if (request.getParameter("fr") != null) {
                        int x = Integer.parseInt(request.getParameter("fr"));
                        FirstResult = x * MaxResult;
                    }
                    Session session1 = new classes.SessionConect().testConnection();
                    
                    Criteria genCriteria=session1.createCriteria(pojos.Gendertype.class);
                    

                    Criteria productCriteria = session1.createCriteria(pojos.Stock.class);
                    int ResultSize = productCriteria.list().size();
                    productCriteria.setFirstResult(FirstResult);
                    productCriteria.setMaxResults(MaxResult);
                    List<pojos.Stock> stocks = productCriteria.list();

                    if (!stocks.isEmpty()) {
                        for (pojos.Stock stock : stocks) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h3>Item Code :");
      out.print( stock.getBarcode());
      out.write("</h3>\n");
      out.write("                            <h4>");
      out.print( stock.getProduct().getSearchWord());
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body text-center\">\n");
      out.write("                            <img src=\" ");
      out.print( stock.getProduct().getImage());
      out.write("\" width=\"200\" height=\"150\" alt=\"1\" class=\"img-rounded\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">\n");
      out.write("                            <h4> Product Price:  ");
      out.print( stock.getSellingPrice());
      out.write("LKR</h4>\n");
      out.write("                            <h4> Available Quantity: ");
      out.print( stock.getQty());
      out.write("</h4>\n");
      out.write("                            <h4> Add to Cart Qty: </h4>\n");
      out.write("                            <input type=\"number\" class=\" form-control\" id=\"");
      out.print( stock.getIdStock());
      out.write("_qty\" value=\"1\" max=\"");
      out.print( stock.getQty());
      out.write("\"><br>\n");
      out.write("                            <div class=\"text-right\">\n");
      out.write("                                <button class=\"btn btn-default\" onclick=\"AddToCart(");
      out.print( stock.getIdStock());
      out.write(")\">Add To Cart  <span class=\"glyphicon glyphicon-eye-open\"></span> </button>\n");
      out.write("                                <button class=\"btn btn-default\" onclick=\"View(");
      out.print( stock.getIdStock());
      out.write(")\">View This Product</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");

                        }

                    }
                
      out.write("\n");
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
      out.write("                            <a href=\"index.jsp?fr=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            }
                            
                            session1.close();
                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        <!--</div>-->\n");
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
