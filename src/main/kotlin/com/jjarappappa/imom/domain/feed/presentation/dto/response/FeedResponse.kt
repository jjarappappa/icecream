package com.jjarappappa.imom.domain.feed.presentation.dto.response

import com.jjarappappa.imom.domain.feed.domain.Feed
import java.time.LocalDateTime

data class FeedResponse(
    val id: Long,
    val title: String,
    val username: String,
    val createdAt: LocalDateTime,
) {
    companion object {
        fun of(feed: Feed): FeedResponse {
            return FeedResponse(
                id = feed.id!!,
                title = feed.title,
                username = feed.user.name,
                createdAt = feed.createdAt!!
            )
        }
    }
}