/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Invoice;
import pojos.InvoiceHasStock;

/**
 *
 * @author Supun Madushanka
 */
@WebServlet(name = "ClientInvoiceHistory_ForAdmin", urlPatterns = {"/ClientInvoiceHistory_ForAdmin"})
public class ClientInvoiceHistory_ForAdmin extends HttpServlet {

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
        try {
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


            Criteria invoiceCriteria = session.createCriteria(pojos.Invoice.class);

            if ((!startdate.equals("")) & (!enddate.equals(""))) {
                System.out.println("dekama null na");

                invoiceCriteria.add(Restrictions.between("date", dateFormat.parse(startdate), dateFormat.parse(enddate)));
            } else if (startdate.equals("") & enddate.equals("")) {
                System.out.println("dekama null");
            } else if ((!startdate.equals("")) & enddate.equals("")) {
                System.out.println("end date null");

                invoiceCriteria.add(Restrictions.ge("date", dateFormat.parse(startdate)));
            } else if (startdate.equals("") & (!enddate.equals(""))) {
                System.out.println("start date null");

                invoiceCriteria.add(Restrictions.le("date", dateFormat.parse(enddate)));
            }

            List<pojos.Invoice> invoices = invoiceCriteria.list();

            out.write("<table class='table table-condensed'>");
            out.write("<tr>");
            out.write("<th>Date</th>");
            out.write("<th>Time</th>");
            out.write("<th>Net Total</th>");
            out.write("<th></th>");
            out.write("<tr>");
            if (!invoices.isEmpty()) {
                for (int i = 0; i < invoices.size(); i++) {
                    pojos.Invoice invoice = invoices.get(i);
                    out.write("<tr>");
                    out.write("<td>" + dateFormat.format(invoice.getDate()) + "</td>");
                    out.write("<td>" + timeFormat.format(invoice.getTime()) + "</td>");
                    out.write("<td>" + invoice.getNetTotal() + "</td>");
                    out.write("<td><a href='#' data-target='#modalinvoice" + i + "' data-toggle='modal'>Invoice Details</a></td>");
                    out.write("<tr>");

                }
            }
            out.write("</table>");
            if (!invoices.isEmpty()) {
                for (int i = 0; i < invoices.size(); i++) {
                    pojos.Invoice invoice = invoices.get(i);
                    //Create Modal
                    out.write("<div class='modal' id='modalinvoice"+i+"'>");
                        out.write("<div class='modal-dialog'>");
                            out.write("<div class='modal-content'>");
                                out.write("<div class='modal-header'>");
                                    out.write("<button  class='close' data-dismiss='modal'>x</button>");
                                    out.write("<h4>Invoice Details</h4>");
                                out.write("</div>");
                                out.write("<div class='modal-body'>");
                                    out.write("<table class='table table-bordered'>");
                                        out.write("<tr>");
                                            out.write("<th>Product Image</th>");
                                            out.write("<th>Product</th>");
                                            out.write("<th>Qty</th>");
                                            out.write("<th>Sub Total</th>");
                                        out.write("</tr>");
                                        
                                        Set<pojos.InvoiceHasStock> hasStocks=invoice.getInvoiceHasStocks();
                                        for (InvoiceHasStock invoiceHasStock : hasStocks) {

                                        out.write("<tr>");
                                            out.write("<td><img src='"+invoiceHasStock.getStock().getProduct().getImage()+"' class='img-thumbnail' width='100' height='75'></td>");
                                            out.write("<td>"+invoiceHasStock.getStock().getProduct().getSearchWord()+"</td>");
                                            out.write("<td>"+invoiceHasStock.getQty()+"</td>");
                                            out.write("<td>"+invoiceHasStock.getTotal()+"</td>");
                                        out.write("</tr>");   
                                        }
                                        
                                        
                                    out.write("</table>");
                                out.write("</div>");
                            out.write("</div>");
                        out.write("</div>");
                    out.write("</div>");
                   

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
            out.close();
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
