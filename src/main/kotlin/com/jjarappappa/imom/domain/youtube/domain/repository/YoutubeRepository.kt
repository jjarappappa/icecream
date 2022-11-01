package com.jjarappappa.imom.domain.youtube.domain.repository

import com.jjarappappa.imom.domain.youtube.domain.Youtube
import org.springframework.data.repository.CrudRepository

interface YoutubeRepository: CrudRepository<Youtube, Long> {
}