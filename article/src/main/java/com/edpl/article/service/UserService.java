package com.edpl.article.service;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.model.UsersEntity;
import com.edpl.article.repository.ArticlesEntityRepository;
import com.edpl.article.repository.UsersEntityRepository;
import com.edpl.article.web.controller.advice.FindException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@Service
public class UserService extends AbstractServiceImpl<UsersEntity, UsersEntityRepository> {
    private final UsersEntityRepository repository;
    private final ArticlesEntityRepository articlesEntityRepository;

    public UserService(UsersEntityRepository repository, UsersEntityRepository repository1, ArticlesEntityRepository articlesEntityRepository) {
        super(repository);
        this.repository = repository1;
        this.articlesEntityRepository = articlesEntityRepository;
    }

    @Transactional(readOnly = true)
    public List<ArticlesEntity> getUserArticles(Long userId) {
        try {
            UsersEntity user = this.findById(userId);
            return articlesEntityRepository.findArticlesByOwnerId(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new FindException(e.getClass().getSimpleName() + " Can't find articles by user id: " + userId + " " + e.getMessage());
        }
    }
}
