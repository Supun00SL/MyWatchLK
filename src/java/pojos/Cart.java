package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Cart generated by hbm2java
 */
public class Cart  implements java.io.Serializable {


     private Integer idCart;
     private Client client;
     private Double netTotal;
     private Set<CartHasStock> cartHasStocks = new HashSet<CartHasStock>(0);

    public Cart() {
    }

	
    public Cart(Client client) {
        this.client = client;
    }
    public Cart(Client client, Double netTotal, Set<CartHasStock> cartHasStocks) {
       this.client = client;
       this.netTotal = netTotal;
       this.cartHasStocks = cartHasStocks;
    }
   
    public Integer getIdCart() {
        return this.idCart;
    }
    
    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Double getNetTotal() {
        return this.netTotal;
    }
    
    public void setNetTotal(Double netTotal) {
        this.netTotal = netTotal;
    }
    public Set<CartHasStock> getCartHasStocks() {
        return this.cartHasStocks;
    }
    
    public void setCartHasStocks(Set<CartHasStock> cartHasStocks) {
        this.cartHasStocks = cartHasStocks;
    }




}


