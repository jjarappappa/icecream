package com.jjarappappa.imom.domain.user.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object PasswordMismatchException: IMomException(ErrorCode.PASSWORD_MISMATCH) {
    val EXCEPTION by lazy { this }
}
