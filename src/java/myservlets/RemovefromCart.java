/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "RemovefromCart", urlPatterns = {"/RemovefromCart"})
public class RemovefromCart extends HttpServlet {

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
            int itemid = Integer.parseInt(request.getParameter("itemid"));
            
            pojos.CartHasStock cartHasStock = (pojos.CartHasStock) session.load(pojos.CartHasStock.class, itemid);
            pojos.Cart cart = cartHasStock.getCart();
            
            Double qty = cartHasStock.getQty();
            
            pojos.Stock stock = cartHasStock.getStock();
            stock.setQty(stock.getQty() + qty);
            
            session.update(stock);
            
            session.delete(cartHasStock);
            
            Set<pojos.CartHasStock> cartHasStocks = cart.getCartHasStocks();
            System.out.println("size :" + cartHasStocks.size());
            if (cartHasStocks.size() == 1) {
                session.delete(cart);
            }
            
            Transaction t = session.beginTransaction();
            t.commit();
            
            response.sendRedirect("ViewCart.jsp");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            session.flush();
            session.close();
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
