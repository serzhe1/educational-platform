package com.edpl.cms.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestResultResponse {
    private int questionNum;
    private int isRightNum;
    private Double isRightPercent;
}
