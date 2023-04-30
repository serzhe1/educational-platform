package com.edpl.cms.web.dto;

import com.edpl.cms.persistence.model.CourseEntity;
import com.edpl.cms.persistence.model.LectureEntity;
import com.edpl.cms.persistence.model.TestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    private String name;
    private String description;
    private Long courseId;
}
