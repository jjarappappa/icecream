package com.jjarappappa.imom.global.error.exception

open class IMomException (
    val errorCode: ErrorCode,
    message: String,
): RuntimeException(message) {
    constructor(errorCode: ErrorCode): this(errorCode, errorCode.message)
}