package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CourseEntity extends AbstractEntity<Long> {
    @Column(name = "description")
    private String description;

    @Column(name = "format")
    private String format;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "competencies")
    private String competencies;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "course")
    private Set<ModuleEntity> modules;
}
