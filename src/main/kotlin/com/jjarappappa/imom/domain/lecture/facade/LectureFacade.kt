package com.jjarappappa.imom.domain.lecture.facade

import com.jjarappappa.imom.domain.lecture.domain.Lecture
import com.jjarappappa.imom.domain.lecture.domain.repository.LectureRepository
import com.jjarappappa.imom.domain.lecture.exception.LectureNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class LectureFacade(
    private val lectureRepository: LectureRepository,
) {

    @Transactional(readOnly = true)
    fun getLecture(id: Long): Lecture {
        return lectureRepository.findByIdOrNull(id)
            ?: throw LectureNotFoundException.EXCEPTION;
    }
}