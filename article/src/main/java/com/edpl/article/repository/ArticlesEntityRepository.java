package com.edpl.article.repository;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.model.UsersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesEntityRepository extends AbstractRepository<ArticlesEntity> {
    List<ArticlesEntity> findArticlesByOwnerId(UsersEntity ownerId);
}