/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Sitedetails;

/**
 *
 * @author Supun Madushanka
 */
public class SiteConfiguration {

    public synchronized void SaveSite(final HashMap<String, Object> hm) {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria siteCriteria = session.createCriteria(pojos.Sitedetails.class);
            List<pojos.Sitedetails> sitedetailses = siteCriteria.list();
            if (!sitedetailses.isEmpty()) {
                pojos.Sitedetails sitedetails = sitedetailses.get(0);

                if (hm.get("image") != null) {
                    sitedetails.setLogo((String) hm.get("image"));
                }
                sitedetails.setSiteName((String) hm.get("sitname"));
                sitedetails.setEmail((String) hm.get("email"));
                sitedetails.setNo((String) hm.get("no"));
                sitedetails.setStreet((String) hm.get("street"));
                sitedetails.setCity((String) hm.get("city"));
                sitedetails.setPostalcode((String) hm.get("pcode"));
                sitedetails.setCountry((String) hm.get("country"));

                session.update(sitedetails);
            } else {
                pojos.Sitedetails sitedetails = new Sitedetails();

                if (hm.get("image") != null) {
                    sitedetails.setLogo((String) hm.get("image"));
                }
                sitedetails.setSiteName((String) hm.get("sitname"));
                sitedetails.setEmail((String) hm.get("email"));
                sitedetails.setNo((String) hm.get("no"));
                sitedetails.setStreet((String) hm.get("street"));
                sitedetails.setCity((String) hm.get("city"));
                sitedetails.setPostalcode((String) hm.get("pcode"));
                sitedetails.setCountry((String) hm.get("country"));

                session.save(sitedetails);

            }
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            session.close();
        }

    }

}
