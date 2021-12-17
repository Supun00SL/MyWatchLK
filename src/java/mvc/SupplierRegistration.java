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
import org.hibernate.criterion.Restrictions;
import pojos.Supplier;
import pojos.Supplierlogin;

/**
 *
 * @author Supun Madushanka
 */
public class SupplierRegistration {

    public synchronized boolean SupplierSaveData(final HashMap<String, Object> hm) {

        Session session = null;
        try {

            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            pojos.Supplier supplier = new Supplier();

            supplier.setCompanyName((String) hm.get("comname"));
            supplier.setGovRegistrationCode((String) hm.get("grccode"));
            supplier.setMobileno((String) hm.get("mobilenumber"));
            supplier.setTelephoneno((String) hm.get("telephonenumber"));
            supplier.setAddressno((String) hm.get("addressno"));
            supplier.setStreet1((String) hm.get("street1"));
            supplier.setStreet2((String) hm.get("street2"));
            supplier.setStreet3((String) hm.get("street3"));
            supplier.setEmail((String) hm.get("email"));

            Criteria userStatusCriteria = session.createCriteria(pojos.Userstatus.class);
            userStatusCriteria.add(Restrictions.eq("userStatus", "inactive"));
            List<pojos.Userstatus> userstatuses = userStatusCriteria.list();

            if (!userstatuses.isEmpty()) {
                pojos.Userstatus userstatus = userstatuses.get(0);
                supplier.setUserstatus(userstatus);
            }

            session.save(supplier);

            pojos.Supplierlogin supplierlogin = new Supplierlogin();
            supplierlogin.setUsername((String) hm.get("username"));
            supplierlogin.setPassword((String) hm.get("reenterpassword"));
            supplierlogin.setSupplier(supplier);

            Criteria LoginStatusCriteria = session.createCriteria(pojos.Loginstatus.class);
            LoginStatusCriteria.add(Restrictions.eq("loginStatus", "inactive"));
            List<pojos.Loginstatus> loginstatuses = LoginStatusCriteria.list();

            if (!loginstatuses.isEmpty()) {
                pojos.Loginstatus loginstatus = loginstatuses.get(0);
                supplierlogin.setLoginstatus(loginstatus);

            }

            session.save(supplierlogin);
            t.commit();
            
            return checkSupplierAvailability((String)hm.get("username"));

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
            
            return false;
        }

    }

    public synchronized boolean checkSupplierAvailability(final String username) {
        Session session1 = new classes.SessionConect().testConnection();

        try {
            Criteria supplierCriteria = session1.createCriteria(pojos.Supplierlogin.class);
            supplierCriteria.add(Restrictions.eq("username", username));
            List<pojos.Supplierlogin> supplierlogins = supplierCriteria.list();
            //return true if client is available
            return !supplierlogins.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session1.flush();
            session1.close();

        }
    }
}
