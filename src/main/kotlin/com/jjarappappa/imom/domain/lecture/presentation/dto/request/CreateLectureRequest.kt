package com.jjarappappa.imom.domain.lecture.presentation.dto.request

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import java.time.LocalDate


data class CreateLectureRequest(
    val title: String,
    val content: String,
    val place: String,
    val target: String,
    val period: LocalDate,
    val date: LocalDate,
    val teacher: String,
    val luckyDate: LocalDate
) {

    fun toEntity(): Lecture {
        return Lecture(
            title = title,
            content = content,
            place = place,
            target = target,
            period = period,
            date = date,
            teacher = teacher,
            luckyDate = luckyDate
        )
    }
}
