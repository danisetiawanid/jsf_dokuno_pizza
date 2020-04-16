package Pojo;
// Generated Oct 8, 2019 12:39:21 PM by Hibernate Tools 4.3.1

import java.util.List;
import Hibernate.HibernateUtilProduct;
import Model.DAOPizzaProduct;
import javax.faces.bean.ManagedBean;




/**
 * TblProduct generated by hbm2java
 */

@ManagedBean
public class TblProduct  implements java.io.Serializable {


     private Integer idPizza;
     private String pizzaName;
     private int stock;
     private int price;

    public TblProduct() {
    }

    public TblProduct(String pizzaName, int stock, int price) {
       this.pizzaName = pizzaName;
       this.stock = stock;
       this.price = price;
    }
   
    public Integer getIdPizza() {
        return this.idPizza;
    }
    
    public void setIdPizza(Integer idPizza) {
        this.idPizza = idPizza;
    }
    public String getPizzaName() {
        return this.pizzaName;
    }
    
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    
    public void delete(int idPizza) {
        DAOPizzaProduct kry = new DAOPizzaProduct();
        List<TblProduct>lPlg = kry.getbyId(idPizza);
        if (!lPlg.isEmpty()) {
            kry.deleteProduct(idPizza);
        }
    }
    
    public String getbyid(int idPizza2) {
        DAOPizzaProduct plg = new DAOPizzaProduct();

        List<TblProduct> lPlg = plg.getbyId(idPizza2);
        if (!lPlg.isEmpty()) {
            idPizza = lPlg.get(0).idPizza;
            pizzaName = lPlg.get(0).pizzaName;
            stock = lPlg.get(0).stock;
            price = lPlg.get(0).price;
            return "editpizza";
        }
//        errorU = true;
        return "editpizza";
    }
    
    public List<TblProduct> getallrecords() {
        DAOPizzaProduct plg = new DAOPizzaProduct();
        List<TblProduct> lPlg = plg.retrieveTblProduct();
         return lPlg;
    }
    
    public String update() {
        DAOPizzaProduct usr = new DAOPizzaProduct();
//        String id = idUser.toString();
        List<TblProduct>lPlg = usr.getbyId(idPizza);
        if (!lPlg.isEmpty()) {
//            sucU = true;
        usr.updateProduct(this);
        }
        return "list-pizza";
     
    }
    
    public List<TblProduct>getRec(){
        DAOPizzaProduct kry = new DAOPizzaProduct();
        List<TblProduct> lKry = kry.retrieveKary();
        return lKry;
    }
   
    public void delete1(int idPizza) {
        DAOPizzaProduct kry = new DAOPizzaProduct();
        List<TblProduct>lPlg = kry.getbyId(idPizza);
        if (!lPlg.isEmpty()) {
            kry.deleteProduct(idPizza);
        }
    }

    
        public void save(){
        DAOPizzaProduct kr = new DAOPizzaProduct();
        kr.addProduct(this);
    }


}


