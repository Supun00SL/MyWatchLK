package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0



/**
 * Clientprivilages generated by hbm2java
 */
public class Clientprivilages  implements java.io.Serializable {


     private Integer idClientPrivilages;
     private Interfaces interfaces;

    public Clientprivilages() {
    }

    public Clientprivilages(Interfaces interfaces) {
       this.interfaces = interfaces;
    }
   
    public Integer getIdClientPrivilages() {
        return this.idClientPrivilages;
    }
    
    public void setIdClientPrivilages(Integer idClientPrivilages) {
        this.idClientPrivilages = idClientPrivilages;
    }
    public Interfaces getInterfaces() {
        return this.interfaces;
    }
    
    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }




}


