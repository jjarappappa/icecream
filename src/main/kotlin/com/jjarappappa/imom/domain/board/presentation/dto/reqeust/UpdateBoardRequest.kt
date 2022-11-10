package com.jjarappappa.imom.domain.board.presentation.dto.reqeust

import com.jjarappappa.imom.domain.board.domain.type.BoardType
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateBoardRequest(

    @field:NotBlank
    @field:Max(30)
    val title: String,

    @field:NotBlank
    @field:Max(2000)
    val content: String,

    @field:NotNull
    val type: BoardType,
)