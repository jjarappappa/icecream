package com.jjarappappa.imom.domain.information.presentation.dto.request

import com.jjarappappa.imom.domain.information.domain.Information
import com.jjarappappa.imom.domain.information.domain.type.Category
import com.jjarappappa.imom.domain.user.domain.User
import javax.validation.constraints.NotBlank

data class CreateInformationRequest(
    @NotBlank
    val title: String,

    @NotBlank
    val content: String,

    @NotBlank
    val category: Category,

    val images: MutableList<String>,
)

fun CreateInformationRequest.toEntity(user: User): Information {
    return Information(
        title = title,
        content = content,
        category = category,
        images = images,
        user = user,
    )
}