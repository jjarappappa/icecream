package com.jjarappappa.imom.domain.lecture.presentation

import com.jjarappappa.imom.domain.lecture.presentation.dto.response.LectureApplicationResponse
import com.jjarappappa.imom.domain.lecture.service.LectureApplicationService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture/{id}/apply")
class LectureApplicationController(
    private val lectureApplicationService: LectureApplicationService,
) {

    @GetMapping
    fun getLectureApplication(@PathVariable id: Long): LectureApplicationResponse {
        return lectureApplicationService.getLectureApplication(id);
    }

    @PostMapping
    fun applyLecture(@PathVariable id: Long) {
        lectureApplicationService.applyLecture(id)
    }

    @DeleteMapping
    fun cancelLectureApplication(@PathVariable id: Long) {
        lectureApplicationService.cancelLectureApplication(id)
    }
}