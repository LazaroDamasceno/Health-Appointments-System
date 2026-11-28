package com.example.api.kotlin.v1.people.services

import com.example.api.kotlin.v1.global.DuplicatedInformationException
import com.example.api.kotlin.v1.people.Person
import com.example.api.kotlin.v1.people.PersonRegistrationRequest
import com.example.api.kotlin.v1.people.PersonRegistrationService
import com.example.api.kotlin.v1.people.repository.PersonRepository
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class PersonRegistrationServiceImpl(
    private val personRepository: PersonRepository
): PersonRegistrationService {

    override suspend fun register(request: @Valid PersonRegistrationRequest): Person {
        val foundByEmail = personRepository.findByEmail(request.email)
        if (foundByEmail != null) {
            throw DuplicatedInformationException("Email already in use")
        }

        val foundByIdentifier = personRepository.findByIdentifier(request.identifier)
        if (foundByIdentifier != null) {
            throw DuplicatedInformationException("Identifier already in use")
        }

        val newPerson = Person.from(
            request.firstName,
            request.middleName,
            request.lastName,
            request.identifier,
            request.email,
            request.gender,
            request.phoneNumber
        )
        return personRepository.save(newPerson)
    }
}