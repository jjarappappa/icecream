package com.jjarappappa.imom.global.error.exception

open class IceCreamException (
    val errorCode: ErrorCode,
    message: String,
): RuntimeException(message) {
    constructor(errorCode: ErrorCode): this(errorCode, errorCode.message)
}