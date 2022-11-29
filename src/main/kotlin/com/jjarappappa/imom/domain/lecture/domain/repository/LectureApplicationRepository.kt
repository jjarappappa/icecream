package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LectureApplicationRepository : CrudRepository<LectureApplication, Long> {

    @Query("SELECT a FROM LectureApplication a JOIN FETCH a.user WHERE a.lecture.id = :lectureId")
    fun findAllByLectureId(lectureId: Long): List<LectureApplication>
    fun deleteByLectureIdAndUserId(lectureId: Long, userId: Long)
}