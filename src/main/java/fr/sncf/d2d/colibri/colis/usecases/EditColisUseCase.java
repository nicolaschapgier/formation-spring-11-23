package fr.sncf.d2d.colibri.colis.usecases;

import fr.sncf.d2d.colibri.colis.persistence.ColisRepository;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.sncf.d2d.colibri.colis.exceptions.ColisNotFoundException;
import fr.sncf.d2d.colibri.colis.models.Colis;

@Service
public class EditColisUseCase {

    private final ColisRepository colisRepository;
    
    public EditColisUseCase(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }
    
    public Colis edit(UpdateColisParams params) throws ColisNotFoundException {
        final Colis colis = this.colisRepository.findColisById(params.getId());

        if (colis == null) {
            throw ColisNotFoundException.id(params.getId());
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
