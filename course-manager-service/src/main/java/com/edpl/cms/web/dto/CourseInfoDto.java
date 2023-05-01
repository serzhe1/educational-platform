package com.edpl.cms.web.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class CourseInfoDto {
	@Builder
	public static class ModuleInfoDto {
		private final String title;
		private final List<String> lectures;
	}

	private final String courseTitle;

	private final List<ModuleInfoDto> moduleInfos;
}
