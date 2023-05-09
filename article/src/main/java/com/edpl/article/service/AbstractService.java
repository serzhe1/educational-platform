package com.edpl.article.service;


import com.edpl.article.model.AbstractEntity;
import com.edpl.article.web.dto.AbstractResponseDTO;
import com.edpl.article.web.dto.specification.request.SearchRequest;

public interface AbstractService<E extends AbstractEntity> {
    E save(E entity);

    E update(E entity);

    E delete(Long id);

    E findById(Long id);

    AbstractResponseDTO findAll(Integer page, Integer size);

    AbstractResponseDTO searchFilter(SearchRequest request);
}