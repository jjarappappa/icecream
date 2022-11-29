package com.jjarappappa.imom.domain.lecture.service

import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import com.jjarappappa.imom.domain.lecture.domain.repository.LectureApplicationRepository
import com.jjarappappa.imom.domain.lecture.facade.LectureFacade
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureApplicationService(
    private val lectureApplicationRepository: LectureApplicationRepository,
    private val userFacade: UserFacade,
    private val lectureFacade: LectureFacade,
) {

    @Transactional
    fun applyLecture(id: Long) {
        val user = userFacade.getCurrentUser()
        val lecture = lectureFacade.getLecture(id)

        lectureApplicationRepository.save(
            LectureApplication(lecture, user)
        )
    }

    @Transactional
    fun cancelLectureApplication(id: Long) {
        val user = userFacade.getCurrentUser()
        val lecture = lectureFacade.getLecture(id)

        lectureApplicationRepository.deleteByLectureAndUser(lecture, user)
    }
}