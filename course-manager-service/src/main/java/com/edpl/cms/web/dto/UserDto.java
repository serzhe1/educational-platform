package com.edpl.cms.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
}
