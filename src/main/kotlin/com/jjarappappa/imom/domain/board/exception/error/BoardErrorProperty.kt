package com.jjarappappa.imom.domain.board.exception.error

import com.jjarappappa.imom.global.error.exception.ErrorProperty

enum class BoardErrorProperty(
    override val status: Int,
    override val message: String
): ErrorProperty {
    BOARD_NOT_FOUND( 404, "존재하지 않는 글입니다.")
}