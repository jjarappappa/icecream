package com.jjarappappa.imom.domain.feed.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class FeedErrorProperty(
    override val status: Int,
    override val message: String
): ErrorProperty {
    FEED_NOT_FOUND( 404, "존재하지 않는 글입니다.")
}