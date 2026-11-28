package com.example.api.java.v1.people.repositories;

import com.example.api.java.v1.people.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    @Query("SELECT p FROM person WHERE p.email.value = :email")
    Optional<Person> findByEmail(@Param("email") String email);

    @Query("SELECT p FROM person WHERE p.identifier.value = :id")
    Optional<Person> findByIdentifier(@Param("id") String identifier);
}
