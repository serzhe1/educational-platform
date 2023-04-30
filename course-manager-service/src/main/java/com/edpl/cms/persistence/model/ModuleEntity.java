package com.edpl.cms.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "modules")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ModuleEntity extends AbstractEntity<Long> {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany(mappedBy = "module")
    private Set<LectureEntity> lectures;

    @OneToMany(mappedBy = "module")
    private Set<TestEntity> tests;
}
