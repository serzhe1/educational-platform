package com.edpl.article.repository;

import com.edpl.article.model.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesEntityRepository extends JpaRepository<ArticlesEntity, Long> {

}