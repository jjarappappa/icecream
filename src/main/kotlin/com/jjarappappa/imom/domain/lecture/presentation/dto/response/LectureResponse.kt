package com.jjarappappa.imom.domain.lecture.presentation.dto.response

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import java.time.LocalDate

data class LectureResponse(
    val id: Long,
    val title: String,
    val place: String,
    val date: LocalDate,
) {
    companion object {
        fun of(lecture: Lecture): LectureResponse {
            return LectureResponse(
                id = lecture.id!!,
                title = lecture.title,
                place = lecture.place,
                date = lecture.date
            )
        }
    }
}