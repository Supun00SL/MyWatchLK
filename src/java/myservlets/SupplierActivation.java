/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Supplierverificationcode;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "SupplierActivation", urlPatterns = {"/SupplierActivation"})
public class SupplierActivation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();

            pojos.Supplier supplier = (pojos.Supplier) session.load(pojos.Supplier.class, Integer.parseInt(request.getParameter("supplierid")));

            if (supplier.getUserstatus().getIdUserStatus() == 2) {
                Set<pojos.Supplierverificationcode> s = supplier.getSupplierverificationcodes();

                if (s.isEmpty()) {
                    //send Verification

                    pojos.Supplierverificationcode supplierverificationcode = new Supplierverificationcode();

                    String code = new classes.CodeGEN().getCode();
                    
                    String url="http://localhost:8080/AJDES-Final/SupplierVerification?uvcd="+code;

                    supplierverificationcode.setCode(code);
                    supplierverificationcode.setCodestatus("notverified");
                    supplierverificationcode.setSupplier(supplier);

                    Transaction t = session.beginTransaction();
                    session.save(supplierverificationcode);
                    t.commit();

                    new myservlets.SendMail().sendMail2(supplier.getCompanyName(), supplier.getEmail(), url);
                    response.sendRedirect("AdminHome.jsp");

                }
            } else {
                //Deactivate user
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
