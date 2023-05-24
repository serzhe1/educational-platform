package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    List<TestEntity> findAllByModuleId(Long moduleId);


    @Query(value = """
            SELECT test
            FROM TestEntity test
            WHERE test.id in :ids
            """)
    List<TestEntity> findAllByIdIn(List<Long> ids);
}
