package com.jjarappappa.imom.domain.lecture.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class LectureErrorProperty(
    override val status: Int,
    override val message: String
) : ErrorProperty {
    LECTURE_NOT_FOUND(404, "존재하지 않는 강의입니다."),
    LECTURE_ALREADY_EXISTS(403, "이미 신청한 강의입니다."),
}