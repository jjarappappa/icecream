package com.jjarappappa.imom.global.error

import com.jjarappappa.imom.global.error.exception.ErrorCode

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message)
}