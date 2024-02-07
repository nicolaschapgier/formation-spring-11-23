package fr.sncf.d2d.colibri.colis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.sncf.d2d.colibri.colis.exceptions.ColisNotFoundException;
import fr.sncf.d2d.colibri.colis.exceptions.DeliveryPersonNotFoundException;
import fr.sncf.d2d.colibri.colis.exceptions.FieldNotFilledException;
import fr.sncf.d2d.colibri.users.exceptions.UserNotFoundException;

@RestControllerAdvice(assignableTypes = { ColisRestController.class })
public class ColisRestControllerAdvice {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handeUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(exception.getMessage());
    }   

    @ExceptionHandler(ColisNotFoundException.class)
    public ResponseEntity<String> handeColisNotFound(ColisNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(exception.getMessage());
    }

    @ExceptionHandler(DeliveryPersonNotFoundException.class)
    public ResponseEntity<String> handeDeliveryNotFound(DeliveryPersonNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(exception.getMessage());
    }
    @ExceptionHandler(FieldNotFilledException.class)
    public ResponseEntity<String> handeDeliveryNotFound(FieldNotFilledException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(exception.getMessage());
    }
    
}
