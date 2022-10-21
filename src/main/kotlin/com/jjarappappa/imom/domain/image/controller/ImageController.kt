package com.jjarappappa.imom.domain.image.controller

import com.jjarappappa.imom.domain.image.controller.dto.ImageUrlResponse
import com.jjarappappa.imom.domain.image.service.ImageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController constructor(
    val imageService: ImageService,
) {

    @PostMapping
    fun saveImage(@RequestPart images: List<MultipartFile>): ImageUrlResponse {
        return imageService.imgUpload(images)
    }
}