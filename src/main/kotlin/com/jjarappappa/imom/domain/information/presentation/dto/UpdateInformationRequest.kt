package com.jjarappappa.imom.domain.information.presentation.dto

data class UpdateInformationRequest(
    val id: Long,
    val title: String,
    val content: String,
    val images: List<String>,
)
