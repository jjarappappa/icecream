package com.jjarappappa.imom.domain.user.presentation.dto.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class UserUpdateRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    var nickname: String,

    @field:NotBlank
    var birthday: LocalDate,

    @field:NotBlank
    var address: String,
)
