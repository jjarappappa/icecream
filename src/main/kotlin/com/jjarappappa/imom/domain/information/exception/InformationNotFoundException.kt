package com.jjarappappa.imom.domain.information.exception

import com.jjarappappa.imom.domain.information.exception.error.InformationErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object InformationNotFoundException: IMomException(InformationErrorProperty.INFORMATION_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}