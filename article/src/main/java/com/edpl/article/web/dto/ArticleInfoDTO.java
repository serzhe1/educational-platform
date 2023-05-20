package com.edpl.article.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleInfoDTO {
    private Long id;
    private String name;
    private String description;
}
