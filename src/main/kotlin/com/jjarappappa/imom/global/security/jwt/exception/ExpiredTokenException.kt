package com.jjarappappa.imom.global.security.jwt.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object ExpiredTokenException: IMomException(ErrorCode.EXPIRED_TOKEN) {
    val EXCEPTION by lazy { this }
}
