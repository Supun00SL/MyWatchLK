package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ViewOneProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/PageFooter.jsp");
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
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"myjs/ViewProduct.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .thumbnail img{\n");
      out.write("                width: 300px;\n");
      out.write("                height: 175px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>View One Product</title>\n");
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
      out.write("                    ");
                                        HttpSession hs = request.getSession();

                        if (hs.getAttribute("client") != null) {
                            pojos.Client client1 = (pojos.Client) hs.getAttribute("client");
                            pojos.Client client = (pojos.Client) session2.load(pojos.Client.class, client1.getIdClient());

                            Set<pojos.Clientlogin> clientlogins = client.getClientlogins();
                            if (!clientlogins.isEmpty()) {
                                for (pojos.Clientlogin clientlogin : clientlogins) {
                    
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
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
      out.write("                        <li><a  href=\"clientRegistration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( clientlogin.getUsername());
      out.write("</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    ");

                                break;
                            }
                        }
                    } else {
                    
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"well-sm\">\n");
      out.write("                                <form class=\"form-inline\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"I'm shopping for.....\">\n");
      out.write("                                    <button class=\"btn btn-info glyphicon glyphicon-search form-control\"></button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"ViewCart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"><span class=\"badge\"></span></span></a></li>\n");
      out.write("                        <!--<li><a  href=\"#m1\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>-->\n");
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
      out.write("\n");
      out.write("                    ");

                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <h3>Product Detail</h3>\n");
      out.write("            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                <div class=\"alert alert-success fade in\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
                    Session session1 = new classes.SessionConect().testConnection();
                pojos.Stock stock = null;
                try {
                    if (request.getParameter("ideka") != null) {
                        stock = (pojos.Stock) session1.load(pojos.Stock.class, Integer.parseInt(request.getParameter("ideka")));

                        if (stock != null) {

            
      out.write("\n");
      out.write("            <div class=\"col-md-12  well\">\n");
      out.write("\n");
      out.write("                <div class=\"col-md-4 text-center\">\n");
      out.write("                    <div class=\"magnify\">\n");
      out.write("                        <div class=\"large\"></div>\n");
      out.write("                        <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\" alt=\"1\" width=\"300\" height=\"200\" class=\"small\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <h3 class=\"text-capitalize\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</h3> \n");
      out.write("                    <h4 class=\"text-danger\" style=\"font-weight: bold;\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(stock.getFinalPrice()));
      out.write("</h4>\n");
      out.write("                    <del class=\"text-danger\"> RS ");
      out.print( classes.Common.VALUE_FORMAT.format(stock.getFinalPrice()));
      out.write("</del>\n");
      out.write("                    <h5> Available Quantity: ");
      out.print( stock.getQty());
      out.write("</h5>\n");
      out.write("                    ");

                        Criteria sellerCriteria = session1.createCriteria(pojos.SupplierHasStock.class);
                        sellerCriteria.add(Restrictions.eq("stock", stock));

                        List<pojos.SupplierHasStock> hasStocks = sellerCriteria.list();

                        if (!hasStocks.isEmpty()) {
                            pojos.SupplierHasStock hasStock = hasStocks.get(0);
                    
      out.write("\n");
      out.write("                    <h4 class=\"text-info\">Seller :");
      out.print( hasStock.getSupplier().getCompanyName());
      out.write("</h4>\n");
      out.write("                    ");

                        }

                    
      out.write("\n");
      out.write("                    <div class=\"col-md-12 well\">\n");
      out.write("                        <h5 class=\"col-md-4\">Qty: </h5>\n");
      out.write("                        <input type=\"number\" class=\" form-control col-md-6\" id=\"");
      out.print( stock.getIdStock());
      out.write("_qty\" value=\"1\" max=\"");
      out.print( stock.getQty());
      out.write("\" style=\"width: 50%;\"><br>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <button class=\"btn btn-info\" onclick=\"AddToCart1(");
      out.print( stock.getIdStock());
      out.write(")\">Add To Cart</button>\n");
      out.write("                        <button class=\"btn btn-danger\" onclick=\"View1(");
      out.print( stock.getIdStock());
      out.write(")\">Buy Now</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
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
      out.write("\n");
      out.write("            <div class=\"container col-md-6\">\n");
      out.write("                <div class=\"panel panel-success\">\n");
      out.write("                    <div class=\"panel panel-heading text-center\">\n");
      out.write("                        <h4>Leave a Comment</h4> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-body\">\n");
      out.write("                        <div class=\"text-center\">\n");
      out.write("                            <p> Please Leave comment For the Product. It is very helpful to those who willing by those..!</p>\n");
      out.write("                        </div>\n");
      out.write("                        <table class=\"table table-hover\">\n");
      out.write("\n");
      out.write("                            ");

                                Criteria commentCriteria = session2.createCriteria(pojos.Comment.class);

                                commentCriteria.add(Restrictions.eq("stock", stock));
                                commentCriteria.addOrder(Order.desc("date"));
                                commentCriteria.addOrder(Order.desc("time"));
                                commentCriteria.setMaxResults(5);

                                List<pojos.Comment> comments = commentCriteria.list();

                                if (!comments.isEmpty()) {
                                    for (pojos.Comment comment : comments) {


                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"col-md-4\"><p class=\"text-capitalize\"><img src=\"img/DSCF3798.JPG\" alt=\"1\" width=\"30\" height=\"30\" class=\"img-circle\">");
      out.print(" " + comment.getClient().getFname().concat(" " + comment.getClient().getLname()));
      out.write("</p></td><br>\n");
      out.write("                            <td class=\"text-primary\">");
      out.print( comment.getComment());
      out.write("</td>\n");
      out.write("\n");
      out.write("                            ");


                            
      out.write("\n");
      out.write("                            <td class=\"text-right col-md-2\"><p class=\"label label-info bottom bottom-right\">");
      out.print( new classes.Common().getdaysCount(new SimpleDateFormat("yyyy-MM-dd").format(comment.getDate()), new SimpleDateFormat("HH:mm:ss").format(comment.getTime())));
      out.write("</p></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            ");
                                    }
                                }


                            
      out.write("\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel panel-footer\">\n");
      out.write("                        <form action=\"AddComment\" method=\"post\">\n");
      out.write("                            <label>Enter Your Message Here :</label>\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print( stock.getIdStock());
      out.write("\" name=\"sto\">\n");
      out.write("                            <textarea required class=\"form-control\" rows=\"2\" name=\"comment\"></textarea><br>\n");
      out.write("                            <input type=\"submit\" value=\"Comment\" class=\"btn btn-success col-md-offset-10\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container col-md-6\">\n");
      out.write("                <div class=\"page-header\">\n");
      out.write("                    <h4>Photo Gallery</h4>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    ");

                        if (stock != null) {
                            if (stock.getProduct().getImage() != null) {
                    
      out.write("\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <a href=\"#m1\" data-toggle=\"modal\" class=\"thumbnail\">\n");
      out.write("                            <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"modal fade\" id=\"m1\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header text-capitalize\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</div>\n");
      out.write("                                    <!--Add here For loop for images-->\n");
      out.write("                                    <div class=\"modal-body text-center\">\n");
      out.write("                                        <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\" class=\"img-thumbnail\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <p>\n");
      out.write("                                            ");
      out.print( stock.getProduct().getSearchWord());
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                    ");

                    } else if (stock.getProduct().getImage1() != null) {
                    
      out.write("\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <a href=\"#m1\" data-toggle=\"modal\" class=\"thumbnail\">\n");
      out.write("                            <img src=\"");
      out.print( stock.getProduct().getImage1());
      out.write("\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"modal fade\" id=\"m1\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header text-capitalize\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</div>\n");
      out.write("                                    <!--Add here For loop for images-->\n");
      out.write("                                    <div class=\"modal-body text-center\">\n");
      out.write("                                        <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\" class=\"img-thumbnail\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <p>\n");
      out.write("                                            ");
      out.print( stock.getProduct().getSearchWord());
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                    } else if (stock.getProduct().getImage2() != null) {
                    
      out.write("\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <a href=\"#m1\" data-toggle=\"modal\" class=\"thumbnail\">\n");
      out.write("                            <img src=\"");
      out.print( stock.getProduct().getImage2());
      out.write("\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"modal fade\" id=\"m1\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header text-capitalize\">");
      out.print( stock.getProduct().getSearchWord());
      out.write("</div>\n");
      out.write("                                    <!--Add here For loop for images-->\n");
      out.write("                                    <div class=\"modal-body text-center\">\n");
      out.write("                                        <img src=\"");
      out.print( stock.getProduct().getImage());
      out.write("\" class=\"img-thumbnail\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <p>\n");
      out.write("                                            ");
      out.print( stock.getProduct().getSearchWord());
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                            }
                        } else {
                            response.sendRedirect("ProductView.jsp");
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"m2\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <form method=\"post\" action=\"SimpleRegistrationClient\">\n");
      out.write("                        <div class=\"modal-header text-capitalize\" style=\"font-size: x-large;\"><span class=\"glyphicon glyphicon-user\"></span>  Sign Up</div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div  id=\"stattop\" class=\"hidden\">\n");
      out.write("                                <div class=\"alert alert-success fade in row\" id=\"status\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\" id=\"a\">&times;</a>  \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>First Name :</label> \n");
      out.write("                                <input required type=\"text\"  class=\"form-control\" placeholder=\"First Name\" name=\"fname\" id=\"fname\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Last Name :</label> \n");
      out.write("                                <input type=\"text\" name=\"lname\" id=\"lname\" class=\"form-control\" placeholder=\"Last Name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-12\">\n");
      out.write("                                <label>Email :</label> \n");
      out.write("                                <input required type=\"text\"  name=\"email\" id=\"email\" class=\"form-control\" placeholder=\"Email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-12\">\n");
      out.write("                                <label>User Name :</label>\n");
      out.write("                                <input required type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"User Name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Password :</label> \n");
      out.write("                                <input required type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Re Enter Password :</label> \n");
      out.write("                                <input required type=\"password\" name=\"reenterpassword\" id=\"reenterpassword\" class=\"form-control\" placeholder=\"Re Enter Password\">\n");
      out.write("                            </div>  \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <input type=\"submit\" value=\"Save\" class=\"btn btn-success\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"text-center\">\n");
      out.write("\n");
      out.write("            <div class=\"well well-sm\" style=\"background-color: #333333;\">\n");
      out.write("                <p class=\"small\" style=\"color: #cccccc;\">\n");
      out.write("                    My Watch.LK is Web Site that amazing collection of watchers. While using this site, you agree to have read and accepted our terms of use, cookie and privacy policy. Copyright 2016-2017 by Refsnes Data.\n");
      out.write("                     \n");
      out.write("                </p>\n");
      out.write("                <p class=\"small\" style=\"color: #cccccc;\">\n");
      out.write("                     &#169 All Rights Reserved.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
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
