package com.jjarappappa.imom.domain.lecture.presentation.dto.response

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import java.time.LocalDate
import java.time.LocalDateTime

data class LectureDetailResponse(
    val id: Long,
    val title: String,
    val content: String,
    val place: String,
    val target: String,
    val period: LocalDate,
    val date: LocalDate,
    val createdAt: LocalDateTime,
) {
    companion object {
        fun of(lecture: Lecture): LectureDetailResponse {
            return LectureDetailResponse(
                id = lecture.id!!,
                title = lecture.title,
                content = lecture.content,
                place = lecture.place,
                target = lecture.target,
                period = lecture.period,
                date = lecture.date,
                createdAt = lecture.createdAt!!
            )
        }
    }
}