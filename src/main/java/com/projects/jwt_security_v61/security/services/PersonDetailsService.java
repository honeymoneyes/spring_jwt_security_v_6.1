package com.projects.jwt_security_v61.security.services;

import com.projects.jwt_security_v61.user.exceptions.UserNotFoundException;
import com.projects.jwt_security_v61.user.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new PersonDetails(personRepository
                .findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }
}
