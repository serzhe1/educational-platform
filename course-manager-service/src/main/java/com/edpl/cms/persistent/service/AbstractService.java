package com.edpl.cms.persistent.service;

import com.edpl.cms.persistent.model.AbstractEntity;
import com.edpl.cms.persistent.repository.CommonRepository;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService <E extends AbstractEntity, R extends CommonRepository<E>> {
    protected final R repository;
    protected String notFoundMassage = "entity is unfounded with id: ";

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }
    public List<E> getAll() {
        return repository.findAll();
    }

    public E getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(notFoundMassage + id));
    }

}