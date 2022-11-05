package com.jjarappappa.imom.domain.board.domain.repository

import com.jjarappappa.imom.domain.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long> {
}