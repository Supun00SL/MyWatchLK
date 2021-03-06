package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Gender generated by hbm2java
 */
public class Gender  implements java.io.Serializable {


     private Integer idGender;
     private String gender;
     private Set<Client> clients = new HashSet<Client>(0);

    public Gender() {
    }

    public Gender(String gender, Set<Client> clients) {
       this.gender = gender;
       this.clients = clients;
    }
   
    public Integer getIdGender() {
        return this.idGender;
    }
    
    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Set<Client> getClients() {
        return this.clients;
    }
    
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }




}


