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
@WebServlet(name = "UserVerification", urlPatterns = {"/UserVerification"})
public class UserVerification extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            String code = request.getParameter("uvcd");

            Session session = pojos.session_pool_manager.getSessionFactory().openSession();
            Criteria uvcdCriteria = session.createCriteria(pojos.Userverificationcode.class);
            System.out.println(code);
            uvcdCriteria.add(Restrictions.eq("code", code));
            List<pojos.Userverificationcode> userverificationcodes = uvcdCriteria.list();
            if (!userverificationcodes.isEmpty()) {
                pojos.Userverificationcode userverificationcode = userverificationcodes.get(0);
                System.out.println("usvc :" + userverificationcode.getCodestatus());
                if (userverificationcode.getCodestatus().equals("notverified")) {
                    userverificationcode.setCodestatus("verified");
                    session.saveOrUpdate(userverificationcode);

                    pojos.Client client = userverificationcode.getClient();

                    Criteria statusCriteria = session.createCriteria(pojos.Userstatus.class);
                    statusCriteria.add(Restrictions.eq("userStatus", "active"));
                    List<pojos.Userstatus> userstatuses = statusCriteria.list();

                    if (!userstatuses.isEmpty()) {
                        pojos.Userstatus userstatus = userstatuses.get(0);
                        client.setUserstatus(userstatus);
                    }

                    Criteria clientloginCriteria = session.createCriteria(pojos.Clientlogin.class);
                    clientloginCriteria.add(Restrictions.eq("client", client));
                    List<pojos.Clientlogin> clientlogins = clientloginCriteria.list();

                    if (!clientlogins.isEmpty()) {
                        pojos.Clientlogin clientlogin = clientlogins.get(0);

                        Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
                        loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
                        List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

                        if (!loginstatuses.isEmpty()) {
                            pojos.Loginstatus loginstatus = loginstatuses.get(0);
                            clientlogin.setLoginstatus(loginstatus);
                            session.saveOrUpdate(clientlogin);
                        }
                    }
                    session.saveOrUpdate(client);

                    Transaction t = session.beginTransaction();
                    t.commit();
                    session.close();
                    response.sendRedirect("clientLogin.jsp");
                }
            } else {
                System.out.println("eliye");
            }

        } catch (Exception e) {
            e.printStackTrace();

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
