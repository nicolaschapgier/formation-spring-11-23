package fr.sncf.d2d.colibri.users.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DELIVERY_PERSON,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
