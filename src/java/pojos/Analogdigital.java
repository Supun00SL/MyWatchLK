package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Analogdigital generated by hbm2java
 */
public class Analogdigital  implements java.io.Serializable {


     private Integer idAnalogDigital;
     private String analogDigital;
     private Set<Product> products = new HashSet<Product>(0);

    public Analogdigital() {
    }

    public Analogdigital(String analogDigital, Set<Product> products) {
       this.analogDigital = analogDigital;
       this.products = products;
    }
   
    public Integer getIdAnalogDigital() {
        return this.idAnalogDigital;
    }
    
    public void setIdAnalogDigital(Integer idAnalogDigital) {
        this.idAnalogDigital = idAnalogDigital;
    }
    public String getAnalogDigital() {
        return this.analogDigital;
    }
    
    public void setAnalogDigital(String analogDigital) {
        this.analogDigital = analogDigital;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}

