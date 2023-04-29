package com.edpl.cms.persistence.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
@Tag(name = "course")
@Data
@NoArgsConstructor
public class CourseEntity {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "format")
	private String format;

	@Column(name = "requirements")
	private String requirements;

	@Column(name = "competencies")
	private String competencies;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private UserEntity owner;

	@OneToMany(mappedBy = "course")
	private Set<ModuleEntity> modules;
}
