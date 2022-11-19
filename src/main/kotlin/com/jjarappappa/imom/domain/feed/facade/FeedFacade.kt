package com.jjarappappa.imom.domain.feed.facade

import com.jjarappappa.imom.domain.feed.domain.Feed
import com.jjarappappa.imom.domain.feed.domain.repository.FeedRepository
import com.jjarappappa.imom.domain.feed.exception.FeedNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class FeedFacade(
    private val feedRepository: FeedRepository,
) {

    @Transactional(readOnly = true)
    fun getFeed(feedId: Long): Feed {
        return feedRepository.findByIdOrNull(feedId)
            ?: throw FeedNotFoundException.EXCEPTION
    }
}