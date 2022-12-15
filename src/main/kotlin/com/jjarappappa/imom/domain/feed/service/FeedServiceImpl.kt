package com.jjarappappa.imom.domain.feed.service

import com.jjarappappa.imom.domain.feed.domain.Feed
import com.jjarappappa.imom.domain.feed.domain.repository.CommentRepository
import com.jjarappappa.imom.domain.feed.domain.repository.FeedRepository
import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import com.jjarappappa.imom.domain.feed.facade.FeedFacade
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.CreateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.response.*
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FeedServiceImpl(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
    private val commentRepository: CommentRepository,
) : FeedService {
    override fun getFeedList(type: FeedType, pageable: Pageable): FeedListResponse {
        return FeedListResponse(
            feedList = feedRepository.findFeedsByTypeOrderByIdDesc(type, pageable)
                .map { FeedResponse.of(it) }
        )
    }

    override fun getFeedDetail(feedId: Long): FeedDetailResponse {
        val feed = feedFacade.getFeed(feedId)
        val commentList = CommentListResponse(
            commentRepository.findAllByFeed(feed).map { CommentResponse.of(it) })
        return FeedDetailResponse.of(feed, commentList)
    }

    override fun createFeed(request: CreateFeedRequest) {
        val user = userFacade.getCurrentUser()
        val feed = Feed(
            title = request.title,
            content = request.content,
            type = request.type,
            user = user
        )

        feedRepository.save(feed)
    }

    override fun updateFeed(feedId: Long, request: UpdateFeedRequest) {
        val feed = feedFacade.getFeed(feedId)
        feed.updateFeed(request)
    }

    override fun deleteFeed(feedId: Long) {
        feedRepository.deleteById(feedId)
    }
}