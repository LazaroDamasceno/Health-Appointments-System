package com.example.api.kotlin.v1.global

class ValueObjectVerifier {
    companion object {
        fun blankValue(value: String, message: String) {
            if (value.isBlank()) {
                throw BlankValueException(message)
            }
        }

        fun unmatchablePattern(value: String, regex: Regex, message: String) {
            if (!regex.matches(value)) {
                throw InvalidRegexException(message)
            }
        }
    }
}