package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tests")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TestEntity extends AbstractEntity<Long> {

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @OneToMany
    @JoinColumn(name = "test_id")
    private Set<TestAnswersEntity> testAnswers;
}
