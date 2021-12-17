package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Comment generated by hbm2java
 */
public class Comment  implements java.io.Serializable {


     private Integer commentid;
     private Client client;
     private Stock stock;
     private String comment;
     private Date date;
     private Date time;

    public Comment() {
    }

	
    public Comment(Client client, Stock stock) {
        this.client = client;
        this.stock = stock;
    }
    public Comment(Client client, Stock stock, String comment, Date date, Date time) {
       this.client = client;
       this.stock = stock;
       this.comment = comment;
       this.date = date;
       this.time = time;
    }
   
    public Integer getCommentid() {
        return this.commentid;
    }
    
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Stock getStock() {
        return this.stock;
    }
    
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }




}


