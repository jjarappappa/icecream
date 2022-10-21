package com.jjarappappa.imom.infrastructure.image.s3.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object ImageEmptyException: IMomException(ErrorCode.IMAGE_EMPTY) {
    val EXCEPTION by lazy { this }
}
