/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "ClientSaveUpdate", urlPatterns = {"/ClientSaveUpdate"})
public class ClientSaveUpdate extends HttpServlet {

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
            HttpSession hs1 = request.getSession();
            
            String action = request.getParameter("submited");
            String status;
            HashMap<String, Object> hm = new HashMap<>();

            //check submit button value                
            switch (action.toLowerCase()) {
                case "save":
                    hm.put("type", "save");
                    break;
                case "update":
                    hm.put("type", "update");
                    break;
            }
            hm.put("fname", request.getParameter("fname"));
            hm.put("lname", request.getParameter("lname"));
            hm.put("email", request.getParameter("email"));
            hm.put("gender", request.getParameter("gender"));
            hm.put("mobileno", request.getParameter("mobileno"));
            hm.put("telephoneno", request.getParameter("telephone"));
            hm.put("addressno", request.getParameter("addressno"));
            hm.put("street1", request.getParameter("addressstreet1"));
            hm.put("street2", request.getParameter("addressstreet2"));
            hm.put("street3", request.getParameter("addressstreet3"));
            hm.put("username", request.getParameter("username"));
            hm.put("password", request.getParameter("reenterpassword"));
            
            hs1.setAttribute("ClientDetails", hm);

            //Check user Name Existing
            if (new mvc.ClientRegistration().checkClientAvailability(request.getParameter("username")) | action.toLowerCase().equals("update")) {
                status = "Please Choose another Username. This One is Already Exists..!";
                hs1.setAttribute("status", status);
                response.sendRedirect("clientRegistration.jsp");
            } else {
                //password Validation
                if (request.getParameter("password").equals(request.getParameter("reenterpassword"))) {
                    
                    if (action.toLowerCase().equals("save")) {
                        if (new mvc.ClientRegistration().ClientSave(hm)) {
                            
                            response.sendRedirect("clientLogin.jsp");
                        } else {
                            status = "Something went Wrong...! Not Saved..!";
                            hs1.setAttribute("status", status);
                            response.sendRedirect("clientRegistration.jsp");
                        }
                    } else if (action.toLowerCase().equals("update")) {
                        //
                        pojos.Client client = (pojos.Client) hs1.getAttribute("client");
                        
                        Session session = new classes.SessionConect().testConnection();
                        
                        pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());
                        
                        client1.setStreet1("supun");
                        
                        Transaction t = session.beginTransaction();
                        session.update(client1);
                        t.commit();
                    }
                    
                } else {
                    status = "Your Re Entered Password is Incorrect..! ";
                    hs1.setAttribute("status", status);
                    response.sendRedirect("clientRegistration.jsp");
                }
                
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
