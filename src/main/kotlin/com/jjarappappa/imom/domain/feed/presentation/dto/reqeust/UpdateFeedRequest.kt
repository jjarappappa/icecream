package com.jjarappappa.imom.domain.feed.presentation.dto.reqeust

import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateFeedRequest(

    @field:NotBlank
    @field:Size(max = 30)
    val title: String,

    @field:NotBlank
    @field:Size(max = 2000)
    val content: String,

    @field:NotNull
    val type: FeedType,
)