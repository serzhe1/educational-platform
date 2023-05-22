package com.edpl.article.service;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.model.CommentEntity;
import com.edpl.article.repository.ArticlesEntityRepository;
import com.edpl.article.repository.CommentRepository;
import com.edpl.article.web.controller.advice.FindException;
import com.edpl.article.web.dto.ArticleDTO;
import com.edpl.article.web.dto.ArticleInfoDTO;
import com.edpl.article.web.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleEntityService {
    private final ArticlesEntityRepository repository;
    private final CommentRepository commentRepository;
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
        Set<CommentDTO> comments = entity.getComments().stream()
                .map(c -> modelMapper.map(c, CommentDTO.class))
                .collect(Collectors.toSet());
        ArticleDTO response = modelMapper.map(entity, ArticleDTO.class);
        response.setComments(comments);
        return response;
    }

    @Transactional
    public ArticleDTO save(ArticleDTO request) {
        ArticlesEntity entity = modelMapper.map(request, ArticlesEntity.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        entity.setOwnerUuid(authentication.getName());

        entity = repository.save(entity);

        return modelMapper.map(entity, ArticleDTO.class);
    }

    @Transactional
    public ArticleDTO deleteById(Long id) {
        ArticlesEntity entity = repository.findById(id)
                .orElseThrow(() -> new FindException("Article is not found with id: " + id));

        repository.delete(entity);
        return modelMapper.map(entity, ArticleDTO.class);
    }

    public CommentDTO saveComment(CommentDTO request) {
        CommentEntity entity = modelMapper.map(request, CommentEntity.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        entity.setTime(new Timestamp(System.currentTimeMillis()));
        entity = commentRepository.save(entity);
        return modelMapper.map(entity, CommentDTO.class);
    }

    @Transactional
    public CommentDTO deleteCommentById(Long id) {
        CommentEntity entity = commentRepository.findById(id)
                .orElseThrow(() -> new FindException("Comment is not found with id: " + id));

        commentRepository.delete(entity);
        return modelMapper.map(entity, CommentDTO.class);
    }
}
