package fr.sncf.d2d.colibri.colis.usecases;

import org.springframework.stereotype.Service;

import fr.sncf.d2d.colibri.colis.models.Colis;
import fr.sncf.d2d.colibri.colis.persistence.ColisRepository;
import fr.sncf.d2d.colibri.common.models.Page;

@Service
public class PaginateColisUsecase {
    
    private final ColisRepository colisRepository;

    public PaginateColisUsecase(ColisRepository colisRepository){
        this.colisRepository = colisRepository;
    }

    public Page<Colis> paginate(long page, long itemsPerPage){
        return this.colisRepository.paginate(page, itemsPerPage);
    }
}
