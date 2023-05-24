package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findAllByNameContaining(String namePattern);

    @Query("""
            SELECT course
            FROM CourseEntity course
            WHERE course.id in :id
            """)
    List<CourseEntity> findAllIdIn(Collection<Long> id);

    @Query(value = """
            SELECT course
            FROM CourseEntity course
            WHERE course.id = :id AND course.ownerUUID = :ownerUuid
                     """)
    Optional<CourseEntity> findByIdAndOwnerUUID(Long id, String ownerUuid);


    List<CourseEntity> findAllByOwnerUUID(String ownerUUID);
}
