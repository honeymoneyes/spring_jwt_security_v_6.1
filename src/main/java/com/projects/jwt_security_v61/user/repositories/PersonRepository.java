package com.projects.jwt_security_v61.user.repositories;

import com.projects.jwt_security_v61.user.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);
}
