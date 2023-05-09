package com.edpl.cms.service.security;

import com.edpl.cms.persistence.model.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class TokenAuthentication implements Authentication {

    /**
     * UID.
     */
    private static final long serialVersionUID = 8693521345558148891L;

    private String token;

    private String username;

    private boolean authenticated;

    private transient User userDetails;

    private boolean expired;

    private Collection<? extends GrantedAuthority> grantAuthorities;


    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean isExpired) {
        this.expired = isExpired;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPrincipal(User principal) {
        this.userDetails = principal;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof TokenAuthentication) {
            return this.getToken() == ((TokenAuthentication) obj).getToken();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    public void setName(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantAuthorities;
    }

    @Override
    public User getDetails() {
        return userDetails;
    }

    public void setDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        this.authenticated = isAuthenticated;
    }

    public void setAuthorities(
            Collection<? extends GrantedAuthority> grantAuthorities) {
        this.grantAuthorities = grantAuthorities;
    }
}