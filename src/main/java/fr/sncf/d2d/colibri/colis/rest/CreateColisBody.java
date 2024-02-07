package fr.sncf.d2d.colibri.colis.rest;

import java.util.UUID;

import org.springframework.util.StringUtils;

import fr.sncf.d2d.colibri.colis.models.Status;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateColisBody {
    
    @NotBlank
    private String address;

    @Email
    private String email;

    private String details;

    private UUID deliveryPersonId;

    private Status status;

    @AssertTrue
    private boolean validateDetails(){
        return this.details == null || StringUtils.hasText(this.details);
    }

    @AssertTrue
    private boolean validateDeliveryPersonId(){
        return this.deliveryPersonId == null;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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

    @Override
    public String toString(){
        return String.format(
            "address=%s",
            this.address
        );
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
