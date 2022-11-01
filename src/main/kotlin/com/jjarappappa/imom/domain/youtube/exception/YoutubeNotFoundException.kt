package com.jjarappappa.imom.domain.youtube.exception

import com.jjarappappa.imom.domain.youtube.exception.error.YoutubeErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object YoutubeNotFoundException: IMomException(YoutubeErrorProperty.YOUTUBE_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
