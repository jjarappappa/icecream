package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import com.jjarappappa.imom.domain.user.domain.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LectureApplicationRepository : CrudRepository<LectureApplication, Long> {

    @Query("SELECT a FROM LectureApplication a JOIN FETCH a.user WHERE a.lecture.id = :lectureId")
    fun findAllByLectureId(lectureId: Long): List<LectureApplication>
    fun deleteByLectureIdAndUserId(lectureId: Long, userId: Long)
    fun existsByUserAndLecture(user: User, lecture: Lecture): Boolean
}