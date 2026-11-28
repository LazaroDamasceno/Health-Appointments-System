package com.example.api.kotlin.v1.global

class ValueObjectValueVerifier {
    companion object {
        fun nullableOrBlankValue(value: String?, message: String) {
            if (value?.isBlank() == true) {
                throw NullableOrBlankValueException(message)
            }
        }

        fun unmatchablePattern(value: String, regex: Regex, message: String) {
            if (!regex.matches(value)) {
                throw InvalidRegexException(message)
            }
        }
    }
}