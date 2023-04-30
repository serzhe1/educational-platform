package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends AbstractEntity<Long> {
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
