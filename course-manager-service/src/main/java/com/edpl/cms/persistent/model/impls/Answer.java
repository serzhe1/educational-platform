package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
public class Answer extends AbstractEntity {
    private String answer;
    @Column(name = "iscorrect")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
