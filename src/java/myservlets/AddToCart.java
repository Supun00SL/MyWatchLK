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
import mvc.CartHasStockModel;
import mvc.SessionCart;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.Cart;
import pojos.CartHasStock;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String qty = request.getParameter("qty");
        HttpSession hs = request.getSession();
        if (hs.getAttribute("client") != null) {
            Session session = null;
            try {
                session = new classes.SessionConect().testConnection();
                pojos.Stock stock = (pojos.Stock) session.load(pojos.Stock.class, Integer.parseInt(id));

                double qtyint = Double.parseDouble(qty);
                if (qtyint <= stock.getQty() & stock.getQty() != 0) {
                    pojos.Client client = (pojos.Client) hs.getAttribute("client");
                    Criteria UserCartCriteria = session.createCriteria(pojos.Cart.class);
                    UserCartCriteria.add(Restrictions.eq("client", client));

                    Transaction t = session.beginTransaction();

                    List<pojos.Cart> carts = UserCartCriteria.list();
                    if (!carts.isEmpty()) {
                        pojos.Cart cart = carts.get(0);

                        Criteria checkproductCriteria = session.createCriteria(pojos.CartHasStock.class);
                        checkproductCriteria.add(Restrictions.eq("cart", cart));
                        checkproductCriteria.add(Restrictions.eq("stock", stock));
                        List<pojos.CartHasStock> cartitems = checkproductCriteria.list();
                        double tot = 0;
                        if (cartitems.isEmpty()) {
                            pojos.CartHasStock cartHasStock = new CartHasStock();
                            cartHasStock.setCart(cart);
                            cartHasStock.setStock(stock);
                            cartHasStock.setQty(qtyint);

                            pojos.Stock stock1 = (pojos.Stock) session.load(pojos.Stock.class, cartHasStock.getStock().getIdStock());
                            double allQTY = stock.getQty();
                            stock1.setQty(allQTY - cartHasStock.getQty());
                            session.update(stock1);

                            tot = (stock.getFinalPrice() * qtyint);
                            cartHasStock.setTotal(tot);

                            session.save(cartHasStock);
                        } else {
                            pojos.CartHasStock cartHasStock = cartitems.get(0);
                            double qtyy = cartHasStock.getQty();

                            double newqty = qtyy + qtyint;

                            cartHasStock.setQty(newqty);

                            pojos.Stock stock1 = (pojos.Stock) session.load(pojos.Stock.class, cartHasStock.getStock().getIdStock());
                            double allQTY = stock1.getQty();

                            stock1.setQty(allQTY - qtyint);
                            session.update(stock1);

                            System.out.println("Cart Has Stock old qty :" + qtyy);
                            System.out.println("Cart Has Stock new qty :" + newqty);
                            System.out.println("stock old qty :" + allQTY);
                            System.out.println("adding qty :" + qtyint);
                            System.out.println("new qty :" + newqty);
                            System.out.println("------------------");

                            double oldtot = cartHasStock.getTotal();

                            double newTot = oldtot + (qtyint * cartHasStock.getStock().getFinalPrice());

                            cartHasStock.setTotal(newTot);
                            tot = (stock.getFinalPrice() * qtyint);

                            session.update(cartHasStock);

                        }

                        double netTotal = cart.getNetTotal();
                        double set = netTotal + tot;

                        cart.setNetTotal(set);

                        session.update(cart);

                    } else {
                        pojos.Cart cart = new Cart();
                        cart.setClient(client);
                        cart.setNetTotal(0.0);

                        session.save(cart);

                        pojos.CartHasStock cartHasStock = new CartHasStock();
                        cartHasStock.setCart(cart);
                        cartHasStock.setStock(stock);
                        cartHasStock.setQty(qtyint);

                        pojos.Stock stock1 = (pojos.Stock) session.load(pojos.Stock.class, stock.getIdStock());
                        double allQTY = stock1.getQty();
                        stock1.setQty(allQTY - cartHasStock.getQty());
                        session.update(stock1);

                        double tot = (stock.getFinalPrice() * qtyint);
                        cartHasStock.setTotal(tot);

                        session.save(cartHasStock);

                        cart.setNetTotal(tot);

                        session.update(cart);
                    }
                    t.commit();
                    out.write("1");

                } else {
                    out.write("0");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.flush();
                session.close();
            }

        } else {
            //out.write("Please Login 1st..!");
            Session session = null;
            try {
                session = new classes.SessionConect().testConnection();
                pojos.Stock stock = (pojos.Stock) session.load(pojos.Stock.class, Integer.parseInt(id));
                double qtyint = Double.parseDouble(qty);

                if (qtyint <= stock.getQty()) {
                    int chsid = 0;
                    CartHasStockModel cartHasStockModel = null;
                    SessionCart cart = null;
                    HttpSession httpSession = request.getSession();
                    if (httpSession.getAttribute("cart") == null) {
                        cart = new SessionCart();

                    } else {
                        cart = (SessionCart) httpSession.getAttribute("cart");
                        chsid = (cart.getCart().size());

                        for (CartHasStockModel cart1 : cart.getCart()) {
                            if (cart1.getStockid().equals(id)) {
                                cartHasStockModel = cart1;
                                System.out.println("same stock");
                                break;
                            }
                        }
                    }

                    if (cartHasStockModel != null) {
                        cartHasStockModel.setCartHasStockid(cartHasStockModel.getCartHasStockid());
                        cartHasStockModel.setQty(qtyint);
                        cartHasStockModel.setStockid(stock.getIdStock() + "");
                        cartHasStockModel.setTotal(qtyint * (stock.getFinalPrice()));

                        cart.AddToCart(cartHasStockModel);
                        System.out.println("Add time Cart Has Stock Model : QTY:" + cartHasStockModel.getQty());
                        httpSession.setAttribute("cart", cart);
                    } else {

                        cartHasStockModel = new CartHasStockModel();
                        // pojos.CartHasStock cartHasStock = new CartHasStock();
                        cartHasStockModel.setCartHasStockid(chsid);
                        cartHasStockModel.setQty(qtyint);
                        cartHasStockModel.setStockid(stock.getIdStock() + "");
                        cartHasStockModel.setTotal(qtyint * (stock.getFinalPrice()));

                        cart.AddToCart(cartHasStockModel);
                        httpSession.setAttribute("cart", cart);
                    }
                    out.write("1");

                } else {
                    out.write("0");
                }
            } catch (Exception e) {
                e.printStackTrace();;
            } finally {
                session.close();
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
