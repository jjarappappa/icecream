package com.jjarappappa.imom.domain.youtube.presentation.dto.request

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class UpdateYoutubeRequest(

    @field:Min(1)
    @field:Max(50)
    @field:NotBlank
    val title: String,
)