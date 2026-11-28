package com.example.api.kotlin.v1.people.valueobjects

import com.example.api.kotlin.v1.global.ValueObjectVerifier

@ConsistentCopyVisibility
data class Identifier private constructor(val value: String) {
    companion object {
        private val REGEX = Regex("^[A-Z]\\d{6}[A-Z]{2}$")

        operator fun invoke(value: String): Identifier {
            ValueObjectVerifier.blankValue(
                value,
                "Identifier is required"
            )

            val valueTrimmed = value.trim()
            ValueObjectVerifier.unmatchablePattern(
                valueTrimmed,
                REGEX,
                "Invalid identifier format: $valueTrimmed"
            )

            return Identifier(valueTrimmed)
        }
    }
}
