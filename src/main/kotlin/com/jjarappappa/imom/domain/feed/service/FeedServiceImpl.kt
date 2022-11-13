package com.jjarappappa.imom.domain.feed.service

import com.jjarappappa.imom.domain.feed.domain.Feed
import com.jjarappappa.imom.domain.feed.domain.repository.FeedRepository
import com.jjarappappa.imom.domain.feed.facade.FeedFacade
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.CreateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedDetailResponse
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedListResponse
import com.jjarappappa.imom.domain.user.facade.UserFacade
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse
import org.springframework.stereotype.Service

@Service
class FeedServiceImpl(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
): FeedService {
    override fun getFeedList(): FeedListResponse {
        TODO("Not yet implemented")
    }

    override fun getFeedDetail(feedId: Long): FeedDetailResponse {
        val feed = feedFacade.getFeed(feedId)

        return FeedDetailResponse(
            title = feed.title,
            content = feed.content,
            type = feed.type,
            user = UserProfileResponse.of(feed.user),
            createdAt = feed.createdAt!!
        )
    }

    override fun createFeed(request: CreateFeedRequest) {
        val user = userFacade.getCurrentUser()
        feedRepository.save(
            Feed(
                title = request.title,
                content = request.content,
                type = request.type,
                user = user
            )
        )
    }

    override fun updateFeed(feedId: Long, request: UpdateFeedRequest) {
        val feed = feedFacade.getFeed(feedId)
        feed.updateFeed(request)
    }

    override fun deleteFeed(feedId: Long) {
        feedRepository.deleteById(feedId)
    }
}