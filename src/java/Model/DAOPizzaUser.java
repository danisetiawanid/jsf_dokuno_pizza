/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Hibernate.HibernateUtilUser;
import Model.DAOPizzaUser;
import Pojo.TblUser;

/**
 *
 * @author danisetiawanid
 */
public class DAOPizzaUser {
    public void deleteUser(int idP) {
        Transaction trans = null;
        Session session = HibernateUtilUser.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblUser plg = (TblUser) session.load(TblUser.class, new Integer (idP));
            session.delete(plg);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblUser> getbyId(int idP) {
        
        TblUser plg = new TblUser();
        List<TblUser> lPlg = new ArrayList();
        
        Transaction trans = null;
        Session session = HibernateUtilUser.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where id_user = :id");
            query.setInteger("id", idP);
            plg = (TblUser) query.uniqueResult();
            lPlg = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }        
        return lPlg;        
    }
    
    public List<TblUser> retrieveTblProduct() {
        
        List stud = new ArrayList();
        TblUser stud1 = new TblUser();
        Transaction trans = null;
        Session session = HibernateUtilUser.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_user");
            stud = query.list();
            stud.add(stud1.getFirstname());
            stud.add(stud1.getLastname());
            stud.add(stud1.getEmail());
            stud.add(stud1.getPassword());
            stud.add(stud1.getAddress());
            stud.add(stud1.getPhoneNumber());
            
            trans.commit();
        } catch (Exception e) {
            
        }
        return stud;
    }
    
    public void updateUser(TblUser plg) {
        Transaction trans = null;
        Session session = HibernateUtilUser.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(plg);
            trans.commit();
          
        } catch (Exception e) {
            
        }
    }
    
    public List<TblUser> retrieveKary(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtilUser.getSessionFactory().openSession();
        List listKry = new ArrayList();
        
        try{
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblUser");
            listKry = query.list();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            transObj.commit();
        }
        return listKry;
    }
    
        public void addUser(TblUser kry){
        Transaction trans = null;
        Session session = HibernateUtilUser.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            session.save(kry);
            trans.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
