package com.jjarappappa.imom.domain.feed.presentation.dto.reqeust

import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateFeedRequest(

    @field:NotBlank
    @field:Size(max = 30)
    var title: String,

    @field:NotBlank
    @field:Size(max = 2000)
    var content: String,

    @field:NotNull
    var type: FeedType,
)