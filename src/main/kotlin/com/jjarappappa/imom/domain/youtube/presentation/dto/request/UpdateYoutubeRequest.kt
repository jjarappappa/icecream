package com.jjarappappa.imom.domain.youtube.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateYoutubeRequest(

    @field:NotBlank
    @field:Size(max = 50)
    val title: String,
)