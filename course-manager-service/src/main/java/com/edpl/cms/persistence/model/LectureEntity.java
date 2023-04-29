package com.edpl.cms.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "lectures")
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

	public LectureEntity() {
	}

	public LectureEntity(String name, String content, ModuleEntity module) {
		this.name = name;
		this.content = content;
		this.module = module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ModuleEntity getModule() {
		return module;
	}

	public void setModule(ModuleEntity module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "LectureEntity{" +
			"id=" + id +
			", name='" + name + '\'' +
			", content='" + content + '\'' +
			'}';
	}
}
