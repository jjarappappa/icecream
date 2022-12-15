package com.jjarappappa.imom.domain.lecture.service

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import com.jjarappappa.imom.domain.lecture.domain.repository.LectureApplicationRepository
import com.jjarappappa.imom.domain.lecture.exception.LectureAlreadyExistsException
import com.jjarappappa.imom.domain.lecture.facade.LectureFacade
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureApplicationResponse
import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureApplicationService(
    private val lectureApplicationRepository: LectureApplicationRepository,
    private val userFacade: UserFacade,
    private val lectureFacade: LectureFacade,
) {

    @Transactional(readOnly = true)
    fun getLectureApplication(id: Long): LectureApplicationResponse {
        val lectureApplicationList = lectureApplicationRepository.findAllByLectureId(id)
        return LectureApplicationResponse.of(lectureApplicationList)
    }

    @Transactional
    fun applyLecture(id: Long) {
        val user = userFacade.getCurrentUser()
        val lecture = lectureFacade.getLecture(id)
        checkLectureApplicationIsValid(user, lecture)

        lectureApplicationRepository.save(
            LectureApplication(lecture, user)
        )
    }

    private fun checkLectureApplicationIsValid(user: User, lecture: Lecture) {
        if (lectureApplicationRepository.existsByUserAndLecture(user, lecture)) {
            throw LectureAlreadyExistsException.EXCEPTION
        }
    }

    @Transactional
    fun cancelLectureApplication(id: Long) {
        val user = userFacade.getCurrentUser()

        lectureApplicationRepository.deleteByLectureIdAndUserId(id, user.id!!)
    }
}