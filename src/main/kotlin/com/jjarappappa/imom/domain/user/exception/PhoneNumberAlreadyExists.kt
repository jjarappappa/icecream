package com.jjarappappa.imom.domain.user.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IceCreamException

object PhoneNumberAlreadyExists: IceCreamException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS) {
    val EXCEPTION by lazy { this }
}
