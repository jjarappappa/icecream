package com.jjarappappa.imom.domain.lecture.presentation.dto.response

import com.jjarappappa.imom.domain.lecture.domain.LectureApplication
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse

data class LectureApplicationResponse(
    val userList: List<UserProfileResponse>
) {
    companion object {
        fun of(lectureApplicationList: List<LectureApplication>): LectureApplicationResponse {
            return LectureApplicationResponse(
                userList = lectureApplicationList.map { UserProfileResponse.of(it.user) }
            )
        }
    }
}