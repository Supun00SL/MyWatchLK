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
@WebServlet(name = "ClientLoginStatus", urlPatterns = {"/ClientLoginStatus"})
public class ClientLoginStatus extends HttpServlet {

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
            String rem = request.getParameter("r");
            
            session = new classes.SessionConect().testConnection();
            Criteria ClientLoginCriteria = session.createCriteria(pojos.Clientlogin.class);
            
            Criterion uname = Restrictions.eq("username", username);
            Criterion pword = Restrictions.eq("password", password);
            
            LogicalExpression andEXP = Restrictions.and(uname, pword);
            
            ClientLoginCriteria.add(andEXP);
            
            List<pojos.Clientlogin> clientlogins = ClientLoginCriteria.list();
            
            if (!clientlogins.isEmpty()) {
                pojos.Clientlogin clientlogin = clientlogins.get(0);
                
                if (clientlogin.getLoginstatus().getLoginStatus().toLowerCase().equals("active")) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("client", clientlogin.getClient());
                    
                    System.out.println("rem :"+rem);
                    if (rem.equals("rem")) {
                        Cookie unameCookie = new Cookie("cus", username);
                        unameCookie.setMaxAge(60*60*24); 
                        response.addCookie(unameCookie);
                        
                    }
                    
                    HttpSession hs = request.getSession();
                    
                    if (hs.getAttribute("red1") != null) {
                        out.write("1");//redirect to cart checkout
                        hs.setAttribute("red1", null);
                    } else {
                        out.write("0");
                    }
                } else {
                    status = "Your Profile is Not Verified..........!";
                    out.write(status);
                }
                
            } else {
                status = "Your Entered Username or Password is Incorrect..........!";
                out.write(status);
                
            }
            
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
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
