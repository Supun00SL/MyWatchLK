/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Product;
import pojos.Stock;
import pojos.SupplierHasDeliverydistrictHasStock;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddTOStock", urlPatterns = {"/AddTOStock"})
public class AddTOStock extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = null;
        try {
            HttpSession hs = request.getSession();
            session = new classes.SessionConect().testConnection();
            if (hs.getAttribute("supplier") != null) {
                pojos.Supplier supplier = (pojos.Supplier) hs.getAttribute("supplier");
                pojos.Supplier supplier1 = (pojos.Supplier) session.load(pojos.Supplier.class, supplier.getIdSupplier());

                if (Integer.parseInt(request.getParameter("qty")) > 0) {
                    if (Double.parseDouble(request.getParameter("sellingprice")) > 0) {

                        Transaction t = session.beginTransaction();

                        pojos.Stock stock = new Stock();

                        stock.setBarcode(request.getParameter("barcode"));
                        stock.setProduct((Product) session.load(pojos.Product.class, Integer.parseInt(request.getParameter("product"))));
                        stock.setQty(Double.parseDouble(request.getParameter("qty")));
                        stock.setDiscount(Double.parseDouble(request.getParameter("discount")));
                        stock.setSellingPrice(Double.parseDouble(request.getParameter("sellingprice")));
                        double disprice = (double) Math.round((((Double.parseDouble(request.getParameter("sellingprice"))*(Double.parseDouble(request.getParameter("discount"))))/100) * 100) / 100);
                        double finalprice=Double.parseDouble(request.getParameter("sellingprice"))-disprice;
                        stock.setFinalPrice(finalprice);
                        stock.setSupplier(supplier1);
                        session.save(stock);
                        
                        Set<pojos.SupplierHasDeliverydistrict> deliverydistricts=supplier1.getSupplierHasDeliverydistricts();
                        int i=0;
                        for(pojos.SupplierHasDeliverydistrict deliverydistrict:deliverydistricts){
                            System.out.println(request.getParameter("dis_"+i));
                            if(request.getParameter("dis_"+i)!=null){
                             if(request.getParameter("dis_"+i).equals("on")){
                             
                                 
                             pojos.SupplierHasDeliverydistrictHasStock shdhs=new SupplierHasDeliverydistrictHasStock();
                             shdhs.setStock(stock);
                             shdhs.setSupplierHasDeliverydistrict(deliverydistrict);
                             session.save(shdhs);
                             }
                            }
                            i++;
                        }


                        t.commit();

                        response.sendRedirect("AddToStock.jsp?msg=3");

                    } else {
                        response.sendRedirect("AddToStock.jsp?msg=1");
                    }

                } else {
                    response.sendRedirect("AddToStock.jsp?msg=0");

                }
            }
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
