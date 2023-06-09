package com.edpl.article.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDTO {
    private Long id;
    private String name;
    private String description;
    private String content;
    private Set<CommentDTO> comments;

    @JsonIgnore
    private String ownerUuid;
}
