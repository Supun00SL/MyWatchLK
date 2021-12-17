/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.CartHasStockModel;
import mvc.SessionCart;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import pojos.Cart;
import pojos.CartHasStock;
import pojos.Stock;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "LoginFromCart", urlPatterns = {"/LoginFromCart"})
public class LoginFromCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Session session = null;
        String status;
        try {
            PrintWriter out = response.getWriter();

            String username = request.getParameter("u");
            String password = request.getParameter("p");

            session = new classes.SessionConect().testConnection();
            Criteria ClientLoginCriteria = session.createCriteria(pojos.Clientlogin.class);

            Criterion uname = Restrictions.eq("username", username);
            Criterion pword = Restrictions.eq("password", password);

            LogicalExpression andEXP = Restrictions.and(uname, pword);

            ClientLoginCriteria.add(andEXP);

            List<pojos.Clientlogin> clientlogins = ClientLoginCriteria.list();

            if (!clientlogins.isEmpty()) {
                pojos.Clientlogin clientlogin = clientlogins.get(0);

                if (clientlogin.getLoginstatus().getLoginStatus().toLowerCase().equals("active")) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("client", clientlogin.getClient());

                    //save Cart Details
                    if (httpSession.getAttribute("cart") != null) {
                        SessionCart sessionCart = (SessionCart) httpSession.getAttribute("cart");
                        ArrayList<CartHasStockModel> cartHasStocks = sessionCart.getCart();

                        //Check client have Cart
                        Set<pojos.Cart> carts = clientlogin.getClient().getCarts();
                        pojos.Cart cart = null;
                        if (!carts.isEmpty()) {
                            for (Cart cart1 : carts) {
                                cart = cart1;
                            }

                            double tot = 0.0;
                            if (!cartHasStocks.isEmpty()) {
                                for (int i = 0; i < cartHasStocks.size(); i++) {
                                    CartHasStockModel cartHasStock = (CartHasStockModel) cartHasStocks.get(i);

                                    Criteria cartCriteria = session.createCriteria(pojos.CartHasStock.class);
                                    cartCriteria.add(Restrictions.eq("cart", cart));
                                    cartCriteria.add(Restrictions.eq("stock", (Stock) session.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid()))));
                                    List<pojos.CartHasStock> cartitems = cartCriteria.list();

                                    if (cartitems.isEmpty()) {
                                        pojos.CartHasStock cartHasStock1 = new CartHasStock();
                                        cartHasStock1.setCart(cart);
                                        cartHasStock1.setQty(cartHasStock.getQty());
                                        cartHasStock1.setStock((Stock) session.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid())));
                                        cartHasStock1.setTotal(cartHasStock.getTotal());

                                        session.save(cartHasStock1);

                                        tot += cartHasStock.getTotal();

                                    } else {
                                        pojos.CartHasStock cartHasStock1 = cartitems.get(0);
                                        cartHasStock1.setQty(cartHasStock1.getQty() + cartHasStock.getQty());
                                        cartHasStock1.setTotal(cartHasStock1.getTotal() + cartHasStock.getTotal());

                                        session.update(cartHasStock1);

                                        tot += cartHasStock.getTotal();
                                    }

                                    cart.setNetTotal(cart.getNetTotal() + tot);

                                    session.update(cart);

                                }
                            }
                        } else {
                            double tot = 0.0;
                            cart = new Cart();
                            cart.setClient(clientlogin.getClient());
                            cart.setNetTotal(0.0);

                            session.save(cart);

                            if (!cartHasStocks.isEmpty()) {
                                for (int i = 0; i < cartHasStocks.size(); i++) {
                                    CartHasStockModel cartHasStock = (CartHasStockModel) cartHasStocks.get(i);

                                    pojos.CartHasStock cartHasStock1 = new CartHasStock();
                                    cartHasStock1.setCart(cart);
                                    cartHasStock1.setQty(cartHasStock.getQty());
                                    cartHasStock1.setStock((Stock) session.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid())));
                                    cartHasStock1.setTotal(cartHasStock.getTotal());

                                    session.save(cartHasStock1);

                                    tot += cartHasStock.getTotal();
                                }
                            }
                            cart.setNetTotal(cart.getNetTotal() + tot);

                            session.update(cart);

                        }
                        Transaction t = session.beginTransaction();
                        t.commit();

                    }

                    if (httpSession.getAttribute("red1") != null) {
                        out.write("1");//redirect to cart checkout
                        httpSession.setAttribute("red1", null);
                    } else {
                        out.write("0");
                    }
                } else {
                    status = "Your Profile is Not Verified..........!";
                    out.write(status);
                }

            } else {
                status = "Your Entered Username or Password is Incorrect..........!";
                out.write(status);

            }

        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            session.flush();
            session.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
