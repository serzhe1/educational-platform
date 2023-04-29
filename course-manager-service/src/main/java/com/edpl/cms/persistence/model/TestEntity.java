package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tests")
@Data
@NoArgsConstructor
public class TestEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @OneToMany(mappedBy = "test")
    private Set<TestAnswersEntity> testAnswers;
}
