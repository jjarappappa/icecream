package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import org.springframework.data.repository.CrudRepository

interface LectureApplicationRepository: CrudRepository<LectureApplication, Long> {

    fun findAllByLectureId(lectureId: Long): List<LectureApplication>
    fun deleteByLectureIdAndUserId(lectureId: Long, userId: Long)
}