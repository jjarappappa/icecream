package com.jjarappappa.imom.domain.feed.domain.repository

import com.jjarappappa.imom.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<Feed, Long> {
}