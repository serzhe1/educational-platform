package com.edpl.cms.persistence.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public interface User extends UserDetails {

    void setUsername(String username);

    String getDisplayName();

    void setDisplayName(String displayName);

    void setAuthorities(Set<GrantedAuthority> authorities);

}
