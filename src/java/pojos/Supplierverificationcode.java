package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0



/**
 * Supplierverificationcode generated by hbm2java
 */
public class Supplierverificationcode  implements java.io.Serializable {


     private Integer idSupplierVerificationCode;
     private Supplier supplier;
     private String code;
     private String codestatus;

    public Supplierverificationcode() {
    }

	
    public Supplierverificationcode(Supplier supplier) {
        this.supplier = supplier;
    }
    public Supplierverificationcode(Supplier supplier, String code, String codestatus) {
       this.supplier = supplier;
       this.code = code;
       this.codestatus = codestatus;
    }
   
    public Integer getIdSupplierVerificationCode() {
        return this.idSupplierVerificationCode;
    }
    
    public void setIdSupplierVerificationCode(Integer idSupplierVerificationCode) {
        this.idSupplierVerificationCode = idSupplierVerificationCode;
    }
    public Supplier getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getCodestatus() {
        return this.codestatus;
    }
    
    public void setCodestatus(String codestatus) {
        this.codestatus = codestatus;
    }




}


