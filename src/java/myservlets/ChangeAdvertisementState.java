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
@WebServlet(name = "ChangeAdvertisementState", urlPatterns = {"/ChangeAdvertisementState"})
public class ChangeAdvertisementState extends HttpServlet {

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
            String changeto = request.getParameter("changeto");

            int id = Integer.parseInt(request.getParameter("addid"));
            
            Criteria addCriteria = session.createCriteria(pojos.Advertisement.class);
            
            if (changeto.equals("active")) {
                addCriteria.add(Restrictions.eq("state", "active"));
                
                List<pojos.Advertisement> advertisements = addCriteria.list();
                if (!advertisements.isEmpty()) {
                    pojos.Advertisement advertisement = advertisements.get(0);
                    
                    advertisement.setState("inactive");
                    
                    session.update(advertisement);

                }
                   //dan eka active karanawa
                pojos.Advertisement advertisement1 = (pojos.Advertisement) session.load(pojos.Advertisement.class, id);

                advertisement1.setState("active");

                session.update(advertisement1);
            } else {
                //dan eka inactive karanawa
                pojos.Advertisement advertisement1 = (pojos.Advertisement) session.load(pojos.Advertisement.class, id);
                
                advertisement1.setState("inactive");
                
                session.update(advertisement1);
            }
            
            Transaction t = session.beginTransaction();
            t.commit();
            
            response.sendRedirect("AddNewAdvertisement.jsp");
            
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
