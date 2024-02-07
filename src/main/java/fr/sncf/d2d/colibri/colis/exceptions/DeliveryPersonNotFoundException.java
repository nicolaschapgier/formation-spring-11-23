package fr.sncf.d2d.colibri.colis.exceptions;

import java.util.UUID;

public class DeliveryPersonNotFoundException extends Exception {

    private DeliveryPersonNotFoundException(String message) {
        super(message);
    }
    
    public static DeliveryPersonNotFoundException id(UUID id) {
        return new DeliveryPersonNotFoundException(String.format("Le livreur %s n'existe pas", id));
    }
    
}
