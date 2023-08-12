package com.projects.jwt_security_v61.auth.controllers;

import com.projects.jwt_security_v61.security.services.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/check")
public class CheckAuthController {


    @GetMapping
    public Map<String, Object> checkUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails principal = (PersonDetails) authentication.getPrincipal();
        return Map.of(
                "username", principal.getUsername(),
                "roles", principal.getAuthorities());
    }
}
