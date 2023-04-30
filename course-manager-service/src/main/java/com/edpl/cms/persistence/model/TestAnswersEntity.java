package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "test_answers")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TestAnswersEntity extends AbstractEntity<Long> {
    @Column(name = "answer")
    private String answer;

    @Column(name = "is_right")
    private boolean isRight;

    @ManyToOne
    private TestEntity test;
}
