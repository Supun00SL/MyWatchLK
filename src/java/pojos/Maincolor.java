package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Maincolor generated by hbm2java
 */
public class Maincolor  implements java.io.Serializable {


     private Integer idMainColor;
     private String color;
     private Set<Product> products = new HashSet<Product>(0);

    public Maincolor() {
    }

    public Maincolor(String color, Set<Product> products) {
       this.color = color;
       this.products = products;
    }
   
    public Integer getIdMainColor() {
        return this.idMainColor;
    }
    
    public void setIdMainColor(Integer idMainColor) {
        this.idMainColor = idMainColor;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


