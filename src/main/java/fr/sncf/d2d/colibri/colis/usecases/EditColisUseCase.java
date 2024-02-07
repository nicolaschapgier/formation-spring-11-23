package fr.sncf.d2d.colibri.colis.usecases;

import fr.sncf.d2d.colibri.colis.persistence.ColisRepository;
import fr.sncf.d2d.colibri.users.exceptions.UserNotFoundException;
import fr.sncf.d2d.colibri.users.persistence.UsersRepository;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.sncf.d2d.colibri.colis.exceptions.ColisNotFoundException;
import fr.sncf.d2d.colibri.colis.exceptions.FieldNotFilledException;
import fr.sncf.d2d.colibri.colis.models.Colis;

@Service
public class EditColisUseCase {

    private final ColisRepository colisRepository;
    private final UsersRepository usersRepository;
    
    public EditColisUseCase(ColisRepository colisRepository, UsersRepository usersRepository) {
        this.colisRepository = colisRepository;
        this.usersRepository = usersRepository;
    }

    public Colis edit(UpdateColisParams params) throws ColisNotFoundException, UserNotFoundException, FieldNotFilledException {
        final Colis colis = this.colisRepository.findColisById(params.getId());

        if (colis == null) {
            throw ColisNotFoundException.id(params.getId());
        }

        if (this.usersRepository.getUsers().stream().filter(user -> user.getId().equals(params.getDeliveryPersonId())).findFirst().isEmpty()) {
            throw UserNotFoundException.id(params.getDeliveryPersonId());
        }
        
        if (params.getAddress().isEmpty()) {
            throw FieldNotFilledException.field("address");
        }
        
        if (params.getEmail().isEmpty()) {
            throw FieldNotFilledException.field("email");
        }
        
        
        final String address = params.getAddress().equals("") ? colis.getAddress() : params.getAddress();
        final String email = params.getEmail().equals("") ? colis.getEmail() : params.getEmail();
        final String details = params.getDetails() == null ? colis.getDetails() : params.getDetails();
        final UUID deliveryPersonId = params.getDeliveryPersonId() == null ? null : params.getDeliveryPersonId();
        
        colis.setAddress(address);
        colis.setEmail(email);
        colis.setDetails(details);
        colis.setDeliveryPersonId(deliveryPersonId);

        this.colisRepository.updateColis(colis);

        return colis;
    }
    
}
