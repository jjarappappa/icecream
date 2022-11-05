package com.jjarappappa.imom.domain.board.service

import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.CreateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.UpdateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardDetailResponse
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardListResponse

interface BoardService {
    fun getBoardList(): BoardListResponse
    fun getBoardDetail(boardId: Long): BoardDetailResponse
    fun createBoard(createBoardRequest: CreateBoardRequest): Nothing
    fun updateBoard(boardId: Long, updateBordRequest: UpdateBoardRequest): Nothing
    fun deleteBoard(boardId: Long): Nothing
}