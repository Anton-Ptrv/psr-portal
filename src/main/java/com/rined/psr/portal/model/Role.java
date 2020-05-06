package com.rined.psr.portal.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, DEV;

    @Override
    public String getAuthority() {
        return name();
    }

}
