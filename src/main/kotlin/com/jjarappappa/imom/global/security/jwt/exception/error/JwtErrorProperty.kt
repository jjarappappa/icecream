package com.jjarappappa.imom.global.security.jwt.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class JwtErrorProperty(
    override val status: Int,
    override val message: String
) : ErrorProperty {
    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
}