package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@ManyToMany
	@JoinTable(name = "user_roles",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> role;

	@ManyToMany
	@JoinTable(name = "user_courses",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<CourseEntity> courses;

	private String fullName;
}
