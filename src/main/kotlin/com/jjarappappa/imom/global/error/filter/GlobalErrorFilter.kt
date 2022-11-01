package com.jjarappappa.imom.global.error.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.jjarappappa.imom.global.error.ErrorResponse
import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.ErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class GlobalErrorFilter(
    private val objectMapper: ObjectMapper,
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: IMomException) {
            setErrorResponse(e.errorProperty, response)
        } catch (e: Exception) {
            if (e.cause is IMomException) {
                setErrorResponse((e.cause as IMomException?)!!.errorProperty, response)
            } else {
                e.printStackTrace()
                setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response)
            }
        }
    }

    @Throws(IOException::class)
    private fun setErrorResponse(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(
            objectMapper.writeValueAsString(
                ErrorResponse(errorProperty = errorProperty)
            )
        )
    }
}