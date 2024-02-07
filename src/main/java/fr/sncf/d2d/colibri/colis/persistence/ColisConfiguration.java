package fr.sncf.d2d.colibri.colis.persistence;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import fr.sncf.d2d.colibri.colis.models.Colis;

@Configuration
public class ColisConfiguration {

    private List<Colis> colis;

    public List<Colis> getColis() {
        return this.colis;
    }

    public void setColis(List<Colis> colis) {
        this.colis = colis;
    }
    
}
