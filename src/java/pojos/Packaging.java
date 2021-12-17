package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Packaging generated by hbm2java
 */
public class Packaging  implements java.io.Serializable {


     private Integer idPackaging;
     private String packagingType;
     private String packagingImage;
     private Set<Product> products = new HashSet<Product>(0);

    public Packaging() {
    }

    public Packaging(String packagingType, String packagingImage, Set<Product> products) {
       this.packagingType = packagingType;
       this.packagingImage = packagingImage;
       this.products = products;
    }
   
    public Integer getIdPackaging() {
        return this.idPackaging;
    }
    
    public void setIdPackaging(Integer idPackaging) {
        this.idPackaging = idPackaging;
    }
    public String getPackagingType() {
        return this.packagingType;
    }
    
    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }
    public String getPackagingImage() {
        return this.packagingImage;
    }
    
    public void setPackagingImage(String packagingImage) {
        this.packagingImage = packagingImage;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}

