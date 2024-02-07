package fr.sncf.d2d.colibri.colis.rest;

import java.util.UUID;

import fr.sncf.d2d.colibri.colis.models.Status;
import jakarta.validation.constraints.Email;

public class UpdateColisBody {
    // ajout des notBlank etc
    private String address;
    private String details;
    
    @Email
    private String email;

    private Status status; // changer en enum
    private UUID deliveryPersonId;

    
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(UUID deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }
    
}
