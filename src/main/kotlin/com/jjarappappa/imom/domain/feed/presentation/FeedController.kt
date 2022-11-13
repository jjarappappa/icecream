package com.jjarappappa.imom.domain.feed.presentation

import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.CreateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedDetailResponse
import com.jjarappappa.imom.domain.feed.presentation.dto.response.FeedListResponse
import com.jjarappappa.imom.domain.feed.service.FeedServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/feed")
class FeedController(
    private val feedService: FeedServiceImpl,
) {

    @GetMapping
    fun getFeedList(): FeedListResponse {
        return feedService.getFeedList()
    }

    @GetMapping("/{feed-id}")
    fun getFeed(@PathVariable(name = "feed-id") feedId: Long): FeedDetailResponse {
        return feedService.getFeedDetail(feedId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        feedService.createFeed(request)
    }

    @PutMapping("/{feed-id}")
    fun updateFeed(@PathVariable(name = "feed-id") feedId: Long, @RequestBody @Valid request: UpdateFeedRequest) {
        feedService.updateFeed(feedId, request)
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteFeed(@PathVariable(name = "feed-id") feedId: Long) {
        feedService.deleteFeed(feedId)
    }
}