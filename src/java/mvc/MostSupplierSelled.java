/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojos.InvoiceHasStock;
import pojos.Profit;
import pojos.Stock;
import pojos.Supplier;

/**
 *
 * @author Supun Madushanka
 */
public class MostSupplierSelled {

    public Vector GetData() {
        Session session = new classes.SessionConect().testConnection();
        Vector vector = new Vector();
        try {

            Criteria supplierCriteria = session.createCriteria(pojos.Supplier.class);

            List<pojos.Supplier> suppliers = supplierCriteria.list();

            if (!suppliers.isEmpty()) {
                for (Supplier supplier : suppliers) {
                    HashMap hashMap = new HashMap();

                    hashMap.put("supplier", supplier.getCompanyName());

                    int count = 0;
                    Set<pojos.Stock> stocks = supplier.getStocks();
                    for (Stock stock : stocks) {
                        Set<pojos.InvoiceHasStock> hasStocks = stock.getInvoiceHasStocks();
                        for (InvoiceHasStock invoiceHasStock : hasStocks) {
                            count += invoiceHasStock.getQty();
                        }
                    }

                    hashMap.put("count", count);

                    vector.add(hashMap);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session.close();
            return vector;
        }

    }
}
