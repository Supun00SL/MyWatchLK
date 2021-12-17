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
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.DeliveryDetailsModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.CartHasStock;
import pojos.Deliveryitem;
import pojos.Invoice;
import pojos.InvoiceHasStock;
import pojos.Mainaccount;
import pojos.Profit;
import pojos.Supplierpayment;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "PaymentInvoice", urlPatterns = {"/PaymentInvoice"})
public class PaymentInvoice extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = null;
        try {
            HttpSession hs = request.getSession();
            
            pojos.Client client = (pojos.Client) hs.getAttribute("client");
            DeliveryDetailsModel ddm = (DeliveryDetailsModel) hs.getAttribute("deldetails");

            //pojos.Invoice invoice = new mvc.SaveInvoice().SaveInvoice(ddm, client);
            pojos.Invoice invoice = null;
            
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();
            
            pojos.Client client1 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());
            
            Criteria cartCriteria = session.createCriteria(pojos.Cart.class);
            cartCriteria.add(Restrictions.eq("client", client1));
            
            List<pojos.Cart> carts = cartCriteria.list();
            
            if (!carts.isEmpty()) {
                pojos.Cart cart = carts.get(0);
                
                invoice = new Invoice();
                
                invoice.setClient(client1);
                invoice.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                invoice.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(new Date())));
                invoice.setNetTotal(cart.getNetTotal());
                
                session.save(invoice);

                //Client Points Hadanawa
                pojos.Client client2 = (pojos.Client) session.load(pojos.Client.class, client.getIdClient());
                if (cart.getNetTotal() < 1000) {
                    pojos.Clientpointalgo clientpointalgo = (pojos.Clientpointalgo) session.load(pojos.Clientpointalgo.class, 1);
                    client2.setPoints(client2.getPoints() + clientpointalgo.getPoints());
                    
                } else if (1000 <= cart.getNetTotal() & cart.getNetTotal() < 5000) {
                    pojos.Clientpointalgo clientpointalgo = (pojos.Clientpointalgo) session.load(pojos.Clientpointalgo.class, 2);
                    client2.setPoints(client2.getPoints() + clientpointalgo.getPoints());
                } else if (5000 <= cart.getNetTotal() & cart.getNetTotal() < 10000) {
                    pojos.Clientpointalgo clientpointalgo = (pojos.Clientpointalgo) session.load(pojos.Clientpointalgo.class, 3);
                    client2.setPoints(client2.getPoints() + clientpointalgo.getPoints());
                } else if (10000 < cart.getNetTotal()) {
                    pojos.Clientpointalgo clientpointalgo = (pojos.Clientpointalgo) session.load(pojos.Clientpointalgo.class, 4);
                    client2.setPoints(client2.getPoints() + clientpointalgo.getPoints());
                }
                
                session.update(client2);
                
                Set<pojos.CartHasStock> cartHasStocks = cart.getCartHasStocks();
                
                if (!cartHasStocks.isEmpty()) {
                    for (CartHasStock cartHasStock : cartHasStocks) {
                        pojos.InvoiceHasStock invoiceHasStock = new InvoiceHasStock();
                        
                        invoiceHasStock.setInvoice(invoice);
                        invoiceHasStock.setQty(cartHasStock.getQty());
                        invoiceHasStock.setStock(cartHasStock.getStock());
                        invoiceHasStock.setTotal(cartHasStock.getTotal());
                        
                        session.save(invoiceHasStock);

                        //save in Main Acounts
                        Criteria mainacctCriteria = session.createCriteria(pojos.Mainaccount.class);
                        List<pojos.Mainaccount> mainaccounts = mainacctCriteria.list();
                        
                        pojos.Mainaccount mainaccount = null;
                        if (mainaccounts.isEmpty()) {
                            mainaccount = new Mainaccount();
                            mainaccount.setMainAccount(cartHasStock.getTotal());
                            session.save(mainaccount);
                        } else {
                            mainaccount = mainaccounts.get(0);
                            mainaccount.setMainAccount(mainaccount.getMainAccount() + cartHasStock.getTotal());
                            session.update(mainaccount);
                        }

                        //supplier Payment
                        pojos.Supplierpayment supplierpayment = new Supplierpayment();
                        supplierpayment.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                        supplierpayment.setSupplier(cartHasStock.getStock().getSupplier());

                        //Owner Profit eka adu karanawa
                        Criteria ownerprofitCriteria = session.createCriteria(pojos.Ownerprofit.class);
                        List<pojos.Ownerprofit> ownerprofits = ownerprofitCriteria.list();
                        
                        double ownerpercentage = 0;
                        if (!ownerprofits.isEmpty()) {
                            pojos.Ownerprofit ownerprofit = ownerprofits.get(0);
                            ownerpercentage = ownerprofit.getOwnerProfit();
                        }
                        double supplierpaymentfinal = cartHasStock.getTotal() - ((cartHasStock.getTotal() * ownerpercentage) / 100);
                        double ownerpaymentfinal = (cartHasStock.getTotal() * ownerpercentage) / 100;
                        
                        supplierpayment.setSupplierPayment(supplierpaymentfinal);
                        
                        session.save(supplierpayment);

                        //owner profit eka ekathu karanwa
                        pojos.Profit profit = new Profit();
                        profit.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                        profit.setProfit(ownerpaymentfinal);
                        
                        session.save(profit);
                        
                        pojos.Deliveryitem deliveryitem = new Deliveryitem();
                        deliveryitem.setFname(ddm.getFname());
                        deliveryitem.setLname(ddm.getLname());
                        deliveryitem.setCity(ddm.getCity());
                        deliveryitem.setCountry(ddm.getCountry());
                        
                        pojos.Deliverystatus deliverystatus = (pojos.Deliverystatus) session.load(pojos.Deliverystatus.class, 1);
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
            
            HttpSession hs1 = request.getSession();
            
            pojos.Invoice invoice1 = (pojos.Invoice) session.load(pojos.Invoice.class, invoice.getIdInvoice());
            hs1.setAttribute("invoice", invoice1);
            
            System.out.println("invoice :" + invoice.getIdInvoice());
            
            response.sendRedirect("ViewInvoice.jsp");
            t.commit();
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
