package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lectures")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LectureEntity extends AbstractEntity<Long> {
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;
}
