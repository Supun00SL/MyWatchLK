/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Profit;
import pojos.Supplierpayment;

/**
 *
 * @author Supun Madushanka
 */
public class SupplierProfitForChart {

    public Vector GetData(int suppid) {
        Session session = new classes.SessionConect().testConnection();
        Vector vector = new Vector();
        try {

            pojos.Supplier supplier = (pojos.Supplier) session.load(pojos.Supplier.class, suppid);

            Criteria profitCriteria = session.createCriteria(pojos.Supplierpayment.class);
            profitCriteria.add(Restrictions.eq("supplier", supplier));
            List<pojos.Supplierpayment> profits = profitCriteria.list();

            if (!profits.isEmpty()) {
                for (Supplierpayment supplierpayment : profits) {
                    HashMap hashMap = new HashMap();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    hashMap.put("date", dateFormat.format(supplierpayment.getDate()));
                    hashMap.put("profit", supplierpayment.getSupplierPayment());

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
