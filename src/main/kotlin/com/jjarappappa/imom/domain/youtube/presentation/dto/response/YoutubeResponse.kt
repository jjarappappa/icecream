package com.jjarappappa.imom.domain.youtube.presentation.dto.response

import com.jjarappappa.imom.domain.youtube.domain.Youtube
import com.jjarappappa.imom.domain.youtube.domain.property.YoutubeProperty

data class YoutubeResponse(
    val id: String,
    val url: String,
    val thumbnailUrl: String,
    val title: String,
) {
    companion object {
        fun of(youtube: Youtube): YoutubeResponse {
            return YoutubeResponse(
                id = youtube.id,
                url = YoutubeProperty.linkFormat.format(youtube.id),
                thumbnailUrl = YoutubeProperty.thumbnailFormat.format(youtube.id),
                title = youtube.title
            )
        }
    }
}
