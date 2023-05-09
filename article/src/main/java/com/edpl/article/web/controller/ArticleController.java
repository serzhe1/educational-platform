package com.edpl.article.web.controller;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.service.ArticleService;
import com.edpl.article.web.controller.AbstractControllerImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/article")
@Tag(name = "article-controller", description = "User")
public class ArticleController extends AbstractControllerImpl<ArticlesEntity, ArticleService> {
    private final ArticleService service;
    public ArticleController(ArticleService service, ArticleService service1) {
        super(service);
        this.service = service1;
    }
}
