package com.jjarappappa.imom.domain.board.service

import com.jjarappappa.imom.domain.board.domain.repository.BoardRepository
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.CreateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.UpdateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardDetailResponse
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardListResponse
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository,
): BoardService {
    override fun getBoardList(): BoardListResponse {
        TODO("Not yet implemented")
    }

    override fun getBoardDetail(boardId: Long): BoardDetailResponse {
        TODO("Not yet implemented")
    }

    override fun createBoard(createBoardRequest: CreateBoardRequest): Nothing {
        TODO("Not yet implemented")
    }

    override fun updateBoard(boardId: Long, updateBordRequest: UpdateBoardRequest): Nothing {
        TODO("Not yet implemented")
    }

    override fun deleteBoard(boardId: Long): Nothing {
        TODO("Not yet implemented")
    }

}