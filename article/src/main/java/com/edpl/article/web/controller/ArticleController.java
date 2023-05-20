package com.edpl.article.web.controller;

import com.edpl.article.service.ArticleEntityService;
import com.edpl.article.web.dto.ArticleDTO;
import com.edpl.article.web.dto.ArticleInfoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/articles")
@Tag(name = "article-controller", description = "User")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleEntityService service;

    @PostMapping
    public ArticleDTO save(ArticleDTO request, Principal principal) {
        return service.save(request);
    }

    @GetMapping
    public List<ArticleInfoDTO> getAllInfo() {
        return service.getAllInfo();
    }
//    @Operation(summary = "Удалить сущность по id", security = @SecurityRequirement(name = "bearerAuth"))
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("{id}")
//    @RolesAllowed({"user"})
}
