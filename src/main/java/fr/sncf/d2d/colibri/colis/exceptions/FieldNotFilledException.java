package fr.sncf.d2d.colibri.colis.exceptions;

public class FieldNotFilledException extends Exception{
    
    private FieldNotFilledException(String message) {
        super(message);
    }

    public static FieldNotFilledException field(String field) {
        return new FieldNotFilledException(String.format("Le champ %s est invalide", field));
    }
    
}
