package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Brand generated by hbm2java
 */
public class Brand  implements java.io.Serializable {


     private Integer idBrand;
     private String brand;
     private Set<Product> products = new HashSet<Product>(0);

    public Brand() {
    }

    public Brand(String brand, Set<Product> products) {
       this.brand = brand;
       this.products = products;
    }
   
    public Integer getIdBrand() {
        return this.idBrand;
    }
    
    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}

