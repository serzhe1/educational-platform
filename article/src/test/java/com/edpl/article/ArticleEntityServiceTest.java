package com.edpl.article;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.repository.ArticlesEntityRepository;
import com.edpl.article.service.ArticleEntityService;
import com.edpl.article.web.dto.ArticleInfoDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ArticleEntityServiceTest {

    @Mock
    private ArticlesEntityRepository repository;

    @InjectMocks
    private ArticleEntityService articleEntityService;

    @Spy
    ModelMapper modelMapper;

    @Test
    public void testGetAllInfo() {
        // prepare test data
        ArticlesEntity article1 = new ArticlesEntity();
        article1.setId(1L);
        article1.setName("Title 1");
        article1.setDescription("Description 1");

        ArticlesEntity article2 = new ArticlesEntity();
        article2.setId(2L);
        article2.setName("Title 2");
        article2.setDescription("Description 2");
        List<ArticlesEntity> articles = Arrays.asList(article1, article2);

        // set up mock repository to return prepared test data
        when(repository.findAll()).thenReturn(articles);

        // invoke the method being tested
        List<ArticleInfoDTO> result = articleEntityService.getAllInfo();

        // assert the result
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Title 1", result.get(0).getName());
        assertEquals("Description 1", result.get(0).getDescription());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Title 2", result.get(1).getName());
        assertEquals("Description 2", result.get(1).getDescription());
    }

}