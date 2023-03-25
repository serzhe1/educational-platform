package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tasks")
@Data
public class Task extends AbstractEntity {
    private String text;
    private String answer;
}


