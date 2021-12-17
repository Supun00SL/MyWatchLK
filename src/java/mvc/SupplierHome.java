/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Supun Madushanka
 */
public class SupplierHome {
//     public String ReturnCartBadgeCount(pojos.Client client) {
//        Session session = null;
//        String badge = "";
//        try {
//            session = new classes.SessionConect().testConnection();
//
//            pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());
//            Criteria cartCriteria = session.createCriteria(pojos.Cart.class);
//            cartCriteria.add(Restrictions.eq("client", client1));
//
//            List<pojos.Cart> carts = cartCriteria.list();
//
//            if (!carts.isEmpty()) {
//                pojos.Cart cart = carts.get(0);
//                badge = cart.getCartHasStocks().size() + "";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//            return badge;
//        }
//    }
//    
//    public String ReturnWatchListBadgeCount(pojos.Client client) {
//        Session session = null;
//        String badge = "";
//        try {
//            session = new classes.SessionConect().testConnection();
//
//            pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());
//            
//            Set<pojos.Watchlist> watchlists=client1.getWatchlists();
//            if (!watchlists.isEmpty()) {
//                badge = watchlists.size() + "";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//            return badge;
//        }
//    }
}
