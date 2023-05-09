package com.edpl.cms.persistence.model.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
public class KeyCloakUser implements User{

    private String username;
    private String displayName;
    private Collection<String> targets = new ArrayList<>();
    private Collection<String> databases = new ArrayList<>();
    private Set<GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
