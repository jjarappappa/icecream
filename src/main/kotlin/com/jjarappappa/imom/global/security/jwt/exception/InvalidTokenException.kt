package com.jjarappappa.imom.global.security.jwt.exception

import com.jjarappappa.imom.global.error.exception.IMomException
import com.jjarappappa.imom.global.security.jwt.exception.error.JwtErrorProperty

object InvalidTokenException: IMomException(JwtErrorProperty.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}