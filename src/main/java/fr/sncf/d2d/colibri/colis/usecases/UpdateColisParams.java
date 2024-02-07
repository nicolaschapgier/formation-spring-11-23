package fr.sncf.d2d.colibri.colis.usecases;

import java.util.UUID;

import fr.sncf.d2d.colibri.colis.models.Status;

public class UpdateColisParams {

    private UUID id;
  
    private String address;

    private String email;

    private String details;

    private UUID deliveryPersonId;

    private Status status;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public UUID getDeliveryPersonId() {
        return this.deliveryPersonId;
    }

    public void setDeliveryPersonId(UUID deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public UUID getId() {
      return id;
    }

    public void setId(UUID id) {
      this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
}
