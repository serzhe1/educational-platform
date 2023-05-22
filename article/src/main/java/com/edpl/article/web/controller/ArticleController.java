package com.edpl.article.web.controller;

import com.edpl.article.service.ArticleEntityService;
import com.edpl.article.web.dto.ArticleDTO;
import com.edpl.article.web.dto.ArticleInfoDTO;
import com.edpl.article.web.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleEntityService service;

    @PostMapping("/save")
    public ArticleDTO save(@RequestBody ArticleDTO request) {
        return service.save(request);
    }

    @PostMapping("/comment")
    public CommentDTO save(@RequestBody CommentDTO request) {
        return service.saveComment(request);
    }

    @DeleteMapping("/comment/{id}/delete")
    public CommentDTO save(@PathVariable Long id) {
        return service.deleteCommentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ArticleDTO delete (@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<ArticleInfoDTO> getAllInfo() {
        return service.getAllInfo();
    }

    @GetMapping("/{id}")
    public ArticleDTO getById(@PathVariable Long id) {
        return service.getArticleById(id);
    }

}
