package com.edpl.cms.persistent.service.impls;

import com.edpl.cms.persistent.model.impls.TheoryPart;
import com.edpl.cms.persistent.model.impls.User;
import com.edpl.cms.persistent.repository.impls.UserRepository;
import com.edpl.cms.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }

    public User save(User user) {
        if (user.getId() != null) {
            User updatedUser = getById(user.getId());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setRoles(user.getRoles());
            return repository.save(updatedUser);
        }
        return repository.save(user);
    }
}
