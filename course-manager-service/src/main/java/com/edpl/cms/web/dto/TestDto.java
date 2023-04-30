package com.edpl.cms.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestDto {
    private Long id;
    private String question;
//    private List<TestAnswerDto> answers;
    private Long module;
}
