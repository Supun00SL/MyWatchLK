package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.Criteria;
import java.util.Set;
import org.hibernate.Session;

public final class SupplierProfit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">      \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/animate.css\">      \n");
      out.write("        <script  type=\"text/javascript\" src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script  type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <title>Supplier Profit</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"charteka()\">\n");
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
      out.write("                        <li><a href=\"SupplierHome.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"AddNewProduct.jsp\">Add New Product</a></li>\n");
      out.write("                        <li><a href=\"AddToStock.jsp\">Add To Stock</a></li> \n");
      out.write("                        <li><a href=\"AllStock_Sup.jsp\">Stock</a></li> \n");
      out.write("                        <li  class=\"active\"><a href=\"SupplierProfit.jsp\">Supplier Profit</a></li> \n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
                            HttpSession hs = request.getSession();

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


                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("                    \n");
      out.write("                     <div class=\"container-fluid\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h3>Supplier Profit</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <canvas id=\"myChart\" width=\"100\" height=\"100\"></canvas>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"well well-lg col-lg-6\" style=\"background-color: #00cc66; color: #ffffff;\">\n");
      out.write("                <div><h4>Your Profit is,</h4></div>\n");
      out.write("                <hr>\n");
      out.write("\n");
      out.write("                ");
                    Session session1 = new classes.SessionConect().testConnection();
                    double profit = 0.0;
                    Criteria profitCriteria = session1.createCriteria(pojos.Supplierpayment.class);

                    List<pojos.Supplierpayment> profits = profitCriteria.list();

                    if (!profits.isEmpty()) {
                        for (pojos.Supplierpayment profit1 : profits) {
                            profit += profit1.getSupplierPayment();
                        }
                    }

                
      out.write("\n");
      out.write("\n");
      out.write("                <h2>");
      out.print(profit );
      out.write(" LKR</h2>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
      out.write("        \n");
      out.write("         function charteka() {\n");
      out.write("\n");
      out.write("            CreateRequest();\n");
      out.write("            xhttp.onreadystatechange = function() {\n");
      out.write("\n");
      out.write("                if (xhttp.readyState === 4 & xhttp.status === 200) {\n");
      out.write("\n");
      out.write("                    var json = eval(' ( ' + xhttp.responseText + ' ) ');\n");
      out.write("                    var vec = json['data'];\n");
      out.write("\n");
      out.write("                    var labels = new Array();\n");
      out.write("                    var values = new Array();\n");
      out.write("                    for (var i = 0; i < vec.length; i++) {\n");
      out.write("                        var hm = vec[i];\n");
      out.write("\n");
      out.write("                        labels.push(hm['date']);\n");
      out.write("                        values.push(hm['profit']);\n");
      out.write("                    }\n");
      out.write("                    var ctx = document.getElementById(\"myChart\").getContext('2d');\n");
      out.write("                    var myChart = new Chart(ctx, {\n");
      out.write("                        type: 'line',\n");
      out.write("                        data: {\n");
      out.write("                            labels: labels,\n");
      out.write("                            datasets: [{\n");
      out.write("                                    label: '# of Profit',\n");
      out.write("                                    data: values,\n");
      out.write("                                    backgroundColor: [\n");
      out.write("                                        'rgba(255, 99, 132, 0.2)',\n");
      out.write("                                        'rgba(54, 162, 235, 0.2)',\n");
      out.write("                                        'rgba(255, 206, 86, 0.2)',\n");
      out.write("                                        'rgba(75, 192, 192, 0.2)',\n");
      out.write("                                        'rgba(153, 102, 255, 0.2)',\n");
      out.write("                                        'rgba(255, 159, 64, 0.2)'\n");
      out.write("                                    ],\n");
      out.write("                                    borderColor: [\n");
      out.write("                                        'rgba(255,99,132,1)',\n");
      out.write("                                        'rgba(54, 162, 235, 1)',\n");
      out.write("                                        'rgba(255, 206, 86, 1)',\n");
      out.write("                                        'rgba(75, 192, 192, 1)',\n");
      out.write("                                        'rgba(153, 102, 255, 1)',\n");
      out.write("                                        'rgba(255, 159, 64, 1)'\n");
      out.write("                                    ],\n");
      out.write("                                    borderWidth: 1\n");
      out.write("                                }]\n");
      out.write("                        },\n");
      out.write("                        options: {\n");
      out.write("                            scales: {\n");
      out.write("                                yAxes: [{\n");
      out.write("                                        ticks: {\n");
      out.write("                                            beginAtZero: true\n");
      out.write("                                        }\n");
      out.write("                                    }]\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xhttp.open(\"POST\", \"GetSupplierProfitToChart\", true);\n");
      out.write("            xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhttp.send();\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
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
