/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.Cart;
import pojos.CartHasStock;
import pojos.Client;
import pojos.Clientlogin;
import pojos.Stock;
import pojos.Userverificationcode;

/**
 *
 * @author Supun Madushanka
 */
public class SimpleRegistrationClient {
    
    public synchronized void SaveClient(final HashMap<String, Object> hm, final ArrayList arrayList) {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            
            pojos.Client client = new Client();
            
            client.setFname((String) hm.get("fname"));
            client.setLname((String) hm.get("lname"));
            client.setEmail((String) hm.get("email"));
            client.setPoints(0);
            
            Criteria statusCriteria = session.createCriteria(pojos.Userstatus.class);
            statusCriteria.add(Restrictions.eq("userStatus", "inactive"));
            List<pojos.Userstatus> userstatuses = statusCriteria.list();
            
            if (!userstatuses.isEmpty()) {
                pojos.Userstatus userstatus = userstatuses.get(0);
                client.setUserstatus(userstatus);
            }
            
            session.save(client);
            
            pojos.Clientlogin clientlogin = new Clientlogin();
            
            clientlogin.setClient(client);
            clientlogin.setUsername((String) hm.get("username"));
            clientlogin.setPassword((String) hm.get("password"));
            
            Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
            loginstatusCriteria.add(Restrictions.eq("loginStatus", "inactive"));
            List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();
            
            if (!loginstatuses.isEmpty()) {
                pojos.Loginstatus loginstatus = loginstatuses.get(0);
                clientlogin.setLoginstatus(loginstatus);
            }
            
            session.save(clientlogin);
            
            pojos.Userverificationcode userverificationcode = new Userverificationcode();
            
            String code = new classes.CodeGEN().getCode();
            
            String url = "http://localhost:8080/AJDES-Final/UserVerification?uvcd=" + code;
            
            userverificationcode.setClient(client);
            userverificationcode.setCode(code);
            userverificationcode.setCodestatus("notverified");
            
            session.save(userverificationcode);
            
            if (arrayList != null) {
                pojos.Cart cart = new Cart();
                
                cart.setClient(client);
                cart.setNetTotal(0.0);
                
                session.save(cart);
                double tot = 0.0;
                for (int i = 0; i < arrayList.size(); i++) {
                    CartHasStockModel cartHasStock = (CartHasStockModel) arrayList.get(i);
                    pojos.CartHasStock cartHasStock1 = new CartHasStock();
                    cartHasStock1.setCart(cart);
                    cartHasStock1.setQty(cartHasStock.getQty());
                    
                    pojos.Stock stock = (pojos.Stock) session.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid()));                    
                    stock.setQty(stock.getQty() - cartHasStock.getQty());
                    
                    session.update(stock);
                    
                    cartHasStock1.setStock((Stock) session.load(pojos.Stock.class, Integer.parseInt(cartHasStock.getStockid())));
                    cartHasStock1.setTotal(cartHasStock.getTotal());
                    tot += cartHasStock.getTotal();
                    
                    session.save(cartHasStock1);
                    
                }
                cart.setNetTotal(tot);
                session.saveOrUpdate(cart);
            }
            
            Transaction t = session.beginTransaction();
            t.commit();
            
            new myservlets.SendMail().sendMail2(client.getFname() + " " + client.getLname(), client.getEmail(), url);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}
