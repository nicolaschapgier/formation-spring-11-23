package fr.sncf.d2d.colibri.users.exceptions;

import java.util.UUID;

public class UserNotFoundException extends Exception {

    private UserNotFoundException(String message){
        super(message);
    }

    public static UserNotFoundException id(UUID id){
        return new UserNotFoundException(String.format("l'utilisateur avec id %s n'existe pas", id));
    }
}
