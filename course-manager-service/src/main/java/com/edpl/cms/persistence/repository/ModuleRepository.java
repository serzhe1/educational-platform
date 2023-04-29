package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.ModuleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long> {
}
