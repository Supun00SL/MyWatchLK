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
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Deliverydistrict;
import pojos.SupplierHasDeliverydistrict;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddDistricts", urlPatterns = {"/AddDistricts"})
public class AddDistricts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            pojos.Deliverydistrict deliverydistrict = new Deliverydistrict();
            deliverydistrict.setDistrict(request.getParameter("district"));
            deliverydistrict.setTimeDurationMaxDays(Integer.parseInt(request.getParameter("max")));
            deliverydistrict.setTimeDurationMinDays(Integer.parseInt(request.getParameter("min")));

            session.save(deliverydistrict);

            pojos.SupplierHasDeliverydistrict deliverydistrict1 = new SupplierHasDeliverydistrict();
            deliverydistrict1.setDeliverydistrict(deliverydistrict);

            HttpSession hs1 = request.getSession();
            if (hs1.getAttribute("supplier") != null) {

                pojos.Supplier supplier = (pojos.Supplier) hs1.getAttribute("supplier");
                pojos.Supplier supplier1 = (pojos.Supplier) session.load(pojos.Supplier.class, supplier.getIdSupplier());

                deliverydistrict1.setSupplier(supplier1);
            }
            session.save(deliverydistrict1);
            Transaction t = session.beginTransaction();
            t.commit();
            response.sendRedirect("SupplierHome.jsp?delst=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("SupplierHome.jsp?delst=2");
        } finally {
            session.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
