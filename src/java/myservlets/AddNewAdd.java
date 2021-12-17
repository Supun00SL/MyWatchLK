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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Advertisement;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "AddNewAdd", urlPatterns = {"/AddNewAdd"})
public class AddNewAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = new classes.SessionConect().testConnection();

        String stat = "1";
        pojos.Advertisement advertisement = new Advertisement();

        boolean mulitipartcontent = ServletFileUpload.isMultipartContent(request);
        try {
            if (mulitipartcontent) {
                FileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fif);
                List<FileItem> li = upload.parseRequest(request);
                for (FileItem fileItem : li) {
                    if (!fileItem.isFormField()) {

                        String fn = System.currentTimeMillis() + "_" + fileItem.getName();
                        String path = request.getServletContext().getRealPath("/");
                        path = path.replace("\\", "/");
                        String folder = "upimg/";
                        File f = new File(path + folder + fn);
                        fileItem.write(f);
                        String fp = folder + fn;

                        advertisement.setImage(fp);
                        System.out.println("fp :" + fp);

                    } else {
                        if (fileItem.getFieldName().equals("desc")) {
                            advertisement.setDescription(fileItem.getString());
                            System.out.println("desc :" + fileItem.getString());
                        }
                    }
                }

            }

            advertisement.setState("inactive");

            Transaction t = session.beginTransaction();
            session.save(advertisement);
            t.commit();

            response.sendRedirect("AddNewAdvertisement.jsp?stat=1");
        } catch (Exception e) {
            response.sendRedirect("AddNewAdvertisement.jsp?stat=0");
            e.printStackTrace();
        } finally {
            out.close();
            session.flush();
            session.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
