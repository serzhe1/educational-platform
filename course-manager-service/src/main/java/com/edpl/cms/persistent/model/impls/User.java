package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "users", schema = "public")
@Entity
@Data
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String email;

    @JsonIgnore
    private Set<Role> roles;
    @JsonIgnore
    private List<Course> courses;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<Role> getRoles() {
        return roles;
    }

    @ManyToMany
    @JoinTable(name = "user_course",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    public List<Course> getCourses() {
        return courses;
    }
}
