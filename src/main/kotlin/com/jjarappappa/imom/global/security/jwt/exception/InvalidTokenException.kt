package com.jjarappappa.imom.global.security.jwt.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object InvalidTokenException: IMomException(ErrorCode.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}