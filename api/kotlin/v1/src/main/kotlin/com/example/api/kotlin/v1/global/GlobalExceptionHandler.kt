package com.example.api.kotlin.v1.global

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(
        BlankValueException::class,
        DuplicatedInformationException::class,
        InvalidOptionException::class,
        InvalidRegexException::class
    )
     suspend fun code422Exceptions(ex: RuntimeException): ProblemDetail {
        val status = HttpStatus.UNPROCESSABLE_CONTENT
        val problemDetail = ProblemDetail.forStatusAndDetail(
            status,
            ex.message
        )
        problemDetail.title = "Invalid input"
        return problemDetail
    }
}
