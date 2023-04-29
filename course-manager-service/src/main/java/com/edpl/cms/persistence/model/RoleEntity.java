package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class RoleEntity {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
}
