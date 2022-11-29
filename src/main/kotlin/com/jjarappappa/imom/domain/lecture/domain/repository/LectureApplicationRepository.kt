package com.jjarappappa.imom.domain.lecture.domain.repository

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import com.jjarappappa.imom.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface LectureApplicationRepository: CrudRepository<LectureApplication, Long> {

    fun deleteByLectureAndUser(lecture: Lecture, user: User)
}