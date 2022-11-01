package com.jjarappappa.imom.domain.youtube.domain.repository

import com.jjarappappa.imom.domain.youtube.domain.Youtube
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface YoutubeRepository: JpaRepository<Youtube, String> {
    fun findByOrderByIdDesc(pageable: Pageable): List<Youtube>
}