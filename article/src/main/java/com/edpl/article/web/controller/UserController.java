package com.edpl.article.web.controller;

import com.edpl.article.model.ArticlesEntity;
import com.edpl.article.model.UsersEntity;
import com.edpl.article.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/user")
@Tag(name = "user-controller", description = "User")
public class UserController extends AbstractControllerImpl<UsersEntity, UserService> {
    protected final UserService service;

    public UserController(UserService service, UserService service1) {
        super(service);
        this.service = service1;
    }

    @GetMapping("/get-user-articles")
    @Operation(summary = "Получить все статьи пользователя")
    @RolesAllowed({"user"})
    public ResponseEntity<List<ArticlesEntity>> getUserArticles(@RequestParam Long userId) {
        return ResponseEntity.ok(service.getUserArticles(userId));
    }
}
