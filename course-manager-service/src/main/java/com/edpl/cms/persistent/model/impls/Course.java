package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "courses")
@Entity
@Data
public class Course extends AbstractEntity {
    private String name;
    private String description;

    private List<User> users;

    @ManyToMany
    @JoinTable(name = "user_course",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    public List<User> getUsers() {
        return users;
    }
}


