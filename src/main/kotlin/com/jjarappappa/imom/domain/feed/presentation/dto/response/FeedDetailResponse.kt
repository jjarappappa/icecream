package com.jjarappappa.imom.domain.feed.presentation.dto.response

import com.jjarappappa.imom.domain.feed.domain.Feed
import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse
import java.time.LocalDateTime

data class FeedDetailResponse(
    val title: String,
    val content: String,
    val type: FeedType,
    val user: UserProfileResponse,
    val createdAt: LocalDateTime,

    // TODO :: 댓글 추가
) {
    companion object {
        fun of(feed: Feed): FeedDetailResponse {
            return FeedDetailResponse(
                title = feed.title,
                content = feed.content,
                type = feed.type,
                user = UserProfileResponse.of(feed.user),
                createdAt = feed.createdAt!!
            )
        }
    }
}