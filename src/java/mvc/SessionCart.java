/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.List;
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
public class SessionCart {

    private ArrayList<CartHasStockModel> cr;

    public SessionCart() {
        cr = new ArrayList();
    }

    public ArrayList<CartHasStockModel> getCart() {
        return cr;
    }

    public void AddToCart(CartHasStockModel ci) {
        CartHasStockModel cartItem = null;
        int j = 0;
        for (int i = 0; i < cr.size(); i++) {
            cartItem = cr.get(i);
            if (cartItem.getCartHasStockid() == ci.getCartHasStockid()) {
                System.out.println("With Same Id : OLDQTY:" + cartItem.getQty() + " NewQTY:" + ci.getQty());
                ci.setCartHasStockid(ci.getCartHasStockid());
                ci.setQty((cartItem.getQty() + ci.getQty()));
                ci.setTotal((cartItem.getTotal() + ci.getTotal()));
                ci.setStockid(ci.getStockid());

                System.out.println("Set Details.. qty:" + ci.getQty());
                j = 1;
            }
        }
        System.out.println("asd qty:" + ci.getQty());
        if (j == 1) {
            cr.remove(cartItem);
            cr.add(ci);
            j = 0;
        } else {
            cr.add(ci);
        }
    }

    public void RemoveItem(int id) {
        for (int i = 0; i < cr.size(); i++) {
            CartHasStockModel cartItem = cr.get(i);
            if (cartItem.getCartHasStockid() == id) {
                cr.remove(i);
            }
        }
    }

    public void RemoveAllItem() {
        int x = cr.size();
        for (int i = 0; i < x; i++) {
            CartHasStockModel cartItem = cr.get(i);

        }
        cr = null;
    }

//    public synchronized void SaveSessionCartToTheDB(SessionCart cart, pojos.Client client) {
//
//        Session session = null;
//        try {
//            session = new classes.SessionConect().testConnection();
//            Transaction t = session.beginTransaction();
//
//            Criteria cartCriteria = session.createCriteria(pojos.Cart.class);
//            cartCriteria.add(Restrictions.eq("client", client));
//
//            List<pojos.Cart> carts = cartCriteria.list();
//            pojos.Cart cart1 = null;
//            if (!carts.isEmpty()) {
//                cart1 = carts.get(0);
//
//            } else {
//                cart1 = new Cart();
//                cart1.setClient(client);
//                cart1.setNetTotal(0.0);
//
//                session.save(cart);
//
//            }
//
//            ArrayList<pojos.CartHasStock> cartHasStocks = cart.getCart();
//
//            for (CartHasStock cartHasStock : cartHasStocks) {
//                Criteria productCriteria = session.createCriteria(pojos.CartHasStock.class);
//
//                productCriteria.add(Restrictions.eq("cart", cartHasStock.getCart()));
//                productCriteria.add(Restrictions.eq("stock", cartHasStock.getStock()));
//
//                List<pojos.CartHasStock> cartHasStocks1 = productCriteria.list();
//
//                if (cartHasStocks1.isEmpty()) {
//                    cartHasStock.setCart(cart1);
//
//                    pojos.Stock stock = cartHasStock.getStock();
//                    double allqty = stock.getQty();
//                    double newqty = (allqty - cartHasStock.getQty());
//                    stock.setQty(newqty);
//
//                    session.update(stock);
//
//                    pojos.Cart cart2 = cartHasStock.getCart();
//                    double oldvalue = cart2.getNetTotal();
//                    double newvalue = oldvalue + cartHasStock.getTotal();
//                    cart2.setNetTotal(newvalue);
//
//                    session.update(cart2);
//
//                    session.save(cartHasStock);
//
//                } else {
//                    pojos.CartHasStock cartHasStock1 = cartHasStocks1.get(0);
//
//                    double oldqty = cartHasStock1.getQty();
//                    double newqty = oldqty + cartHasStock.getQty();
//
//                    cartHasStock1.setQty(newqty);
//
//                    double newvalue = (cartHasStock1.getTotal() + cartHasStock.getTotal());
//
//                    cartHasStock1.setTotal(newvalue);
//
//                    pojos.Stock stock = cartHasStock.getStock();
//                    double allqty = stock.getQty();
//                    double newqty1 = (allqty - cartHasStock.getQty());
//                    stock.setQty(newqty1);
//
//                    session.update(stock);
//
//                    pojos.Cart cart2 = cartHasStock.getCart();
//                    double oldvalue = cart2.getNetTotal();
//                    double newvalue1 = oldvalue + cartHasStock.getTotal();
//                    cart2.setNetTotal(newvalue1);
//
//                    session.update(cart2);
//
//                    session.update(cartHasStock1);
//
//                }
//
//            }
//            t.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//
//    }

}
