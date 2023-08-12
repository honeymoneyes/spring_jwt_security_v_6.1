package com.projects.jwt_security_v61.user.services;

import com.projects.jwt_security_v61.user.exceptions.UserNotFoundException;
import com.projects.jwt_security_v61.user.models.Person;
import com.projects.jwt_security_v61.user.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonCommonService<Person, Long> {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
