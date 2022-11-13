package com.jjarappappa.imom.domain.feed.domain.repository

import com.jjarappappa.imom.domain.feed.domain.Feed
import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<Feed, Long> {
    fun findFeedsByType(type: FeedType, pageable: Pageable): List<Feed>
}