package com.edpl.coursemanagerservice.persistent.service;

import com.edpl.coursemanagerservice.persistent.model.AbstractEntity;
import com.edpl.coursemanagerservice.persistent.repository.CommonRepository;
import com.edpl.coursemanagerservice.web.exhandler.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService <E extends AbstractEntity, R extends CommonRepository<E>> {
    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }
    public List<E> getAll() {
        return repository.findAll();
    }

    public E getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("entity is unfounded with id: " + id));
    }

}
