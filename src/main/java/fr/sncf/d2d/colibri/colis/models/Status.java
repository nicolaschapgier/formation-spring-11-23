package fr.sncf.d2d.colibri.colis.models;

import org.springframework.security.core.GrantedAuthority;

public enum Status implements GrantedAuthority {
    PENDING,
    IN_TRANSIT,
    DELIVERED,
    RETURNED;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
