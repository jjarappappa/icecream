package com.jjarappappa.imom.domain.user.presentation.dto.request

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.domain.type.Authority

class UserJoinRequest (
    val name: String,
    var nickName: String,
    val email: String,
    var password: String,
    var birthday: String,
    var phoneNumber: String,
    var address: String,
){

    fun toEntity(): User {
        return User(
            name,
            nickName,
            email,
            password,
            Authority.USER,
            birthday,
            phoneNumber,
            address,
        )
    }
}
