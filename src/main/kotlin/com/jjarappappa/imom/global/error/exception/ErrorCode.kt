package com.jjarappappa.imom.global.error.exception

enum class ErrorCode (
    override val status: Int,
    override val message: String,
): ErrorProperty {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(404, "잘못된 요청입니다."),
}