package com.jjarappappa.imom.domain.feed.domain.repository

import com.jjarappappa.imom.domain.feed.domain.Comment
import com.jjarappappa.imom.domain.feed.domain.Feed
import org.springframework.data.repository.CrudRepository

interface CommentRepository: CrudRepository<Comment, Long> {

    fun findAllByFeed(feed: Feed): List<Comment>
}