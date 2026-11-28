package com.example.api.kotlin.v1.people.services

import com.example.api.kotlin.v1.people.Person
import com.example.api.kotlin.v1.people.PersonRegistrationRequest

interface PersonRegistrationService {
    suspend fun register(request: PersonRegistrationRequest): Person
}