/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Hibernate.HibernateLoginUser;
import Pojo.TblUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author M.Dani Setiawan
 */
public class DAOPizzaLoginUser {
    
    public List<TblUser> getBy(String uEmail, String uPass) {
        TblUser u = new TblUser();
        List<TblUser> user = new ArrayList();

        Transaction trans = null;
        Session session = HibernateLoginUser.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where email= :uEmail AND password= :uPass");
            query.setString("uEmail", uEmail);
            query.setString("uPass", uPass);
            u = (TblUser) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    
}
}
