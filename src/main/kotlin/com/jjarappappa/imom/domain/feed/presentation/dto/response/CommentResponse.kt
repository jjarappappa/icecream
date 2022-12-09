package com.jjarappappa.imom.domain.feed.presentation.dto.response

import com.jjarappappa.imom.domain.feed.domain.Comment
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse

data class CommentResponse(
    val id: Long,
    val comment: String,
    val user: UserProfileResponse
) {
    companion object {
        fun of(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id!!,
                comment = comment.comment,
                user = UserProfileResponse.of(comment.user)
            )
        }
    }
}
