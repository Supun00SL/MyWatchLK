package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ViewProductDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/Magnify.css\">       \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/magnify.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>  \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("                ");

                    Session session1 = new classes.SessionConect().testConnection();
                    pojos.Stock stock = null;
                    try {
                        if (request.getParameter("ideka") != null) {
                            stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(request.getParameter("ideka")));

                            if (stock != null) {

                
      out.write("\n");
      out.write("                <table class=\"table table-bordered\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"text-center\">\n");
      out.write("                            <div class=\"magnify\">\n");
      out.write("                                <div class=\"large\"></div>\n");
      out.write("                                <img src=\"img/watch-fresh-new-hd-best-quality-596680.jpg\" alt=\"1\" width=\"200\" height=\"150\" class=\"small\">\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <h3 class=\"text-capitalize\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</h3> \n");
      out.write("                            <h4 class=\"text-success\">Item Code :");
      out.print( stock.getBarcode());
      out.write("</h4>                                                          \n");
      out.write("                            <!--<h4>Brand :</h4>-->                               \n");
      out.write("                            <h4 class=\"text-danger\">Available QTY :");
      out.print( stock.getQty());
      out.write("</h4>\n");
      out.write("                            <h4 class=\"text-info\">Unit Price :");
      out.print( stock.getFinalPrice() );
      out.write(" LKR</h4>\n");
      out.write("                            <br>\n");
      out.write("                            ");

                                Criteria sellerCriteria = session1.createCriteria(pojos.SupplierHasStock.class);
                                sellerCriteria.add(Restrictions.eq("stock", stock));

                                List<pojos.SupplierHasStock> hasStocks = sellerCriteria.list();

                                if (!hasStocks.isEmpty()) {
                                    pojos.SupplierHasStock hasStock = hasStocks.get(0);
                            
      out.write("\n");
      out.write("                            <h3 class=\"text-info\">Seller :");
      out.print( hasStock.getSupplier().getCompanyName());
      out.write("</h3>\n");
      out.write("                            ");

                                }

                            
      out.write("\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("                ");
                            } else {
                                out.write("eliye");
                            }
                        } else {
                            response.sendRedirect("ProductView.jsp");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
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
