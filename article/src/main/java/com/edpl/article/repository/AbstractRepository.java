package com.edpl.article.repository;

import com.edpl.article.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends JpaRepository<E, Long>,
        JpaSpecificationExecutor<E> {
}
