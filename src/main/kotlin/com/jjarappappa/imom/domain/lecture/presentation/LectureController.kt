package com.jjarappappa.imom.domain.lecture.presentation

import com.jjarappappa.imom.domain.lecture.presentation.dto.request.CreateLectureRequest
import com.jjarappappa.imom.domain.lecture.presentation.dto.request.UpdateLectureRequest
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureDetailResponse
import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureListResponse
import com.jjarappappa.imom.domain.lecture.service.LectureService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture")
class LectureController(
    private val lectureService: LectureService,
) {

    @GetMapping
    fun getLectureList(): LectureListResponse {
        return lectureService.getLectureList();
    }

    @GetMapping("/{id}")
    fun getLectureDetail(@RequestParam id: Long): LectureDetailResponse {
        return lectureService.getLectureDetail(id)
    }

    @PostMapping
    fun createLecture(@RequestBody request: CreateLectureRequest) {
        lectureService.createLecture(request)
    }

    @PutMapping("/{id}")
    fun updateLecture(@PathVariable id: Long, @RequestBody request: UpdateLectureRequest) {
        lectureService.updateLecture(id, request)
    }

    @DeleteMapping("/{id}")
    fun deleteLecture(@PathVariable id: Long) {
        lectureService.deleteLecture(id)
    }
}