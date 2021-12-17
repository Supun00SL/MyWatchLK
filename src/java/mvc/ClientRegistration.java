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
import pojos.Client;
import pojos.Clientlogin;

/**
 *
 * @author Supun Madushanka
 */
public class ClientRegistration {

    public synchronized boolean ClientSave(final HashMap<String, Object> hm) {

        Session session = new classes.SessionConect().testConnection();
        Transaction t = session.beginTransaction();
        try {
            //save Client
            pojos.Client client = new Client();

            client.setFname((String) hm.get("fname"));
            client.setLname((String) hm.get("lname"));
            client.setEmail((String) hm.get("email"));

            Criteria genderCriteria = session.createCriteria(pojos.Gender.class);
            genderCriteria.add(Restrictions.eq("gender", (String) hm.get("gender")));
            List<pojos.Gender> genders = genderCriteria.list();
            if (!genders.isEmpty()) {
                pojos.Gender gender = genders.get(0);
                client.setGender(gender);
            }

            client.setMobileno((String) hm.get("mobileno"));
            client.setTelephoneno((String) hm.get("telephoneno"));
            client.setAddressno((String) hm.get("addressno"));
            client.setStreet1((String) hm.get("street1"));
            client.setStreet2((String) hm.get("street2"));
            client.setStreet3((String) hm.get("street3"));

            Criteria userStatusCriteria = session.createCriteria(pojos.Userstatus.class);
            userStatusCriteria.add(Restrictions.eq("userStatus", "active"));
            List<pojos.Userstatus> userstatuses = userStatusCriteria.list();
            if (!userstatuses.isEmpty()) {
                pojos.Userstatus userstatus = userstatuses.get(0);
                client.setUserstatus(userstatus);
            }

            session.save(client);

            //save clientLogin
            pojos.Clientlogin clientlogin = new Clientlogin();

            clientlogin.setClient(client);
            clientlogin.setUsername((String) hm.get("username"));
            clientlogin.setPassword((String) hm.get("password"));

            Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
            loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
            List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

            if (!loginstatuses.isEmpty()) {
                pojos.Loginstatus loginstatus = loginstatuses.get(0);
                clientlogin.setLoginstatus(loginstatus);
            }

            session.save(clientlogin);
            t.commit();

            return checkClientAvailability((String) hm.get("username"));

        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
        }

    }

    public synchronized boolean ClientUpdate(final HashMap<String, Object> hm) {

        Session session = new classes.SessionConect().testConnection();
        Transaction t = session.beginTransaction();
        try {
            //update Client
            
            pojos.Client client = new Client();

            client.setFname((String) hm.get("fname"));
            client.setLname((String) hm.get("lname"));
            client.setEmail((String) hm.get("email"));

            Criteria genderCriteria = session.createCriteria(pojos.Gender.class);
            genderCriteria.add(Restrictions.eq("gender", (String) hm.get("gender")));
            List<pojos.Gender> genders = genderCriteria.list();
            if (!genders.isEmpty()) {
                pojos.Gender gender = genders.get(0);
                client.setGender(gender);
            }

            client.setMobileno((String) hm.get("mobileno"));
            client.setTelephoneno((String) hm.get("telephoneno"));
            client.setAddressno((String) hm.get("addressno"));
            client.setStreet1((String) hm.get("street1"));
            client.setStreet2((String) hm.get("street2"));
            client.setStreet3((String) hm.get("street3"));

            Criteria userStatusCriteria = session.createCriteria(pojos.Userstatus.class);
            userStatusCriteria.add(Restrictions.eq("userStatus", "active"));
            List<pojos.Userstatus> userstatuses = userStatusCriteria.list();
            if (!userstatuses.isEmpty()) {
                pojos.Userstatus userstatus = userstatuses.get(0);
                client.setUserstatus(userstatus);
            }

            session.save(client);

            //save clientLogin
            pojos.Clientlogin clientlogin = new Clientlogin();

            clientlogin.setClient(client);
            clientlogin.setUsername((String) hm.get("username"));
            clientlogin.setPassword((String) hm.get("password"));

            Criteria loginstatusCriteria = session.createCriteria(pojos.Loginstatus.class);
            loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
            List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

            if (!loginstatuses.isEmpty()) {
                pojos.Loginstatus loginstatus = loginstatuses.get(0);
                clientlogin.setLoginstatus(loginstatus);
            }

            session.save(clientlogin);
            t.commit();
            return checkClientAvailability((String) hm.get("username"));

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
            return false;
        }

    }

    public synchronized boolean checkClientAvailability(final String username) {
        Session session1 = new classes.SessionConect().testConnection();

        try {
            Criteria clientCriteria = session1.createCriteria(pojos.Clientlogin.class);
            clientCriteria.add(Restrictions.eq("username", username));

            Criteria loginstatusCriteria = session1.createCriteria(pojos.Loginstatus.class);
            loginstatusCriteria.add(Restrictions.eq("loginStatus", "active"));
            List<pojos.Loginstatus> loginstatuses = loginstatusCriteria.list();

            if (!loginstatuses.isEmpty()) {
                pojos.Loginstatus loginstatus = loginstatuses.get(0);
                clientCriteria.add(Restrictions.eq("loginstatus", loginstatus));

            }

            List<pojos.Clientlogin> clientlogins = clientCriteria.list();
            //return true if client is available
            return !clientlogins.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session1.flush();
            session1.close();

        }
    }
}
