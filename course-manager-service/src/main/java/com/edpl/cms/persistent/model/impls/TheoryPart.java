package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "theory_parts")
@Data
public class TheoryPart extends AbstractEntity {
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "theory_module_id")
    private TheoryModule theoryModule;
}
