package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Dialcolor generated by hbm2java
 */
public class Dialcolor  implements java.io.Serializable {


     private Integer idDialColor;
     private String dialColor;
     private Set<Product> products = new HashSet<Product>(0);

    public Dialcolor() {
    }

    public Dialcolor(String dialColor, Set<Product> products) {
       this.dialColor = dialColor;
       this.products = products;
    }
   
    public Integer getIdDialColor() {
        return this.idDialColor;
    }
    
    public void setIdDialColor(Integer idDialColor) {
        this.idDialColor = idDialColor;
    }
    public String getDialColor() {
        return this.dialColor;
    }
    
    public void setDialColor(String dialColor) {
        this.dialColor = dialColor;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


