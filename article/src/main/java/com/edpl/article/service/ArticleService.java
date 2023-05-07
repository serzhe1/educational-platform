package com.edpl.article.service;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.repository.ArticlesEntityRepository;
import org.springframework.stereotype.Service;

/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@Service
public class ArticleService extends AbstractServiceImpl<ArticlesEntity, ArticlesEntityRepository> {
    private final ArticlesEntityRepository repository;
    public ArticleService(ArticlesEntityRepository repository, ArticlesEntityRepository repository1) {
        super(repository);
        this.repository = repository1;
    }
}
