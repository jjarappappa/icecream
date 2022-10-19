package com.jjarappappa.imom.domain.user.presentation.dto.response

import com.jjarappappa.imom.domain.user.domain.User

class UserProfileResponse (
    val name: String,

    var nickname: String,

    val email: String,

    var birthday: String,

    var phoneNumber: String,

    var address: String,
) {

    companion object {
        fun of(user: User): UserProfileResponse {
            return UserProfileResponse(
                user.name,
                user.nickname,
                user.email,
                user.birthday,
                user.phoneNumber,
                user.address,
            )
        }
    }
}
