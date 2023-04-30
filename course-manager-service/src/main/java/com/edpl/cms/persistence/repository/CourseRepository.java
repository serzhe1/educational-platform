package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	List<CourseEntity> findAllByNameContaining(String namePattern);
}
