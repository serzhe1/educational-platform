package com.edpl.cms.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("/test")
public class TestRoleAllowController {

    @GetMapping("/")
    @RolesAllowed({"student"})
    public String getProduct(Principal principal) {
        return "Response from Student Service, User Id:" + principal.getName();
    }
}