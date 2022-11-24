package com.jjarappappa.imom.domain.information.presentation.dto

import com.jjarappappa.imom.domain.information.domain.Category

data class FindInformationRequest(
    val category: Category,
)
