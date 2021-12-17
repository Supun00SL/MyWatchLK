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

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "SupplierRegistration", urlPatterns = {"/SupplierRegistration"})
public class SupplierRegistration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String status = "";
        HashMap<String, Object> hm = new HashMap<>();

        hm.put("comname", request.getParameter("comname"));
        hm.put("grccode", request.getParameter("grccode"));
        hm.put("mobilenumber", request.getParameter("mobilenumber"));
        hm.put("telephonenumber", request.getParameter("telephonenumber"));
        hm.put("addressno", request.getParameter("addressno"));
        hm.put("street1", request.getParameter("street1"));
        hm.put("street2", request.getParameter("street2"));
        hm.put("street3", request.getParameter("street3"));
        hm.put("email", request.getParameter("email"));
        hm.put("username", request.getParameter("username"));
        hm.put("password", request.getParameter("password"));
        hm.put("reenterpassword", request.getParameter("reenterpassword"));

        HttpSession hs1 = request.getSession();
        hs1.setAttribute("SupplierDetails", hm);

        //Check user Name Existing
        if (new mvc.SupplierRegistration().checkSupplierAvailability(request.getParameter("username"))) {
            status = "Please Choose another Username. This One is Already Exists..!";
            hs1.setAttribute("status", status);
            response.sendRedirect("SupplierRegistration.jsp");

        } else {
            //password Validation
            if (request.getParameter("password").equals(request.getParameter("reenterpassword"))) {
                new mvc.SupplierRegistration().SupplierSaveData(hm);
                    status = "<a href='#' class='close' data-dismiss='alert' aria-label='close' id='a'>&times;</a>  Successfully Saved...!";
                    hs1.setAttribute("status", status);
                    response.sendRedirect("SupplierRegistration.jsp");
                
            } else {
                status = "<a href='#' class='close' data-dismiss='alert' aria-label='close' id='a'>&times;</a>Your Re Entered Password is Incorrect..! ";
                hs1.setAttribute("status", status);
                response.sendRedirect("SupplierRegistration.jsp");
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
