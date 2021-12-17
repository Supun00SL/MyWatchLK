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
@WebServlet(name = "SupplierVerification", urlPatterns = {"/SupplierVerification"})
public class SupplierVerification extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            PrintWriter out = response.getWriter();
            String code = request.getParameter("uvcd");

            Session session = pojos.session_pool_manager.getSessionFactory().openSession();
            Criteria uvcdCriteria = session.createCriteria(pojos.Supplierverificationcode.class);
            System.out.println(code);
            uvcdCriteria.add(Restrictions.eq("code", code));
            List<pojos.Supplierverificationcode> supplierverificationcodes = uvcdCriteria.list();
            if (!supplierverificationcodes.isEmpty()) {
                pojos.Supplierverificationcode supplierverificationcode = supplierverificationcodes.get(0);
                System.out.println("usvc :" + supplierverificationcode.getCodestatus());
                if (supplierverificationcode.getCodestatus().equals("notverified")) {
                    supplierverificationcode.setCodestatus("verified");
                    session.saveOrUpdate(supplierverificationcode);

                    pojos.Supplier supplier = supplierverificationcode.getSupplier();

                    Criteria statusCriteria = session.createCriteria(pojos.Userstatus.class);
                    statusCriteria.add(Restrictions.eq("userStatus", "active"));
                    List<pojos.Userstatus> userstatuses = statusCriteria.list();

                    if (!userstatuses.isEmpty()) {
                        pojos.Userstatus userstatus = userstatuses.get(0);
                        supplier.setUserstatus(userstatus);
                    }

                    Criteria supplierloginCriteria = session.createCriteria(pojos.Supplierlogin.class);
                    supplierloginCriteria.add(Restrictions.eq("supplier", supplier));
                    List<pojos.Supplierlogin> supplierlogins = supplierloginCriteria.list();

                    if (supplierlogins.isEmpty()) {
                        pojos.Supplierlogin supplierlogin = supplierlogins.get(0);

                        Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
                        loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
                        List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

                        if (!loginstatuses.isEmpty()) {
                            pojos.Loginstatus loginstatus = loginstatuses.get(0);
                            supplierlogin.setLoginstatus(loginstatus);
                            session.saveOrUpdate(supplierlogin);
                        }
                    }
                    session.saveOrUpdate(supplier);

                    Transaction t = session.beginTransaction();
                    t.commit();
                    session.close();
                    response.sendRedirect("SupplierLogin.jsp");
                }
            } else {
                System.out.println("eliye");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            PrintWriter out = response.getWriter();
            String code = request.getParameter("uvcd");

            Session session = pojos.session_pool_manager.getSessionFactory().openSession();
            Criteria uvcdCriteria = session.createCriteria(pojos.Supplierverificationcode.class);
            System.out.println(code);
            uvcdCriteria.add(Restrictions.eq("code", code));
            List<pojos.Supplierverificationcode> supplierverificationcodes = uvcdCriteria.list();
            if (!supplierverificationcodes.isEmpty()) {
                pojos.Supplierverificationcode supplierverificationcode = supplierverificationcodes.get(0);
                System.out.println("usvc :" + supplierverificationcode.getCodestatus());
                if (supplierverificationcode.getCodestatus().equals("notverified")) {
                    supplierverificationcode.setCodestatus("verified");
                    session.saveOrUpdate(supplierverificationcode);

                    pojos.Supplier supplier = supplierverificationcode.getSupplier();

                    Criteria statusCriteria = session.createCriteria(pojos.Userstatus.class);
                    statusCriteria.add(Restrictions.eq("userStatus", "active"));
                    List<pojos.Userstatus> userstatuses = statusCriteria.list();

                    if (!userstatuses.isEmpty()) {
                        pojos.Userstatus userstatus = userstatuses.get(0);
                        supplier.setUserstatus(userstatus);
                    }

                    Criteria supplierloginCriteria = session.createCriteria(pojos.Supplierlogin.class);
                    supplierloginCriteria.add(Restrictions.eq("supplier", supplier));
                    List<pojos.Supplierlogin> supplierlogins = supplierloginCriteria.list();

                    if (supplierlogins.isEmpty()) {
                        pojos.Supplierlogin supplierlogin = supplierlogins.get(0);

                        Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
                        loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
                        List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

                        if (!loginstatuses.isEmpty()) {
                            pojos.Loginstatus loginstatus = loginstatuses.get(0);
                            supplierlogin.setLoginstatus(loginstatus);
                            session.saveOrUpdate(supplierlogin);
                        }
                    }
                    session.saveOrUpdate(supplier);

                    Transaction t = session.beginTransaction();
                    t.commit();
                    session.close();
                    response.sendRedirect("SupplierLogin.jsp");
                }
            } else {
                System.out.println("eliye");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
