package pojos;
// Generated Jul 27, 2017 7:58:58 AM by Hibernate Tools 3.6.0



/**
 * ClientHasRecoverquestion generated by hbm2java
 */
public class ClientHasRecoverquestion  implements java.io.Serializable {


     private Integer idClientHasRecoverQuestion;
     private Client client;
     private Recoverquestion recoverquestion;
     private String answer;

    public ClientHasRecoverquestion() {
    }

	
    public ClientHasRecoverquestion(Client client, Recoverquestion recoverquestion) {
        this.client = client;
        this.recoverquestion = recoverquestion;
    }
    public ClientHasRecoverquestion(Client client, Recoverquestion recoverquestion, String answer) {
       this.client = client;
       this.recoverquestion = recoverquestion;
       this.answer = answer;
    }
   
    public Integer getIdClientHasRecoverQuestion() {
        return this.idClientHasRecoverQuestion;
    }
    
    public void setIdClientHasRecoverQuestion(Integer idClientHasRecoverQuestion) {
        this.idClientHasRecoverQuestion = idClientHasRecoverQuestion;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Recoverquestion getRecoverquestion() {
        return this.recoverquestion;
    }
    
    public void setRecoverquestion(Recoverquestion recoverquestion) {
        this.recoverquestion = recoverquestion;
    }
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }




}

