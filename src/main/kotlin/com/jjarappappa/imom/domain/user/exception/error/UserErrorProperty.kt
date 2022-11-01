package com.jjarappappa.imom.domain.user.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class UserErrorProperty(
    override val status: Int,
    override val message: String
): ErrorProperty {
    NICKNAME_ALREADY_EXISTS(422, "이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXISTS(422, "이미 존재하는 이메일입니다."),
    PHONE_NUMBER_ALREADY_EXISTS(422, "이미 존재하는 전화번호입니다."),
    USER_NOT_FOUND( 404, "존재하지 않는 유저입니다."),
    PASSWORD_MISMATCH( 401, "비밀번호가 틀렸습니다."),
}