package fr.sncf.d2d.colibri.colis.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sncf.d2d.colibri.colis.exceptions.ColisNotFoundException;
import fr.sncf.d2d.colibri.colis.models.Colis;
import fr.sncf.d2d.colibri.colis.usecases.CreateColisParams;
import fr.sncf.d2d.colibri.colis.usecases.CreateColisUseCase;
import fr.sncf.d2d.colibri.colis.usecases.EditColisUseCase;
import fr.sncf.d2d.colibri.colis.usecases.PaginateColisUsecase;
import fr.sncf.d2d.colibri.colis.usecases.UpdateColisParams;
import fr.sncf.d2d.colibri.common.models.Page;
import fr.sncf.d2d.colibri.users.exceptions.UserNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/colis")
public class ColisRestController {

    private final CreateColisUseCase createColisUseCase;
    private final PaginateColisUsecase paginateColisUsecase;
    private final EditColisUseCase editColisUseCase;

    public ColisRestController(
        CreateColisUseCase createColisUseCase, 
        PaginateColisUsecase paginateColisUsecase,
        EditColisUseCase editColisUseCase
    ){
        this.createColisUseCase = createColisUseCase;
        this.paginateColisUsecase = paginateColisUsecase;
        this.editColisUseCase = editColisUseCase;
    }
    
    @PostMapping
    public Colis createColis(@Valid @RequestBody CreateColisBody body) throws UserNotFoundException {
        final var params = new CreateColisParams();
        params.setAddress(body.getAddress());
        params.setDetails(body.getDetails());
        params.setDeliveryPersonId(body.getDeliveryPersonId());
        params.setEmail(body.getEmail());
        return this.createColisUseCase.create(params);
    }

    @GetMapping
    public Page<Colis> paginateColis(@Valid PaginateColisQuery query){
        return this.paginateColisUsecase.paginate(query.getPage(), query.getItemsPerPage());
    }

    
    @PatchMapping("/{id}")
    public Colis editColis(@Valid @RequestBody UpdateColisBody updateColisBody, @PathVariable UUID id) throws ColisNotFoundException, UserNotFoundException {
        final var params = new UpdateColisParams();
        
        params.setId(id);
        params.setAddress(updateColisBody.getAddress());
        params.setDetails(updateColisBody.getDetails());
        params.setDeliveryPersonId(updateColisBody.getDeliveryPersonId());
        params.setEmail(updateColisBody.getEmail());
        params.setStatus(updateColisBody.getStatus());
        

        // return ResponseEntity.status(HttpStatus.OK).body("Le contenu du package mis à jour.");
        return this.editColisUseCase.edit(params);
    }
}
