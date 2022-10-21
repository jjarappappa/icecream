package com.jjarappappa.imom.infrastructure.image.s3.exception

import com.jjarappappa.imom.global.error.exception.ErrorCode
import com.jjarappappa.imom.global.error.exception.IMomException

object UploadImageFailedException: IMomException(ErrorCode.UPLOAD_IMAGE_FAILED) {
    val EXCEPTION by lazy { this }
}
