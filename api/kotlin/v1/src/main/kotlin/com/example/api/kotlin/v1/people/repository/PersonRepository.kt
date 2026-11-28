package com.example.api.kotlin.v1.people.repository

import com.example.api.kotlin.v1.people.Person
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import java.util.UUID

interface PersonRepository : CoroutineCrudRepository<Person, UUID> {

    @Query("SELECT * FROM person WHERE identifier = :id")
    suspend fun findByIdentifier(@Param("id") identifier: String): Person?

    @Query("SELECT * FROM person WHERE email = :email")
    suspend fun findByEmail(@Param("email") email: String): Person?
}
