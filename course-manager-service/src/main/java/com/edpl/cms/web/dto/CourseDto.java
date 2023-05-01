package com.edpl.cms.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {
	@Data
	public static class ModuleInfoDto {
		private Long id;
		private String name;
		private List<LectureInfoDto> lectures;
	}

	@Data
	public static class LectureInfoDto {
		private Long id;
		private String name;
	}

	private Long id;

	private String name;

	private String description;

	private String format;

	private String requirements;

	private String competencies;

	private List<ModuleInfoDto> modules;
}
