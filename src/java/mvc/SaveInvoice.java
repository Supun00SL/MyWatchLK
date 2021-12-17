/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.CartHasStock;
import pojos.Deliveryitem;
import pojos.Invoice;
import pojos.InvoiceHasStock;

/**
 *
 * @author Supun Madushanka
 */
public class SaveInvoice {
    
    public synchronized pojos.Invoice SaveInvoice(DeliveryDetailsModel ddm,pojos.Client client){
        Session session=null;
        pojos.Invoice invoice=null;
        
        
        try {
            session=new classes.SessionConect().testConnection();
            
            pojos.Client client1=(pojos.Client) session.load(pojos.Client.class, client.getIdClient());
            
            Criteria cartCriteria=session.createCriteria(pojos.Cart.class);
            cartCriteria.add(Restrictions.eq("client", client1));
            
            List<pojos.Cart> carts=cartCriteria.list();
            
            if(!carts.isEmpty()){
                pojos.Cart cart=carts.get(0);
                
                invoice=new Invoice();
                
                invoice.setClient(client1);
                invoice.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                invoice.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(new Date())));
                invoice.setNetTotal(cart.getNetTotal());
                
                session.save(invoice);
                Set<pojos.CartHasStock> cartHasStocks=cart.getCartHasStocks();
                
                if(!cartHasStocks.isEmpty()){
                    for (CartHasStock cartHasStock : cartHasStocks) {
                        pojos.InvoiceHasStock invoiceHasStock=new InvoiceHasStock();
                        
                        invoiceHasStock.setInvoice(invoice);
                        invoiceHasStock.setQty(cartHasStock.getQty());
                        invoiceHasStock.setStock(cartHasStock.getStock());
                        invoiceHasStock.setTotal(cartHasStock.getTotal());
                        
                        session.save(invoiceHasStock);
                        
                        pojos.Deliveryitem deliveryitem=new Deliveryitem();
                        deliveryitem.setFname(ddm.getFname());
                        deliveryitem.setLname(ddm.getLname());
                        deliveryitem.setCity(ddm.getCity());
                        deliveryitem.setCountry(ddm.getCountry());
                        
                        pojos.Deliverystatus deliverystatus=(pojos.Deliverystatus) session.load(pojos.Deliverystatus.class, 1);
                        deliveryitem.setDeliverystatus(deliverystatus);
                        
                        deliveryitem.setDistrict(ddm.getDistrict());
                        deliveryitem.setInvoiceHasStock(invoiceHasStock);
                        deliveryitem.setMobile(ddm.getContact());
                        deliveryitem.setNo(ddm.getNo());
                        deliveryitem.setPostalCode(ddm.getPostalcode());
                        deliveryitem.setStreet(ddm.getStreet());
                        
                        session.save(deliveryitem);
                        
                        session.delete(cartHasStock);
                    }
                }
                session.delete(cart);
            }
            Transaction t=session.beginTransaction();
            t.commit();
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
           
            session.close();
            return invoice;
        }
    
    }
    
}
