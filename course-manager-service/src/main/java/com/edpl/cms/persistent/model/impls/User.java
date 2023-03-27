package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "users", schema = "public")
@Entity
@Data
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String email;

    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<Role> getRoles() {
        return roles;
    }

}
