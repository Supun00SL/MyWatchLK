/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author randika
 */
public class SessionConect {

    SessionFactory sf;
    Session s;

    public Session testConnection() {
        if (s == null) {
            s = pojos.session_pool_manager.getSessionFactory().openSession();
            return s;
        } else {
            return s;
        }
    }

}
