package com.edpl.cms.web.controller;


import com.edpl.cms.persistent.model.impls.Task;
import com.edpl.cms.persistent.model.impls.User;
import com.edpl.cms.persistent.service.impls.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public User saveOrUpdate(@RequestBody User user) {
        return service.save(user);
    }
}
