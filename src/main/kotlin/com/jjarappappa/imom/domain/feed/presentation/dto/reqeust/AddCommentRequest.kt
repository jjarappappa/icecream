package com.jjarappappa.imom.domain.feed.presentation.dto.reqeust

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AddCommentRequest(

    @field:NotBlank
    @field:Size(max = 200)
    var comment: String,
)