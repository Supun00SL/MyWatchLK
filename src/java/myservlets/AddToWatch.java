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
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.Watchlist;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddToWatch", urlPatterns = {"/AddToWatch"})
public class AddToWatch extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();

            pojos.Stock stock = (pojos.Stock) session.load(pojos.Stock.class, Integer.parseInt(request.getParameter("id")));

            HttpSession hs = request.getSession();
            pojos.Client client = (pojos.Client) hs.getAttribute("client");

            pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());

            Criteria watchlistCriteria = session.createCriteria(pojos.Watchlist.class);
            watchlistCriteria.add(Restrictions.eq("client", client1));
            watchlistCriteria.add(Restrictions.eq("stock", stock));

            List<pojos.Watchlist> watchlists = watchlistCriteria.list();

            if (watchlists.isEmpty()) {

                pojos.Watchlist watchlist = new Watchlist();
                watchlist.setClient(client1);
                watchlist.setStock(stock);

                session.save(watchlist);
                Transaction t = session.beginTransaction();
                t.commit();
                out.write("1");
            } else {
                out.write("1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.write("0");
        } finally {
            session.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
