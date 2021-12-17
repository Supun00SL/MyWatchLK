/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.DeliveryDetailsModel;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "CartCheckout", urlPatterns = {"/CartCheckout"})
public class CartCheckout extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            DeliveryDetailsModel ddm=new DeliveryDetailsModel();
            ddm.setFname(request.getParameter("fname"));
            ddm.setLname(request.getParameter("lname"));
            ddm.setContact(request.getParameter("contact"));
            ddm.setNo(request.getParameter("no"));
            ddm.setStreet(request.getParameter("street"));
            ddm.setCity(request.getParameter("city"));
            ddm.setDistrict(request.getParameter("district"));
            ddm.setPostalcode(request.getParameter("postalcode"));
            ddm.setCountry(request.getParameter("country"));
            
            HttpSession hs=request.getSession();
            hs.setAttribute("deldetails", ddm);
            
            response.sendRedirect("Invoice.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
