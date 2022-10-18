package com.jjarappappa.imom.domain.user.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IceCreamException

object EmailAlreadyExists: IceCreamException(ErrorCode.EMAIL_ALREADY_EXISTS) {
    val EXCEPTION by lazy { this }
}
