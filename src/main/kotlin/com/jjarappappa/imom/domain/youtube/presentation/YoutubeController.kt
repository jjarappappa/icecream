package com.jjarappappa.imom.domain.youtube.presentation

import com.jjarappappa.imom.domain.youtube.presentation.dto.request.CreateYoutubeRequest
import com.jjarappappa.imom.domain.youtube.presentation.dto.request.UpdateYoutubeRequest
import com.jjarappappa.imom.domain.youtube.presentation.dto.response.YoutubeListResponse
import com.jjarappappa.imom.domain.youtube.service.YoutubeService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class YoutubeController(
    private val youtubeService: YoutubeService,
) {
    @GetMapping
    fun getYoutube(pageable: Pageable): YoutubeListResponse {
        return youtubeService.getYoutube(pageable)
    }

    @PostMapping
    fun postYoutube(@RequestBody @Valid request: CreateYoutubeRequest) {
        youtubeService.postYoutube(request)
    }

    @PutMapping
    fun updateYoutube(@RequestParam id: String, @RequestBody @Valid request: UpdateYoutubeRequest) {
        youtubeService.updateYoutube(id, request)
    }

    @DeleteMapping
    fun deleteYoutube(@RequestParam id: String) {
        youtubeService.deleteYoutube(id)
    }
}