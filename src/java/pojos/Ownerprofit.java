package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0



/**
 * Ownerprofit generated by hbm2java
 */
public class Ownerprofit  implements java.io.Serializable {


     private Integer idOwnerProfit;
     private Double ownerProfit;

    public Ownerprofit() {
    }

    public Ownerprofit(Double ownerProfit) {
       this.ownerProfit = ownerProfit;
    }
   
    public Integer getIdOwnerProfit() {
        return this.idOwnerProfit;
    }
    
    public void setIdOwnerProfit(Integer idOwnerProfit) {
        this.idOwnerProfit = idOwnerProfit;
    }
    public Double getOwnerProfit() {
        return this.ownerProfit;
    }
    
    public void setOwnerProfit(Double ownerProfit) {
        this.ownerProfit = ownerProfit;
    }




}


