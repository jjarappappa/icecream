package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository: JpaRepository<Lecture, Long> {
}