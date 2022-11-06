package com.jjarappappa.imom.domain.board.presentation

import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.CreateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.UpdateBoardRequest
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardDetailResponse
import com.jjarappappa.imom.domain.board.presentation.dto.response.BoardListResponse
import com.jjarappappa.imom.domain.board.service.BoardServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/board")
class BoardController(
    private val boardService: BoardServiceImpl,
) {

    @GetMapping
    fun getBoardList(): BoardListResponse {
        return boardService.getBoardList()
    }

    @GetMapping("/{board-id}")
    fun getBoard(@PathVariable(name = "board-id") boardId: Long): BoardDetailResponse {
        return boardService.getBoardDetail(boardId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBoard(@RequestBody @Valid request: CreateBoardRequest) {
        boardService.createBoard(request)
    }

    @PutMapping("/{board-id}")
    fun updateBoard(@PathVariable(name = "board-id") boardId: Long, @RequestBody @Valid request: UpdateBoardRequest) {
        boardService.updateBoard(boardId, request)
    }

    @DeleteMapping("/{board-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBoard(@PathVariable(name = "board-id") boardId: Long) {
        boardService.deleteBoard(boardId)
    }
}