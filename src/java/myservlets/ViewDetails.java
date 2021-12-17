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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "ViewDetails", urlPatterns = {"/ViewDetails"})
public class ViewDetails extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String proid=request.getParameter("item");  
        System.out.println("proid :"+proid);
        String productcode=(proid.split(":")[0]).trim();
        Session session=null;
        try {
            session=new classes.SessionConect().testConnection();
            Criteria productCriteria=session.createCriteria(pojos.Product.class);
            productCriteria.add(Restrictions.eq("itemCode", productcode));
            
            List<pojos.Product> products=productCriteria.list();
            
            if(!products.isEmpty()){
                pojos.Product product=products.get(0);
            
                 response.sendRedirect("AddToStock.jsp?id="+product.getIdProduct());
              
            
            }else{
                System.out.println("notset");
                response.sendRedirect("AddToStock.jsp");
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
         session.flush();
         session.close();
        }
        
        
       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
