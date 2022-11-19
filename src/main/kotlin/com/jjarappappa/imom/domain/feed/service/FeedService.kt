package com.jjarappappa.imom.domain.feed.service

import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.CreateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedDetailResponse
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedListResponse
import org.springframework.data.domain.Pageable

interface FeedService {
    fun getFeedList(type: FeedType, pageable: Pageable): FeedListResponse
    fun getFeedDetail(feedId: Long): FeedDetailResponse
    fun createFeed(request: CreateFeedRequest)
    fun updateFeed(feedId: Long, request: UpdateFeedRequest)
    fun deleteFeed(feedId: Long)
}