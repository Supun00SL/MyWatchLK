package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0



/**
 * SupplierHasDeliverydistrictHasStock generated by hbm2java
 */
public class SupplierHasDeliverydistrictHasStock  implements java.io.Serializable {


     private Integer supplierHasDeliveryDistrictHasStockid;
     private Stock stock;
     private SupplierHasDeliverydistrict supplierHasDeliverydistrict;

    public SupplierHasDeliverydistrictHasStock() {
    }

    public SupplierHasDeliverydistrictHasStock(Stock stock, SupplierHasDeliverydistrict supplierHasDeliverydistrict) {
       this.stock = stock;
       this.supplierHasDeliverydistrict = supplierHasDeliverydistrict;
    }
   
    public Integer getSupplierHasDeliveryDistrictHasStockid() {
        return this.supplierHasDeliveryDistrictHasStockid;
    }
    
    public void setSupplierHasDeliveryDistrictHasStockid(Integer supplierHasDeliveryDistrictHasStockid) {
        this.supplierHasDeliveryDistrictHasStockid = supplierHasDeliveryDistrictHasStockid;
    }
    public Stock getStock() {
        return this.stock;
    }
    
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public SupplierHasDeliverydistrict getSupplierHasDeliverydistrict() {
        return this.supplierHasDeliverydistrict;
    }
    
    public void setSupplierHasDeliverydistrict(SupplierHasDeliverydistrict supplierHasDeliverydistrict) {
        this.supplierHasDeliverydistrict = supplierHasDeliverydistrict;
    }




}


