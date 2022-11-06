package com.jjarappappa.imom.domain.board.presentation.dto.reqeust

import com.jjarappappa.imom.domain.board.domain.type.BoardType
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateBoardRequest(

    @field:NotBlank
    @field:Max(30)
    var title: String,

    @field:NotBlank
    @field:Max(2000)
    var content: String,

    @field:NotNull
    var type: BoardType,
)