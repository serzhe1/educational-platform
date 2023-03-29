package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tasks")
@Data
public class Task extends AbstractEntity {
    private String description;

    private int theoryModuleId;
}


