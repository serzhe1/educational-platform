package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.UserCoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCoursesEntity, Long> {
    List<UserCoursesEntity> findAllByUserUuid(String userUuid);
    void deleteByCourseIdAndUserUuid(Long courseId, String userUuid);

    Optional<UserCoursesEntity> findByCourseIdAndUserUuid(Long courseId, String userUuid);
}
