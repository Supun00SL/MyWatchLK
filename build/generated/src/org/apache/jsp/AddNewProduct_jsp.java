package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class AddNewProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script type=\"text/javascript\" src=\"myjs/AddNewproduct.js\"></script>\n");
      out.write("\n");
      out.write("        ");

            Session session1 = new classes.SessionConect().testConnection();
        
      out.write("\n");
      out.write("        <title>Add New Product</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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

                if (request.getParameter("statid") != null) {
                    if (request.getParameter("statid").equals("1")) {
            
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
      out.write("                    Something Went Wrong...!\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");

                    }

                }


            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form method=\"post\" enctype=\"multipart/form-data\" action=\"SaveUpdateProductDetails\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel panel-heading\">\n");
      out.write("                            <h3 class=\"page-header\"> Product Registration</h3>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"panel panel-body\">\n");
      out.write("                            <div class=\"col-md-12 text-center\" id=\"images\">\n");
      out.write("\n");
      out.write("                            </div><br>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Image :</label> \n");
      out.write("                                <input required type=\"file\" multiple=\"true\" class=\"form-control\" name=\"img\" id=\"img\" onchange=\"getImage(this)\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Item Code :</label> \n");
      out.write("                                <input readonly type=\"text\"  class=\"form-control\" name=\"itemcode\" id=\"itemcode\" value=\"");
      out.print( new mvc.AddNewProduct().ItemCode());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Product Name :</label> \n");
      out.write("                                <input required type=\"text\"  class=\"form-control\" placeholder=\"Product Name\" name=\"proname\" id=\"proname\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Brand Name :</label> \n");
      out.write("                                <!--<input required type=\"text\"  class=\"form-control\" placeholder=\"Brand Name\" name=\"brandname\" id=\"brandname\">-->\n");
      out.write("                                ");

                                    Criteria brandCriteria = session1.createCriteria(pojos.Brand.class);
                                    List<pojos.Brand> brands = brandCriteria.list();
                                    pojos.Brand brand = null;
                                
      out.write("\n");
      out.write("                                <input list=\"brands\" name=\"brand\" class=\"form-control\" id=\"brand\">\n");
      out.write("                                <datalist id=\"brands\">\n");
      out.write("                                    ");

                                        if (!brands.isEmpty()) {
                                            for (int i = 0; i < brands.size(); i++) {
                                                brand = brands.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( brand.getBrand());
      out.write("\" id=\"");
      out.print( brand.getIdBrand());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div>                       \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Target Gender :</label> \n");
      out.write("                                <select class=\"form-control\" name=\"targetgen\" id=\"targetgen\">\n");
      out.write("                                    ");

                                        Criteria genderCriteria = session1.createCriteria(pojos.Gendertype.class);
                                        List<pojos.Gendertype> genders = genderCriteria.list();

                                        if (!genders.isEmpty()) {
                                            for (pojos.Gendertype gender : genders) {
                                    
      out.write("\n");
      out.write("                                    <option>");
      out.print( gender.getGenderType());
      out.write("</option>\n");
      out.write("                                    ");

                                            }

                                        }


                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Min QTY :</label> \n");
      out.write("                                <input required type=\"number\" min=\"0\" value=\"1\"  class=\"form-control\" placeholder=\"Min QTY\" name=\"minqty\" id=\"minqty\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Product Status :</label> \n");
      out.write("                                <select class=\"form-control\" name=\"productstatus\" id=\"productstatus\">\n");
      out.write("                                    ");
                                        Criteria productstatusCriteria = session1.createCriteria(pojos.Productstatus.class);
                                        List<pojos.Productstatus> productstatuses = productstatusCriteria.list();

                                        if (!productstatuses.isEmpty()) {
                                            for (pojos.Productstatus productstatus : productstatuses) {
                                    
      out.write("\n");
      out.write("                                    <option>");
      out.print( productstatus.getProductStatus());
      out.write("</option>\n");
      out.write("                                    ");

                                            }

                                        }


                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Strap Type :</label> \n");
      out.write("                                ");
                                    Criteria straptypeCriteria = session1.createCriteria(pojos.Straptype.class);
                                    List<pojos.Straptype> straptypes = straptypeCriteria.list();
                                    pojos.Straptype straptype = null;
                                
      out.write("\n");
      out.write("                                <input list=\"straptypes\" name=\"straptype\" class=\"form-control\" id=\"straptype\">\n");
      out.write("                                <datalist id=\"straptypes\">\n");
      out.write("                                    ");

                                        if (!straptypes.isEmpty()) {
                                            for (int i = 0; i < straptypes.size(); i++) {
                                                straptype = straptypes.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( straptype.getStrapType());
      out.write("\" id=\"");
      out.print( straptype.getIdStrapType());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\" col-md-6\">\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel panel-heading\" >\n");
      out.write("                                        Case Details\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel panel-body\" >\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Case Type :</label>\n");
      out.write("                                            ");

                                                Criteria CaseTypeCriteria = session1.createCriteria(pojos.Casetype.class);
                                                List<pojos.Casetype> casetypes = CaseTypeCriteria.list();
                                                pojos.Casetype casetype = null;
                                            
      out.write("\n");
      out.write("                                            <input list=\"casetypes\" name=\"casetype\" class=\"form-control\" id=\"casetype\">\n");
      out.write("                                            <datalist id=\"casetypes\">\n");
      out.write("                                                ");

                                                    if (!casetypes.isEmpty()) {
                                                        for (int i = 0; i < casetypes.size(); i++) {
                                                            casetype = casetypes.get(i);
                                                
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( casetype.getCaseType());
      out.write("\" id=\"");
      out.print( casetype.getIdCaseType());
      out.write("\">\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                            </datalist>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Case Weight :</label> \n");
      out.write("                                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Case Weight\" name=\"caseweight\" id=\"caseweight\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Case Width :</label> \n");
      out.write("                                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Case Width\" name=\"casewidth\" id=\"casewidth\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Case Height :</label> \n");
      out.write("                                            <input required type=\"text\"  class=\"form-control\" placeholder=\"Case Height\" name=\"caseheight\" id=\"caseheight\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\" col-md-6\">\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel panel-heading\" >\n");
      out.write("                                        Watch Color Details\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel panel-body\" >\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Main Color :</label> \n");
      out.write("                                            ");
                                    Criteria MainColorCriteria = session1.createCriteria(pojos.Maincolor.class);
                                                List<pojos.Maincolor> maincolors = MainColorCriteria.list();
                                                pojos.Maincolor maincolor = null;
                                            
      out.write("\n");
      out.write("                                            <input list=\"mcolors\" name=\"mcolor\" class=\"form-control\" id=\"mcolor\">\n");
      out.write("                                            <datalist id=\"mcolors\">\n");
      out.write("                                                ");

                                                    if (!maincolors.isEmpty()) {
                                                        for (int i = 0; i < maincolors.size(); i++) {
                                                            maincolor = maincolors.get(i);
                                                
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( maincolor.getColor());
      out.write("\" id=\"");
      out.print( maincolor.getIdMainColor());
      out.write("\">\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                            </datalist>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Strap Color :</label> \n");
      out.write("                                            ");

                                                Criteria strapcolorCriteria = session1.createCriteria(pojos.Strapcolor.class);
                                                List<pojos.Strapcolor> strapcolors = strapcolorCriteria.list();
                                                pojos.Strapcolor strapcolor = null;
                                            
      out.write("\n");
      out.write("                                            <input list=\"strapcolors\" name=\"strapcolor\" class=\"form-control\" id=\"strapcolor\">\n");
      out.write("                                            <datalist id=\"strapcolors\">\n");
      out.write("                                                ");

                                                    if (!strapcolors.isEmpty()) {
                                                        for (int i = 0; i < strapcolors.size(); i++) {
                                                            strapcolor = strapcolors.get(i);
                                                
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( strapcolor.getStrapColor());
      out.write("\" id=\"");
      out.print( strapcolor.getIdStrapColor());
      out.write("\">\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                            </datalist>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label>Dial Color :</label> \n");
      out.write("                                            ");

                                                Criteria dialcolorCriteria = session1.createCriteria(pojos.Dialcolor.class);
                                                List<pojos.Dialcolor> dialcolors = dialcolorCriteria.list();
                                                pojos.Dialcolor dialcolor = null;
                                            
      out.write("\n");
      out.write("                                            <input list=\"dialcolors\" name=\"dialcolor\" class=\"form-control\" id=\"dialcolor\">\n");
      out.write("                                            <datalist id=\"dialcolors\">\n");
      out.write("                                                ");

                                                    if (!dialcolors.isEmpty()) {
                                                        for (int i = 0; i < dialcolors.size(); i++) {
                                                            dialcolor = dialcolors.get(i);
                                                
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( dialcolor.getDialColor());
      out.write("\" id=\"");
      out.print( dialcolor.getIdDialColor());
      out.write("\">\n");
      out.write("                                                    ");

                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                            </datalist>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Movement :</label> \n");
      out.write("                                ");

                                    Criteria MovementCriteria = session1.createCriteria(pojos.Movement.class);
                                    List<pojos.Movement> movements = MovementCriteria.list();
                                    pojos.Movement movement = null;
                                
      out.write("\n");
      out.write("                                <input list=\"movements\" name=\"movement\" class=\"form-control\" id=\"movement\">\n");
      out.write("                                <datalist id=\"movements\">\n");
      out.write("                                    ");

                                        if (!movements.isEmpty()) {
                                            for (int i = 0; i < movements.size(); i++) {
                                                movement = movements.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( movement.getMovement());
      out.write("\" id=\"");
      out.print( movement.getIdmovement());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Grade :</label> \n");
      out.write("                                ");

                                    Criteria gradeCriteria = session1.createCriteria(pojos.Grade.class);
                                    List<pojos.Grade> grades = gradeCriteria.list();
                                    pojos.Grade grade = null;
                                
      out.write("\n");
      out.write("                                <input list=\"grades\" name=\"grade\" class=\"form-control\" id=\"grade\">\n");
      out.write("                                <datalist id=\"grades\">\n");
      out.write("                                    ");

                                        if (!grades.isEmpty()) {
                                            for (int i = 0; i < grades.size(); i++) {
                                                grade = grades.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( grade.getGrade());
      out.write("\" id=\"");
      out.print( grade.getIdGrade());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Age Limit :</label> \n");
      out.write("                                ");

                                    Criteria agelimitCriteria = session1.createCriteria(pojos.Agelimit.class);
                                    List<pojos.Agelimit> agelimits = agelimitCriteria.list();
                                    pojos.Agelimit agelimit = null;
                                
      out.write("\n");
      out.write("                                <input list=\"agelimits\" name=\"agelimit\" class=\"form-control\" id=\"agelimit\">\n");
      out.write("                                <datalist id=\"agelimits\">\n");
      out.write("                                    ");

                                        if (!agelimits.isEmpty()) {
                                            for (int i = 0; i < agelimits.size(); i++) {
                                                agelimit = agelimits.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( agelimit.getAgeLimit());
      out.write("\" id=\"");
      out.print( agelimit.getIdAgeLimit());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Water Resist :</label> \n");
      out.write("                                ");

                                    Criteria WaterResistCriteria = session1.createCriteria(pojos.Waterresistency.class);
                                    List<pojos.Waterresistency> waterresistencys = WaterResistCriteria.list();
                                    pojos.Waterresistency waterresistency = null;
                                
      out.write("\n");
      out.write("                                <input list=\"waterresistencys\" name=\"waterresistency\" class=\"form-control\" id=\"waterresistency\">\n");
      out.write("                                <datalist id=\"waterresistencys\">\n");
      out.write("                                    ");

                                        if (!waterresistencys.isEmpty()) {
                                            for (int i = 0; i < waterresistencys.size(); i++) {
                                                waterresistency = waterresistencys.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( waterresistency.getRate());
      out.write("\" id=\"");
      out.print( waterresistency.getIdWaterResistency());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Weight  :</label> \n");
      out.write("                                ");

                                    Criteria WeightCriteria = session1.createCriteria(pojos.Weight.class);
                                    List<pojos.Weight> weights = WeightCriteria.list();
                                    pojos.Weight weight = null;
                                
      out.write("\n");
      out.write("                                <input list=\"weights\" name=\"weight\" class=\"form-control\" id=\"weight\">\n");
      out.write("                                <datalist id=\"weights\">\n");
      out.write("                                    ");

                                        if (!weights.isEmpty()) {
                                            for (int i = 0; i < weights.size(); i++) {
                                                weight = weights.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( weight.getWeight());
      out.write("\" id=\"");
      out.print( weight.getIdWeight());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Watch Shape  :</label> \n");
      out.write("                                ");

                                    Criteria WatchshapeCriteria = session1.createCriteria(pojos.Watchshape.class);
                                    List<pojos.Watchshape> watchshapes = WatchshapeCriteria.list();
                                    pojos.Watchshape watchshape = null;
                                
      out.write("\n");
      out.write("                                <input list=\"watchshapes\" name=\"watchshape\" class=\"form-control\" id=\"watchshape\">\n");
      out.write("                                <datalist id=\"watchshapes\">\n");
      out.write("                                    ");

                                        if (!watchshapes.isEmpty()) {
                                            for (int i = 0; i < watchshapes.size(); i++) {
                                                watchshape = watchshapes.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( watchshape.getWatchShape());
      out.write("\" id=\"");
      out.print( watchshape.getIdWatchShape());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Packaging  :</label> \n");
      out.write("                                ");

                                    Criteria PackagingCriteria = session1.createCriteria(pojos.Packaging.class);
                                    List<pojos.Packaging> packagings = PackagingCriteria.list();
                                    pojos.Packaging packaging = null;
                                
      out.write("\n");
      out.write("                                <input list=\"packagings\" name=\"packaging\" class=\"form-control\" id=\"packaging\">\n");
      out.write("                                <datalist id=\"packagings\">\n");
      out.write("                                    ");

                                        if (!packagings.isEmpty()) {
                                            for (int i = 0; i < packagings.size(); i++) {
                                                packaging = packagings.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( packaging.getPackagingType());
      out.write("\" id=\"");
      out.print( packaging.getIdPackaging());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label>Watch Type :</label> \n");
      out.write("                                ");

                                    Criteria analogdigitalCriteria = session1.createCriteria(pojos.Analogdigital.class);
                                    List<pojos.Analogdigital> analogdigitals = analogdigitalCriteria.list();
                                    pojos.Analogdigital analogdigital = null;
                                
      out.write("\n");
      out.write("                                <input list=\"analogdigitals\" name=\"analogdigital\" class=\"form-control\" id=\"analogdigital\">\n");
      out.write("                                <datalist id=\"analogdigitals\">\n");
      out.write("                                    ");

                                        if (!analogdigitals.isEmpty()) {
                                            for (int i = 0; i < analogdigitals.size(); i++) {
                                                analogdigital = analogdigitals.get(i);
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( analogdigital.getAnalogDigital());
      out.write("\" id=\"");
      out.print( analogdigital.getIdAnalogDigital());
      out.write("\">\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\n");
      out.write("                                </datalist>\n");
      out.write("                            </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">\n");
      out.write("                            <div class=\"form-inline col-md-offset-10\">\n");
      out.write("                                <input type=\"submit\" name=\"submited\" multiple=\"true\" class=\"btn btn-primary\" id=\"save\" value=\"Save\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
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
