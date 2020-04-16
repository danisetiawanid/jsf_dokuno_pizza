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
import Hibernate.HibernateUtilSubcriber;
import Model.DAOPizzaSubcriber;
import Pojo.TblSubcriber;

/**
 *
 * @author danisetiawanid
 */
public class DAOPizzaSubcriber {
   
    
    
    public List<TblSubcriber> retrieveTblSubcriber() {
        
        List stud = new ArrayList();
        TblSubcriber stud1 = new TblSubcriber();
        Transaction trans = null;
        Session session = HibernateUtilSubcriber.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_subcriber");
            stud = query.list();
            stud.add(stud1.getEmail());
            stud.add(stud1.getPhoneNumber());
            trans.commit();
        } catch (Exception e) {
            
        }
        return stud;
    }
    
    
    public List<TblSubcriber> retrieveKary(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtilSubcriber.getSessionFactory().openSession();
        List listKry = new ArrayList();
        
        try{
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblSubcriber");
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
    
        public void addSubcriber(TblSubcriber kry){
        Transaction trans = null;
        Session session = HibernateUtilSubcriber.getSessionFactory().openSession();
        
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
