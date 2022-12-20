package com.jjarappappa.imom.domain.lecture.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.jjarappappa.imom.domain.lecture.domain.Lecture
import java.time.LocalDate
import javax.validation.constraints.NotBlank


data class CreateLectureRequest(

    @field:NotBlank
    var title: String,

    @field:NotBlank
    val content: String,

    @field:NotBlank
    val place: String,

    @field:NotBlank
    val target: String,

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "Asia/Seoul"
    )
    val period: LocalDate,

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "Asia/Seoul"
    )
    val date: LocalDate,

    @field:NotBlank
    val teacher: String,

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "Asia/Seoul"
    )
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
