package com.jjarappappa.imom.domain.board.service

import com.jjarappappa.imom.domain.board.domain.Board
import com.jjarappappa.imom.domain.board.domain.repository.BoardRepository
import com.jjarappappa.imom.domain.board.facade.BoardFacade
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.CreateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.UpdateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardDetailResponse
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardListResponse
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository,
    private val userFacade: UserFacade,
    private val boardFacade: BoardFacade,
): BoardService {
    override fun getBoardList(): BoardListResponse {
        TODO("Not yet implemented")
    }

    override fun getBoardDetail(boardId: Long): BoardDetailResponse {
        TODO("Not yet implemented")
    }

    override fun createBoard(request: CreateBoardRequest) {
        val user = userFacade.getCurrentUser()
        boardRepository.save(
            Board(
                title = request.title,
                content = request.content,
                type = request.type,
                user = user
            )
        )
    }

    override fun updateBoard(boardId: Long, request: UpdateBoardRequest) {
        val board = boardFacade.getBoard(boardId)
        board.updateBoard(request)
    }

    override fun deleteBoard(boardId: Long) {
        boardRepository.deleteById(boardId)
    }
}