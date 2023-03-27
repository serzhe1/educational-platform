package com.edpl.cms.persistent.repository.impls;

import com.edpl.cms.persistent.model.impls.User;
import com.edpl.cms.persistent.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {
}