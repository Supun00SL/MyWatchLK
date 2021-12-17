/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Comment;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddComment", urlPatterns = {"/AddComment"})
public class AddComment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comments = request.getParameter("comment");
        String stock = request.getParameter("sto");
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            pojos.Comment comment = new Comment();

            HttpSession hs = request.getSession();
            if (hs.getAttribute("client") != null) {
                pojos.Client client = (pojos.Client) hs.getAttribute("client");

                pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());

                comment.setClient(client1);
                comment.setComment(comments);
                comment.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                comment.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(new Date())));

                pojos.Stock stock1 = (pojos.Stock) session.load(pojos.Stock.class, Integer.parseInt(stock));

                comment.setStock(stock1);

                session.save(comment);
                t.commit();
                response.sendRedirect("ViewOneProduct.jsp?ideka="+stock);

            } else {
                response.sendRedirect("clientLogin.jsp");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
