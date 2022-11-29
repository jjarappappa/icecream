package com.jjarappappa.imom.domain.lecture.presentation.dto.request

import java.time.LocalDate


data class UpdateLectureRequest(
    val title: String,
    val content: String,
    val place: String,
    val target: String,
    val period: LocalDate,
    val date: LocalDate,
)