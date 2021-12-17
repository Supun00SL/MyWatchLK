/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "SiteConfiguration", urlPatterns = {"/SiteConfiguration"})
public class SiteConfiguration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String status;
        HashMap<String, Object> hm = new HashMap<>();

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

                        hm.put("image", fp);

                    } else {
                        if (fileItem.getFieldName().equals("sitname")) {
                            hm.put("sitname", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("email")) {
                            hm.put("email", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("no")) {
                            hm.put("no", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("street")) {
                            hm.put("street", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("city")) {
                            hm.put("city", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("pcode")) {
                            hm.put("pcode", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("country")) {
                            hm.put("country", fileItem.getString());
                        }
                    }
                }

            }
            //if(action.toLowerCase().equals("save")){
            new mvc.SiteConfiguration().SaveSite(hm);
            response.sendRedirect("SiteConfiguration.jsp?statid=1");

            //}
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("SiteConfiguration.jsp?statid=2");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
