package com.jjarappappa.imom.domain.lecture.exception

import com.jjarappappa.imom.domain.lecture.exception.error.LectureErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object LectureNotFoundException: IMomException(LectureErrorProperty.LECTURE_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
