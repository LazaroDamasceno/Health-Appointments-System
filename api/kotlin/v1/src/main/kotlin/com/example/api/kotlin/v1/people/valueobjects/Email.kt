package com.example.api.kotlin.v1.people.valueobjects

import com.example.api.kotlin.v1.global.ValueObjectVerifier

@ConsistentCopyVisibility
data class Email private constructor(val value: String) {

    companion object {
        private val REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        operator fun invoke(value: String): Email {
            ValueObjectVerifier.blankValue(
                value,
                message = "Email is required"
            )

            val valueTrimmed = value.trim()
            ValueObjectVerifier.unmatchablePattern(
                valueTrimmed,
                REGEX,
                message = "Invalid email format: $valueTrimmed"
            )

            return Email(valueTrimmed)
        }
    }
}
