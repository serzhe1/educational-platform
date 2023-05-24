package com.edpl.cms.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListAnswerRequest {
    private List<AnswerRequest> answer;
}