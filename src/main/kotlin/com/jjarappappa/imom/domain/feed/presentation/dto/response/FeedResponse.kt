package com.jjarappappa.imom.domain.feed.presentation.dto.response

import java.time.LocalDateTime

data class FeedResponse(
    val id: Long,
    val title: String,
    val username: String,
    val createdAt: LocalDateTime,
)