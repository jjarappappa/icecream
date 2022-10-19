package com.jjarappappa.imom.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserUpdateRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    var nickname: String,

    @field:NotBlank
    var birthday: String,

    @field:NotBlank
    var address: String,
)
