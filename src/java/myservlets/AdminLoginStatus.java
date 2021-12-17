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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AdminLoginStatus", urlPatterns = {"/AdminLoginStatus"})
public class AdminLoginStatus extends HttpServlet {

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
        String status;
        try {
            PrintWriter out = response.getWriter();

            String username = request.getParameter("u");
            String password = request.getParameter("p");

            session = new classes.SessionConect().testConnection();
            Criteria AdminLoginCriteria = session.createCriteria(pojos.Adminlogin.class);

            Criterion uname = Restrictions.eq("adminUsername", username);
            Criterion pword = Restrictions.eq("adminPassword", password);

            LogicalExpression andEXP = Restrictions.and(uname, pword);

            AdminLoginCriteria.add(andEXP);

            List<pojos.Adminlogin> adminlogins = AdminLoginCriteria.list();

            if (!adminlogins.isEmpty()) {
                pojos.Adminlogin adminlogin = adminlogins.get(0);

                if (adminlogin.getLoginstatus().getLoginStatus().toLowerCase().equals("active")) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("admin", adminlogin.getAdminUsername());
                   

                    Cookie unameCookie = new Cookie("aus", username);
                    Cookie pwrdCookie = new Cookie("apw", password);

                    response.addCookie(unameCookie);
                    response.addCookie(pwrdCookie);
                }else{
                    status = "Your Profile is No Longer Access..........!";
                    out.write(status);
                }

            } else {
                status = "Your Entered Username or Password is Incorrect..........!";
                out.write(status);

            }

        } catch (Exception e) {
            throw new ServletException(e);
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
