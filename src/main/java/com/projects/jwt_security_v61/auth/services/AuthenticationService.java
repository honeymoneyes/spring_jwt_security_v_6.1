package com.projects.jwt_security_v61.auth.services;

import com.projects.jwt_security_v61.auth.messages.requests.LoginRequest;
import com.projects.jwt_security_v61.auth.messages.requests.RegisterRequest;
import com.projects.jwt_security_v61.auth.messages.responses.AuthenticationResponse;
import com.projects.jwt_security_v61.security.jwt.JwtUtils;
import com.projects.jwt_security_v61.security.services.PersonDetailsService;
import com.projects.jwt_security_v61.user.models.Person;
import com.projects.jwt_security_v61.user.repositories.PersonRepository;
import com.projects.jwt_security_v61.user.roles.RoleUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository personRepository;
    private final JwtUtils jwtUtils;
    private final PersonDetailsService personDetailsService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) {

        Person person = Person.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleUser.ROLE_USER)
                .build();

        personRepository.save(person);

        UserDetails userDetails = personDetailsService.loadUserByUsername(person.getEmail());

        String token = jwtUtils.generateToken(userDetails);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse login(LoginRequest request) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword());

        authenticationManager.authenticate(authToken);

        UserDetails userDetails = personDetailsService.loadUserByUsername(request.getEmail());

        String token = jwtUtils.generateToken(userDetails);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
