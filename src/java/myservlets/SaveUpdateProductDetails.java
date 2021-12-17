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
@WebServlet(name = "SaveUpdateProductDetails", urlPatterns = {"/SaveUpdateProductDetails"})
public class SaveUpdateProductDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //String action = request.getParameter("submited");
        String status;
        HashMap<String, Object> hm = new HashMap<>();
        System.out.println("action :" + request.getParameter("submited"));
        //check submit button value                
//        switch (action.toLowerCase()) {
//            case "save":
//                hm.put("type", "save");
//                break;
//            case "update":
//                hm.put("type", "update");
//                break;
//        }

        boolean mulitipartcontent = ServletFileUpload.isMultipartContent(request);
        try {
            if (mulitipartcontent) {
                FileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fif);
                List<FileItem> li = upload.parseRequest(request);
                int i = 1;
                for (FileItem fileItem : li) {
                    if (!fileItem.isFormField()) {

                        String fn = System.currentTimeMillis() + "_" + fileItem.getName();
                        String path = request.getServletContext().getRealPath("/");
                        path = path.replace("\\", "/");
                        String folder = "upimg/";
                        File f = new File(path + folder + fn);
                        fileItem.write(f);
                        String fp = folder + fn;

                        if (i == 1) {
                            hm.put("image", fp);
                            System.out.println("in image");
                            i++;
                        } else if (i == 2) {
                            hm.put("image1", fp);
                            System.out.println("in image1");
                            i++;
                        } else if (i == 3) {
                            hm.put("image2", fp);
                            System.out.println("in image2");
                            i++;
                        }
                    } else {
                        if (fileItem.getFieldName().equals("itemcode")) {
                            hm.put("itemcode", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("proname")) {
                            hm.put("proname", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("brand")) {
                            hm.put("brandname", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("minqty")) {
                            hm.put("minqty", Double.parseDouble(fileItem.getString()));
                        } else if (fileItem.getFieldName().equals("productstatus")) {
                            hm.put("productstatus", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("targetgen")) {
                            hm.put("targetgen", fileItem.getString());
                        } else if (fileItem.getFieldName().equals("straptype")) {
                            hm.put("straptype", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("casetype")) {
                            hm.put("casetype", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("caseweight")) {
                            hm.put("caseweight", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("casewidth")) {
                            hm.put("casewidth", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("caseheight")) {
                            hm.put("caseheight", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("mcolor")) {
                            hm.put("mcolor", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("strapcolor")) {
                            hm.put("strapcolor", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("dialcolor")) {
                            hm.put("dialcolor", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("movement")) {
                            hm.put("movement", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("grade")) {
                            hm.put("grade", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("agelimit")) {
                            hm.put("agelimit", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("waterresistency")) {
                            hm.put("waterresistency", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("weight")) {
                            hm.put("weight", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("watchshape")) {
                            hm.put("watchshape", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("packaging")) {
                            hm.put("packaging", fileItem.getString());
                        }else if (fileItem.getFieldName().equals("analogdigital")) {
                            hm.put("analogdigital", fileItem.getString());
                        }
                    }
                }

            }
            //if(action.toLowerCase().equals("save")){
            new mvc.AddNewProduct().SaveProduct(hm);
            response.sendRedirect("AddNewProduct.jsp?statid=1");

            //}
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("AddNewProduct.jsp?statid=2");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
