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
@WebServlet(name = "UploadClientImage", urlPatterns = {"/UploadClientImage"})
public class UploadClientImage extends HttpServlet {

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
                        pojos.Client client = (pojos.Client) hs.getAttribute("client");

                        if (client != null) {
                            pojos.Client client1=(pojos.Client) session.load(pojos.Client.class, client.getIdClient());
                            System.out.println("in");
                            client1.setImage(fp);
                            session.update(client1);
                            Transaction t = session.beginTransaction();
                            t.commit();
                            response.sendRedirect("clientRegistration.jsp");
                        } else {
                            response.sendRedirect("clientLogin.jsp");

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
