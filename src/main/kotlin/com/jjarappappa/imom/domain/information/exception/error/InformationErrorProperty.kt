package com.jjarappappa.imom.domain.information.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class InformationErrorProperty(
    override val status: Int,
    override val message: String,
) : ErrorProperty {
    INFORMATION_NOT_FOUND(404, "존재하지 않는 정보입니다.")
}