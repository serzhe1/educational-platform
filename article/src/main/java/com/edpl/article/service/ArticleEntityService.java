package com.edpl.article.service;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.repository.ArticlesEntityRepository;
import com.edpl.article.web.controller.advice.FindException;
import com.edpl.article.web.dto.ArticleDTO;
import com.edpl.article.web.dto.ArticleInfoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleEntityService {
    private final ArticlesEntityRepository repository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<ArticleInfoDTO> getAllInfo() {
        return repository.findAll().stream()
                .map(a -> modelMapper.map(a, ArticleInfoDTO.class))
                .toList();
    }

    @Transactional(readOnly = true)
    public ArticleDTO getArticleById(Long id) {
        ArticlesEntity entity = repository.findById(id)
                .orElseThrow(() -> new FindException("Article is not found with id: " + id));

        return modelMapper.map(entity, ArticleDTO.class);
    }

//    @Transactional(readOnly = true)
//    public List<ArticleInfoDTO> getAllByUserUUID() {
//
//    }

    @Transactional
    public ArticleDTO save(ArticleDTO request) {
        ArticlesEntity entity = modelMapper.map(request, ArticlesEntity.class);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getPrincipal();
        entity = repository.saveAndFlush(entity);
        throw new RuntimeException();
//        return modelMapper.map(entity, ArticleDTO.class);
    }

    @Transactional
    public ArticleDTO deleteById(Long id) {
        ArticlesEntity entity = repository.findById(id)
                .orElseThrow(() -> new FindException("Article is not found with id: " + id));

        repository.delete(entity);
        return modelMapper.map(entity, ArticleDTO.class);
    }
}
