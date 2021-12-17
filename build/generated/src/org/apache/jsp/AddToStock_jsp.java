package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class AddToStock_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .thumbnail img{\n");
      out.write("                width: 300px;\n");
      out.write("                height: 175px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function update(val) {\n");
      out.write("                document.getElementById('val').innerHTML = val + \"%\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <title>Add To Stock</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession hs = request.getSession();
            Session session1 = new classes.SessionConect().testConnection();
            if (hs.getAttribute("supplier") != null) {
                pojos.Supplier supplier = (pojos.Supplier) hs.getAttribute("supplier");
                pojos.Supplier supplier1 = (pojos.Supplier) session1.load(pojos.Supplier.class, supplier.getIdSupplier());
            } else {
                session1.close();
                response.sendRedirect("SupplierLogin.jsp");
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
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
      out.write("            ");
                if (request.getParameter("msg") != null) {
                    if (request.getParameter("msg").equals("3")) {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    Successfully Saved...!\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

            } else if (request.getParameter("msg").equals("1")) {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-danger fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    Please Choose Valid Selling Price...!\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <div  id=\"stattop\">\n");
      out.write("                <div class=\"alert alert-danger fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                    Please Choose Valid QTY...!\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                    }

                }


            
      out.write("\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel panel-heading\">\n");
      out.write("                    <h3 class=\"page-header\"> Add To Stock</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-body\">\n");
      out.write("                    <div class=\"col-md-12 text-center\" id=\"images\">\n");
      out.write("\n");
      out.write("                    </div><br>\n");
      out.write("                    <form action=\"ViewDetails\" method=\"post\">\n");
      out.write("                        <div class=\"form-group col-md-6\">\n");
      out.write("                            <label>Select Your Item :</label>\n");
      out.write("                            ");
                                Criteria itemCriteria = session1.createCriteria(pojos.Product.class);
                                List<pojos.Product> products = itemCriteria.list();
                                pojos.Product product = null;
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <input list=\"items\" name=\"item\" class=\"form-control\" id=\"name\">\n");
      out.write("                            <datalist id=\"items\">\n");
      out.write("                                ");

                                    if (!products.isEmpty()) {
                                        for (int i = 0; i < products.size(); i++) {
                                            product = products.get(i);
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( product.getItemCode() + " : " + product.getSearchWord());
      out.write("\" id=\"");
      out.print( product.getIdProduct());
      out.write("\">\n");
      out.write("                                    ");

                                            }
                                        }
                                    
      out.write("\n");
      out.write("                            </datalist><br>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-info col-lg-offset-10\" value=\"Search\" >\n");
      out.write("                        </div >\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        if (request.getParameter("id") != null) {

                            pojos.Product product2 = (pojos.Product) session1.load(pojos.Product.class, Integer.parseInt(request.getParameter("id")));

                    
      out.write("\n");
      out.write("                    <div class=\"form-group col-md-6\" id=\"images\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\" col-md-12\">\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"col-md-4\">\n");
      out.write("                                    <div class=\"thumbnail\">\n");
      out.write("                                        <img src=\"");
      out.print( product2.getImage());
      out.write("\" class=\" img-thumbnail\"> \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h3 class=\"text-capitalize\">");
      out.print( product2.getSearchWord());
      out.write("</h3> \n");
      out.write("                                    <h4 class=\"text-success\">Item Code :");
      out.print( product2.getItemCode());
      out.write("</h4>                                                          \n");
      out.write("\n");
      out.write("                                    <br>\n");
      out.write("\n");
      out.write("                                </td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <form action=\"AddTOStock\" method=\"post\">\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h3 class=\"page-header\"> Add Product To Stock Form</h3>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-body\"> \n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label>Bar Code :</label> \n");
      out.write("                                        <input required type=\"text\"  class=\"form-control\" placeholder=\"Bar Code\" name=\"barcode\" id=\"barcode\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label>Qty :</label> \n");
      out.write("                                        <input required type=\"number\" min=\"0\"  class=\"form-control\" placeholder=\"Qty\" name=\"qty\" id=\"qty\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label>Selling Price :</label> \n");
      out.write("                                        <input required type=\"number\" step=\"0.01\" class=\"form-control\" placeholder=\"Selling Price\" name=\"sellingprice\" id=\"sellingprice\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-footer\">\n");
      out.write("                                    <div class=\"form-inline col-md-offset-10\">\n");
      out.write("                                        <input type=\"hidden\" name=\"product\" value=\"");
      out.print( product2.getIdProduct());
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" name=\"submited\" class=\"btn btn-primary\" id=\"save\" value=\"Save\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                        }


                    
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

           session1.close();
        
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
