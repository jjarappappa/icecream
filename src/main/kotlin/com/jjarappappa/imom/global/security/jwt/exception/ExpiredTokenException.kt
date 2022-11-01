package com.jjarappappa.imom.global.security.jwt.exception

import com.jjarappappa.imom.global.error.exception.IMomException
import com.jjarappappa.imom.global.security.jwt.exception.error.JwtErrorProperty

object ExpiredTokenException: IMomException(JwtErrorProperty.EXPIRED_TOKEN) {
    val EXCEPTION by lazy { this }
}
