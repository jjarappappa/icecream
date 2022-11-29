package com.jjarappappa.imom.domain.lecture.service

import com.jjarappappa.imom.domain.lecture.domain.repository.LectureRepository
import com.jjarappappa.imom.domain.lecture.facade.LectureFacade
import com.jjarappappa.imom.domain.lecture.presentation.dto.request.CreateLectureRequest
import com.jjarappappa.imom.domain.lecture.presentation.dto.request.UpdateLectureRequest
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureDetailResponse
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureListResponse
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureService(
    private val lectureRepository: LectureRepository,
    private val lectureFacade: LectureFacade,
) {

    @Transactional(readOnly = true)
    fun getLectureList(): LectureListResponse {
        return LectureListResponse(
            lectureRepository.findAllLecture().map(LectureResponse::of)
        )
    }

    @Transactional(readOnly = true)
    fun getLectureDetail(id: Long): LectureDetailResponse {
        val lecture = lectureFacade.getLecture(id)
        return LectureDetailResponse.of(lecture)
    }

    @Transactional
    fun createLecture(request: CreateLectureRequest) {
        lectureRepository.save(
            request.toEntity()
        )
    }

    @Transactional
    fun updateLecture(id: Long, request: UpdateLectureRequest) {
        val lecture = lectureFacade.getLecture(id)
        lecture.updateLecture(
            request.title,
            request.content,
            request.place,
            request.target,
            request.period,
            request.date
        )
    }

    @Transactional
    fun deleteLecture(id: Long) {
        lectureRepository.deleteById(id)
    }
}