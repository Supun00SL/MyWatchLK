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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "settofound", urlPatterns = {"/settofound"})
public class settofound extends HttpServlet {

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
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();

            if (request.getParameter("delid") != null) {
                pojos.Deliveryitem deliveryitem = (pojos.Deliveryitem) session.load(pojos.Deliveryitem.class, Integer.parseInt(request.getParameter("delid")));

                Criteria statusCriteria = session.createCriteria(pojos.Deliverystatus.class);
                statusCriteria.add(Restrictions.eq("deliveryStatus", "Delivered"));

                List<pojos.Deliverystatus> deliverystatuses = statusCriteria.list();

                if (!deliverystatuses.isEmpty()) {
                    pojos.Deliverystatus deliverystatus = deliverystatuses.get(0);
                    deliveryitem.setDeliverystatus(deliverystatus);
                    session.update(deliveryitem);

                    Transaction t = session.beginTransaction();
                    t.commit();
                    response.sendRedirect("CompleteOrders.jsp?id=0");
                }
            } else {
                response.sendRedirect("CompleteOrders.jsp?id=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
