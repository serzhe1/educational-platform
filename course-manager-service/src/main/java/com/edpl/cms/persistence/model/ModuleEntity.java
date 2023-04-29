package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "modules")
@Data
@NoArgsConstructor
public class ModuleEntity {
    @Id
    @Column(name = "id")
    private Long id;

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
