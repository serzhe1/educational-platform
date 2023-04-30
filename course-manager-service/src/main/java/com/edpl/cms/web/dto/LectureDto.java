package com.edpl.cms.web.dto;

import com.edpl.cms.persistence.model.ModuleEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LectureDto {
    private Long id;
    private String name;
    private String content;

    private Long moduleId;

}
