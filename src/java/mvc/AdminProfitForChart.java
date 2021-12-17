/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojos.Profit;

/**
 *
 * @author Supun Madushanka
 */
public class AdminProfitForChart {

    public Vector GetData() {
        Session session = new classes.SessionConect().testConnection();
        Vector vector = new Vector();
        try {

            Criteria profitCriteria = session.createCriteria(pojos.Profit.class);

            List<pojos.Profit> profits = profitCriteria.list();

            if (!profits.isEmpty()) {
                for (Profit profit : profits) {
                    HashMap hashMap = new HashMap();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    hashMap.put("date", dateFormat.format(profit.getDate()));
                    hashMap.put("profit", profit.getProfit());

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
