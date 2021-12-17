/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author Supun Madushanka
 */
public class CartHasStockModel {

    private Integer cartHasStockid;
    private String stockid;
    private Double qty;
    private Double total;

    public Integer getCartHasStockid() {
        return cartHasStockid;
    }

    public void setCartHasStockid(Integer cartHasStockid) {
        this.cartHasStockid = cartHasStockid;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

}
