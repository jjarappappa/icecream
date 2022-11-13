package com.jjarappappa.imom.domain.feed.exception

import com.jjarappappa.imom.domain.feed.exception.error.FeedErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object FeedNotFoundException: IMomException(FeedErrorProperty.FEED_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
