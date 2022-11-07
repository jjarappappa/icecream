package com.jjarappappa.imom.domain.board.facade

import com.jjarappappa.imom.domain.board.domain.Board
import com.jjarappappa.imom.domain.board.domain.repository.BoardRepository
import com.jjarappappa.imom.domain.board.exception.BoardNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class BoardFacade(
    private val boardRepository: BoardRepository,
) {

    @Transactional(readOnly = true)
    fun getBoard(boardId: Long): Board {
        return boardRepository.findByIdOrNull(boardId)
            ?: throw BoardNotFoundException.EXCEPTION
    }
}