package fr.sncf.d2d.colibri.colis.responses;

public class MessagesResponses {
    private String message;

    public String MessageResponse(String message) {
        return this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
