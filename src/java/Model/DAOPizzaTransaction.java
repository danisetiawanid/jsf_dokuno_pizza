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
import Hibernate.HibernateUtilTransaction;
import Model.DAOPizzaTransaction;
import Pojo.TblTransaction;

/**
 *
 * @author danisetiawanid
 */
public class DAOPizzaTransaction {
   
    
    
    public List<TblTransaction> retrieveTblTransaction() {
        
        List stud = new ArrayList();
        TblTransaction stud1 = new TblTransaction();
        Transaction trans = null;
        Session session = HibernateUtilTransaction.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_transaction");
            stud = query.list();
            stud.add(stud1.getIdUser());
            stud.add(stud1.getIdPizzaProduct());
            stud.add(stud1.getName());
            stud.add(stud1.getPizzaName());
            stud.add(stud1.getPrice());
            stud.add(stud1.getQty());
            stud.add(stud1.getTotalPrice());
            stud.add(stud1.getAddress());
            stud.add(stud1.getDateOfPurchase());
            trans.commit();
        } catch (Exception e) {
            
        }
        return stud;
    }
    
    
    public List<TblTransaction> retrieveKary(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtilTransaction.getSessionFactory().openSession();
        List listKry = new ArrayList();
        
        try{
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblTransaction");
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
    
        public void addTransaction(TblTransaction kry){
        Transaction trans = null;
        Session session = HibernateUtilTransaction.getSessionFactory().openSession();
        
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
