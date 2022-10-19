package com.jjarappappa.imom.domain.user.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object UserNotFoundException: IMomException(ErrorCode.USER_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
