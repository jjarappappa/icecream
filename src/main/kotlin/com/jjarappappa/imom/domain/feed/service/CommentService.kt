package com.jjarappappa.imom.domain.feed.service

import com.jjarappappa.imom.domain.feed.domain.Comment
import com.jjarappappa.imom.domain.feed.domain.repository.CommentRepository
import com.jjarappappa.imom.domain.feed.facade.FeedFacade
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.AddCommentRequest
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
) {
    fun addComment(id: Long, request: AddCommentRequest) {
        commentRepository.save(
            Comment(
                user = userFacade.getCurrentUser(),
                feed = feedFacade.getFeed(id),
                comment = request.comment
            )
        )
    }
}