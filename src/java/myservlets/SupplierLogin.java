/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "SupplierLogin", urlPatterns = {"/SupplierLogin"})
public class SupplierLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            Criteria SupplierCriteria = session.createCriteria(pojos.Supplierlogin.class);
            System.out.println(request.getParameter("username"));
            System.out.println(request.getParameter("password"));
            SupplierCriteria.add(Restrictions.eq("username", request.getParameter("username")));
            SupplierCriteria.add(Restrictions.eq("password", request.getParameter("password")));

            List<pojos.Supplierlogin> supplierlogins = SupplierCriteria.list();
            if (!supplierlogins.isEmpty()) {

                pojos.Supplierlogin supplierlogin = supplierlogins.get(0);
                System.out.println(supplierlogin.getSupplier().getUserstatus().getUserStatus());
                if (supplierlogin.getSupplier().getUserstatus().getUserStatus().equals("active")) {
                    HttpSession hs = request.getSession();
                    hs.setAttribute("supplier", supplierlogin.getSupplier());

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("SupplierHome.jsp");

                    response.setHeader("cache-control", "no-cache");//firefox
                    response.setHeader("cache-control", "no-store");//chroame
                    requestDispatcher.forward(request, response);

                } else {
                    response.sendRedirect("SupplierLogin.jsp?id=2");

                }

            } else {
                response.sendRedirect("SupplierLogin.jsp?id=1");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
