package com.jjarappappa.imom.global.error

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IceCreamException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class IceCreamExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(IceCreamException::class)
    fun handleIceCreamException(
        e: IceCreamException,
        request: HttpServletRequest
    ): ErrorResponse {
        log.error("errorCode: {}, url: {}, message: {}",
            e.errorCode, request.requestURI, e.message)

        return ErrorResponse(e.errorCode);
    }

    @ExceptionHandler(Exception::class)
    fun handleRuntimeException(
        e: Exception,
        request: HttpServletRequest,
    ): ErrorResponse {
        log.error("url: {}, message: {}", request.requestURI, e.message)

        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }

}