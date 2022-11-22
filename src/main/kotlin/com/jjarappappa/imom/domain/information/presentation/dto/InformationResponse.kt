package com.jjarappappa.imom.domain.information.presentation.dto

import com.jjarappappa.imom.domain.information.Information

data class InformationResponse(
    val title: String,
    val content: String,
    val userName: String,
    val images: MutableList<String>,
) {
    companion object {
        fun of(information: Information): InformationResponse {
            return InformationResponse(
                title = information.title,
                content = information.content,
                userName = information.user.nickname,
                images = information.images
            )
        }
    }
}
