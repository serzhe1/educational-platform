package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
    Optional<TestEntity> findAllByModuleId(Long moduleId);
}
