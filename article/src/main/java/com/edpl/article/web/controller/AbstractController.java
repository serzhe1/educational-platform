package com.edpl.article.web.controller;

import com.edpl.article.model.AbstractEntity;
import com.edpl.article.web.dto.AbstractResponseDTO;
import com.edpl.article.web.dto.specification.request.SearchRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


public interface AbstractController<T extends AbstractEntity> {
    @Operation(summary = "Получить постранично", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @RolesAllowed("EVERYONE")
    ResponseEntity<AbstractResponseDTO> getPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size);

    @Operation(summary = "Поиск по фильтрам", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("filter")
    @RolesAllowed("EVERYONE")
    ResponseEntity<AbstractResponseDTO> searchFilter(@RequestBody SearchRequest request);

    @Operation(summary = "Получить по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    @RolesAllowed("EVERYONE")
    ResponseEntity<T> getOne(@PathVariable Long id);

    @Operation(summary = "Обновить данные", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    @RolesAllowed({"user"})
    ResponseEntity<T> update(@RequestBody T update);

    @Operation(summary = "Создать сущность", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    @RolesAllowed({"user"})
    ResponseEntity<T> create(@RequestBody T create);

    @Operation(summary = "Удалить сущность по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    @RolesAllowed({"user"})
    ResponseEntity<T> delete(@PathVariable Long id);
}
