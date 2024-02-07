package fr.sncf.d2d.colibri.colis.models;

import java.util.UUID;

public class Colis {

    private UUID id;
    
    private String address;

    private UUID deliveryPersonId;

    private String details;

    private String email;

    private Colis(UUID id, String address, UUID deliveryPersonId, String details, String email){
        this.id = id;
        this.address = address;
        this.deliveryPersonId = deliveryPersonId;
        this.details = details;
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public UUID getDeliveryPersonId() {
        return this.deliveryPersonId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeliveryPersonId(UUID deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return this.details;
    }

    public String getEmail() {
        return this.email;
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public static ColisBuilder builder(){
        return new ColisBuilder();
    }

    public static class ColisBuilder {

        private UUID id;

        private String address;

        private UUID deliveryPersonId;

        private String details;

        private String email;

        private ColisBuilder(){}

        public ColisBuilder id(UUID id){
            this.id = id;
            return this;
        }

        public ColisBuilder address(String address){
            this.address = address;
            return this;
        }

        public ColisBuilder deliveryPersonId(UUID deliveryPersonId){
            this.deliveryPersonId = deliveryPersonId;
            return this;
        }

        public ColisBuilder details(String details){
            this.details = details;
            return this;
        }

        public ColisBuilder email(String email){
            this.email = email;
            return this;
        }

        public Colis build(){
            return new Colis(this.id, this.address, this.deliveryPersonId, this.details, this.email);
        }
    }
}
