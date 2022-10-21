package com.jjarappappa.imom.domain.user.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class UserUpdateRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    var nickname: String,

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "Asia/Seoul"
    )
    var birthday: LocalDate,

    @field:NotBlank
    var address: String,
)
