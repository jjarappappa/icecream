package com.jjarappappa.imom.domain.youtube.presentation.dto.request

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateYoutubeRequest(

    @field:Min(1)
    @field:Max(120)
    @field:NotBlank
    val url: String,

    @field:Min(1)
    @field:Max(50)
    @field:NotBlank
    val title: String,
)