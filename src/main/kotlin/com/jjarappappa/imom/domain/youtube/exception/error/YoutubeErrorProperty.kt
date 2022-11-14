package com.jjarappappa.imom.domain.youtube.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class YoutubeErrorProperty(
    override val status: Int,
    override val message: String
): ErrorProperty {
    YOUTUBE_NOT_FOUND( 404, "존재하지 않는 유튜브입니다."),
}