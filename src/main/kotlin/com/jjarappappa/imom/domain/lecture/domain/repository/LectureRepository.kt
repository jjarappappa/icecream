package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LectureRepository : JpaRepository<Lecture, Long> {

    @Query("SELECT l FROM Lecture l " +
        "WHERE l.period >= current_date " +
        "ORDER BY l.period ASC")
    fun findAllLecture(): List<Lecture>
}