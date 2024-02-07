package fr.sncf.d2d.colibri.colis.usecases;
import org.springframework.stereotype.Service;

import fr.sncf.d2d.colibri.colis.models.Colis;
import fr.sncf.d2d.colibri.colis.persistence.ColisRepository;
import fr.sncf.d2d.colibri.users.exceptions.UserNotFoundException;
import fr.sncf.d2d.colibri.users.persistence.UsersRepository;

@Service
public class CreateColisUseCase {

    private final ColisRepository colisRepository;
    private final UsersRepository usersRepository;

    public CreateColisUseCase(ColisRepository colisRepository, UsersRepository usersRepository){
        this.colisRepository = colisRepository;
        this.usersRepository = usersRepository;
    }
    
    public Colis create(CreateColisParams params) throws UserNotFoundException {

        final var colis = Colis.builder()
            .address(params.getAddress())
            .email(params.getEmail())
            .details(params.getDetails())
            .deliveryPersonId(params.getDeliveryPersonId())
            .build();

        if (this.usersRepository.getUsers().stream().filter(user -> user.getId().equals(params.getDeliveryPersonId())).findFirst().isEmpty()){
            throw UserNotFoundException.id(params.getDeliveryPersonId());
        }

        this.colisRepository.insert(colis);
        
        return colis;
    }

}
