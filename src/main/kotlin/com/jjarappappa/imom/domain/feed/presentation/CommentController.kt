package com.jjarappappa.imom.domain.feed.presentation

import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.AddCommentRequest
import com.jjarappappa.imom.domain.feed.service.CommentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/feed/{feed-id}/comment")
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun addComment(@PathVariable(name = "feed-id") feedId: Long, @RequestBody @Valid request: AddCommentRequest) {
        commentService.addComment(feedId, request)
    }

    @DeleteMapping
    fun deleteComment(@PathVariable(name = "feed-id") feedId: Long, @RequestParam commentId: Long) {
        commentService.deleteComment(commentId)
    }
}