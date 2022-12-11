package com.jjarappappa.imom.domain.feed.presentation.dto.reqeust

import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank

data class AddCommentRequest(

    @field:NotBlank
    @field:Max(200)
    var comment: String,
)