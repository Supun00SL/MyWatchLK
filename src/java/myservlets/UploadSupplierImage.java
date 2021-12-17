/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "UploadSupplierImage", urlPatterns = {"/UploadSupplierImage"})
public class UploadSupplierImage extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("123");
        boolean mulitipartcontent = ServletFileUpload.isMultipartContent(request);
        System.out.println("multi:" + mulitipartcontent);
        try {
            if (mulitipartcontent) {
                FileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fif);
                List<FileItem> li = upload.parseRequest(request);
                System.out.println("li:" + li.size());
                for (FileItem fileItem : li) {
                    if (!fileItem.isFormField()) {

                        String fn = System.currentTimeMillis() + "_" + fileItem.getName();
                        String path = request.getServletContext().getRealPath("/");
                        path = path.replace("\\", "/");
                        String folder = "upimg/";
                        File f = new File(path + folder + fn);
                        fileItem.write(f);
                        String fp = folder + fn;

                        //hm.put("image", fp);
                        Session session = new classes.SessionConect().testConnection();
                        HttpSession hs = request.getSession();
                        pojos.Supplier supplier = (pojos.Supplier) hs.getAttribute("supplier");

                        if (supplier != null) {
                            pojos.Supplier supplier1=(pojos.Supplier) session.load(pojos.Supplier.class, supplier.getIdSupplier());
                            System.out.println("in");
                            supplier1.setSupplierlogo(fp);
                            session.update(supplier1);
                            Transaction t = session.beginTransaction();
                            t.commit();
                            response.sendRedirect("SupplierRegistration_Advanced.jsp");
                        } else {
                            response.sendRedirect("SupplierLogin.jsp");

                        }

                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("clientRegistration.jsp");
        }
     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
