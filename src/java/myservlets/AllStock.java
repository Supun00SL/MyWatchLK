/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Product;
import pojos.Stock;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AllStock", urlPatterns = {"/AllStock"})
public class AllStock extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = new classes.SessionConect().testConnection();
        try {
            String type = request.getParameter("type");
            String value = request.getParameter("value");
            
            System.out.println("type :"+type);

            Criteria productCriteria = session.createCriteria(pojos.Product.class);

            if (type.equals("name")) {
                
                productCriteria.add(Restrictions.like("searchWord", "%" + value + "%"));
            } else if (type.equals("bar")) {
                productCriteria.add(Restrictions.like("itemCode", "%" + value + "%"));
            }

            out.print("<table class='table table-condensed'><tr>");
            out.print("<th>Image</th>");
            out.print("<th>Name</th>");
            out.print("<th>Item Code</th>");
            out.print("<th>Quantity</th>");
            out.print("<th>Selling Price</th>");
            out.print("<th>Final Price</th>");
            out.print("<th>Discount</th>");
            out.print("<th>Supplier</th>");
            out.print("</tr>");
            
            List<pojos.Product> products = productCriteria.list();
                     System.out.println("in0pro :"+value);
            if (!products.isEmpty()) {
                for (Product product : products) {
                    Criteria stockCriteria=session.createCriteria(pojos.Stock.class);
                    stockCriteria.add(Restrictions.eq("product", product));
                    
                    List<pojos.Stock> stocks=stockCriteria.list();
                    
                    if(!stocks.isEmpty()){
                        for (Stock stock : stocks) {
                            System.out.println("in1");
                            
                            out.print("<tr>");
                            out.print("<td><img src='" + product.getImage() + "' class='img-thumbnail' width='100' height='75'></td>");
                            out.print("<td>" + product.getSearchWord() + "</td>");
                            out.print("<td>" + stock.getBarcode() + "</td>");
                            out.print("<td>" + stock.getQty() + "</td>");
                            out.print("<td>" + stock.getSellingPrice() + "</td>");
                            out.print("<td>" + stock.getFinalPrice() + "</td>");
                            out.print("<td>" + stock.getDiscount() + "</td>");
                            out.print("<td>" + stock.getSupplier().getCompanyName() + "</td>");
                            out.print("</tr>");
                        }
                    }
                }
                out.print("</table>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
