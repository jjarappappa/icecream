package com.jjarappappa.imom.domain.lecture.exception

import com.jjarappappa.imom.domain.lecture.exception.error.LectureErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object LectureAlreadyExistsException : IMomException(LectureErrorProperty.LECTURE_ALREADY_EXISTS) {
    val EXCEPTION by lazy { this }
}
