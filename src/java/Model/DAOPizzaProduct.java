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
import Hibernate.HibernateUtilProduct;
import Model.DAOPizzaProduct;
import Pojo.TblProduct;

/**
 *
 * @author danisetiawanid
 */
public class DAOPizzaProduct {
    public void deleteProduct(int idP) {
        Transaction trans = null;
        Session session = HibernateUtilProduct.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblProduct plg = (TblProduct) session.load(TblProduct.class, new Integer (idP));
            session.delete(plg);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblProduct> getbyId(int idP) {
        
        TblProduct plg = new TblProduct();
        List<TblProduct> lPlg = new ArrayList();
        
        Transaction trans = null;
        Session session = HibernateUtilProduct.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblProduct where id_pizza = :id");
            query.setInteger("id", idP);
            plg = (TblProduct) query.uniqueResult();
            lPlg = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }        
        return lPlg;        
    }
    
    public List<TblProduct> retrieveTblProduct() {
        
        List stud = new ArrayList();
        TblProduct stud1 = new TblProduct();
        Transaction trans = null;
        Session session = HibernateUtilProduct.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from tbl_product");
            stud = query.list();
            stud.add(stud1.getPizzaName());
            stud.add(stud1.getStock());
            stud.add(stud1.getPrice());
            trans.commit();
        } catch (Exception e) {
            
        }
        return stud;
    }
    
    public void updateProduct(TblProduct plg) {
        Transaction trans = null;
        Session session = HibernateUtilProduct.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(plg);
            trans.commit();
          
        } catch (Exception e) {
            
        }
    }
    
    public List<TblProduct> retrieveKary(){
        Transaction transObj = null;
        Session sessionObj = HibernateUtilProduct.getSessionFactory().openSession();
        List listKry = new ArrayList();
        
        try{
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from TblProduct");
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
    
        public void addProduct(TblProduct kry){
        Transaction trans = null;
        Session session = HibernateUtilProduct.getSessionFactory().openSession();
        
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
