package com.jjarappappa.imom.domain.lecture.repository

import com.jjarappappa.imom.domain.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository: JpaRepository<Lecture, Long> {
}