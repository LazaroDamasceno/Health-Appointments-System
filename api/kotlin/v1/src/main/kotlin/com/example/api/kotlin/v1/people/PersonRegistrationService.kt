package com.example.api.kotlin.v1.people

interface PersonRegistrationService {
    suspend fun register(request: PersonRegistrationRequest): Person
}