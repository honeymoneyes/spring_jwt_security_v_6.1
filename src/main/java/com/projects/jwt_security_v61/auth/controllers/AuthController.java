package com.projects.jwt_security_v61.auth.controllers;

import com.projects.jwt_security_v61.auth.messages.requests.LoginRequest;
import com.projects.jwt_security_v61.auth.messages.requests.RegisterRequest;
import com.projects.jwt_security_v61.auth.messages.responses.AuthenticationResponse;
import com.projects.jwt_security_v61.auth.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> performRegister(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> performLogin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
