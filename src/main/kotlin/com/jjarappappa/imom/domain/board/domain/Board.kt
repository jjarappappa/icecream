package com.jjarappappa.imom.domain.board.domain

import com.jjarappappa.imom.domain.board.domain.type.BoardType
import com.jjarappappa.imom.domain.board.presentation.dto.reqeust.UpdateBoardRequest
import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_board")
class Board(
    @Column(length = 30, nullable = false)
    var title: String,

    @Column(length = 2000, nullable = false)
    var content: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var type: BoardType,

    @ManyToOne(fetch = FetchType.LAZY)
    var user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
): BaseTimeEntity() {

    fun updateBoard(request: UpdateBoardRequest) {
        this.title = request.title
        this.content = request.content
        this.type = request.type
    }
}