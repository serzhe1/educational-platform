package com.edpl.cms.persistent.model.impls;

import com.edpl.cms.persistent.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "theory_parts")
@Data
public class TheoryPart extends AbstractEntity {
    private String title;
    private String content;
}
