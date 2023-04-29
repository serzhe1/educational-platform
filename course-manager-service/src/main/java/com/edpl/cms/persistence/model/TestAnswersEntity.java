package com.edpl.cms.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "test_answers")
@Data
@NoArgsConstructor
public class TestAnswersEntity {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "answer")
	private String answer;

	@Column(name = "is_right")
	private boolean isRight;

	@ManyToOne
	private TestEntity test;
}
