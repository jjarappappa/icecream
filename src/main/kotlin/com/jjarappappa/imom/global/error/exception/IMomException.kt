package com.jjarappappa.imom.global.error.exception

open class IMomException (
    val errorProperty: ErrorProperty,
): RuntimeException() {
}