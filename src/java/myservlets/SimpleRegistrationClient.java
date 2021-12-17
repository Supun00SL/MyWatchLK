/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.CartHasStockModel;
import mvc.SessionCart;
import org.hibernate.Session;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "SimpleRegistrationClient", urlPatterns = {"/SimpleRegistrationClient"})
public class SimpleRegistrationClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {

            if (request.getParameter("password").equals(request.getParameter("reenterpassword"))) {
                if (new mvc.ClientRegistration().checkClientAvailability(request.getParameter("username"))) {
                    response.sendRedirect("index.jsp?stat=0");

                } else {
                    HashMap<String, Object> hm = new HashMap<>();
                    hm.put("fname", request.getParameter("fname"));
                    hm.put("lname", request.getParameter("lname"));
                    hm.put("email", request.getParameter("email"));
                    hm.put("username", request.getParameter("username"));
                    hm.put("password", request.getParameter("reenterpassword"));

                    HttpSession hs = request.getSession();
                    if (hs.getAttribute("cart") != null) {
                        SessionCart sessionCart = (SessionCart) hs.getAttribute("cart");
                        ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();
                        new mvc.SimpleRegistrationClient().SaveClient(hm, cartHasStocks);

                    } else {

                        new mvc.SimpleRegistrationClient().SaveClient(hm, null);
                    }

                    if (request.getParameter("red") != null) {
                        hs.setAttribute("red1", request.getParameter("red"));
                    }
                    response.sendRedirect("index.jsp?stat=2");

                }
            } else {
                response.sendRedirect("index.jsp?stat=1");
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
