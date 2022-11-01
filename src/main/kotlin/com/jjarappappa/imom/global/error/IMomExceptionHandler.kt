package com.jjarappappa.imom.global.error

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException


@RestControllerAdvice
class IMomExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BindException::class)
    fun bindException(e: BindException): ResponseEntity<Map<String, String?>>? {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(e: ConstraintViolationException): ResponseEntity<Map<String, Any>>? {
        val errorMap: MutableMap<String, Any> = HashMap()
        val errors: MutableList<String> = ArrayList()
        for (violation in e.constraintViolations) {
            errors.add(violation.rootBeanClass.name + " " +
                violation.propertyPath + ": " + violation.message)
        }
        errorMap["errors"] = errors
        errorMap["message"] = e.message!!
        return ResponseEntity(errorMap, HttpStatus.BAD_REQUEST)
    }
}