package com.jjarappappa.imom.domain.youtube.service

import com.jjarappappa.imom.domain.youtube.domain.Youtube
import com.jjarappappa.imom.domain.youtube.domain.property.YoutubeProperty
import com.jjarappappa.imom.domain.youtube.domain.repository.YoutubeRepository
import com.jjarappappa.imom.domain.youtube.facade.YoutubeFacade
import com.jjarappappa.imom.domain.youtube.presentation.dto.request.CreateYoutubeRequest
import com.jjarappappa.imom.domain.youtube.presentation.dto.request.UpdateYoutubeRequest
import com.jjarappappa.imom.domain.youtube.presentation.dto.response.YoutubeListResponse
import com.jjarappappa.imom.domain.youtube.presentation.dto.response.YoutubeResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class YoutubeService(
    private val youtubeFacade: YoutubeFacade,
    private val youtubeRepository: YoutubeRepository,
) {

    @Transactional(readOnly = true)
    fun getYoutube(pageable: Pageable): YoutubeListResponse {
        return YoutubeListResponse(
            youtubeList = youtubeRepository.findByOrderByIdDesc(pageable)
                .map { YoutubeResponse.of(it) }
        )
    }

    @Transactional
    fun postYoutube(request: CreateYoutubeRequest) {
        youtubeRepository.save(Youtube(
            title = request.title,
            id = request.url.split(YoutubeProperty.urlPrefix)[1]
        ))
    }

    @Transactional
    fun updateYoutube(id: String, request: UpdateYoutubeRequest) {
        val youtube = youtubeFacade.getYoutubeById(id)
        youtube.updateYoutube(request.title)
    }

    @Transactional
    fun deleteYoutube(id: String) {
        youtubeRepository.deleteById(id)
    }
}
