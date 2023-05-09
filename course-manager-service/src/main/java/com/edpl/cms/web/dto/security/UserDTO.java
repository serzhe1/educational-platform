package com.edpl.cms.web.dto.security;

import lombok.Data;

import java.util.Collection;

@Data
public class UserDTO {

    private String username;
    private String displayName;
    private Collection<String> roles;

}
