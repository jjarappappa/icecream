package com.jjarappappa.imom.domain.youtube.facade

import com.jjarappappa.imom.domain.youtube.domain.Youtube
import com.jjarappappa.imom.domain.youtube.domain.repository.YoutubeRepository
import com.jjarappappa.imom.domain.youtube.exception.YoutubeNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class YoutubeFacade(
    private val youtubeRepository: YoutubeRepository,
) {
    fun getYoutubeById(id: String): Youtube {
        return youtubeRepository.findByIdOrNull(id)
            ?: throw YoutubeNotFoundException
    }
}
