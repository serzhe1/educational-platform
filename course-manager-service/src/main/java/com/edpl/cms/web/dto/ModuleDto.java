package com.edpl.cms.web.dto;

import com.edpl.cms.persistence.model.CourseEntity;
import com.edpl.cms.persistence.model.LectureEntity;
import com.edpl.cms.persistence.model.TestEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleDto {
    private Long id;
    private String name;
    private String description;
    private Long courseId;
    private Set<TestDto> tests;
}
