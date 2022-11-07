package com.jjarappappa.imom.domain.board.exception

import com.jjarappappa.imom.domain.board.exception.error.BoardErrorProperty
import com.jjarappappa.imom.domain.user.exception.error.UserErrorProperty
import com.jjarappappa.imom.global.error.exception.IMomException

object BoardNotFoundException: IMomException(BoardErrorProperty.BOARD_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
