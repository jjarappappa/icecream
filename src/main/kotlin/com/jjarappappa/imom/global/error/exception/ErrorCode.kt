package com.jjarappappa.imom.global.error.exception

enum class ErrorCode (
    val status: Int,
    val message: String,
){
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(404, "잘못된 요청입니다."),

    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),

    NICKNAME_ALREADY_EXISTS(422, "이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXISTS(422, "이미 존재하는 이메일입니다."),
    PHONE_NUMBER_ALREADY_EXISTS(422, "이미 존재하는 전화번호입니다."),
}