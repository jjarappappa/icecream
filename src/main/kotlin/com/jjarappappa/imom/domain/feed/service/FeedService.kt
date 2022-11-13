package com.jjarappappa.imom.domain.feed.service

import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.CreateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedDetailResponse
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedListResponse

interface FeedService {
    fun getFeedList(): FeedListResponse
    fun getFeedDetail(feedId: Long): FeedDetailResponse
    fun createFeed(request: CreateFeedRequest)
    fun updateFeed(feedId: Long, request: UpdateFeedRequest)
    fun deleteFeed(feedId: Long)
}