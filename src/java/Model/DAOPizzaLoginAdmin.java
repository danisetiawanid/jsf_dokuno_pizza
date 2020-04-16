/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Hibernate.HibernateLoginUser;
import Pojo.TblAdmin;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author M.Dani Setiawan
 */
public class DAOPizzaLoginAdmin {
     public List<TblAdmin> getBy(String uName, String uPass) {
        TblAdmin u = new TblAdmin();
        List<TblAdmin> user = new ArrayList();

        Transaction trans = null;
        Session session = HibernateLoginUser.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where username= :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            u = (TblAdmin) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    
}
}
