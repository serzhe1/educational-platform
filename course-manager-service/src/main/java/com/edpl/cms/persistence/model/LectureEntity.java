package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lectures")
@Data
@NoArgsConstructor
public class LectureEntity {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "content")
	private String content;

	@ManyToOne
	@JoinColumn(name = "module_id")
	private ModuleEntity module;
}
