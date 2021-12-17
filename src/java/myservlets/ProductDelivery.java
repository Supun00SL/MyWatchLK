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
@WebServlet(name = "ProductDelivery", urlPatterns = {"/ProductDelivery"})
public class ProductDelivery extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();

            if (request.getParameter("delid") != null) {
                pojos.Deliveryitem deliveryitem = (pojos.Deliveryitem) session.load(pojos.Deliveryitem.class, Integer.parseInt(request.getParameter("delid")));

                Criteria statusCriteria = session.createCriteria(pojos.Deliverystatus.class);
                statusCriteria.add(Restrictions.eq("deliveryStatus", "Shipped"));

                List<pojos.Deliverystatus> deliverystatuses = statusCriteria.list();

                if (!deliverystatuses.isEmpty()) {
                    pojos.Deliverystatus deliverystatus = deliverystatuses.get(0);
                    deliveryitem.setDeliverystatus(deliverystatus);
                    session.update(deliveryitem);

                    Transaction t = session.beginTransaction();
                    t.commit();
                    response.sendRedirect("SupplierHome.jsp?id=0");
                }
            } else {
                response.sendRedirect("SupplierHome.jsp?id=1");
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
