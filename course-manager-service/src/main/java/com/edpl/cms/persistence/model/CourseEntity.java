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
public class CourseEntity extends AbstractEntity<Long> {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "format")
    private String format;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "competencies")
    private String competencies;

    @Column(name = "owner_uuid")
    private String ownerUUID;

    @OneToMany
    @JoinColumn(name = "course_id")
    private Set<ModuleEntity> modules;
}
