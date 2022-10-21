package com.jjarappappa.imom.domain.user.presentation.dto.request

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.domain.type.Authority
import com.jjarappappa.imom.infrastructure.image.s3.DefaultProfileImage
import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserJoinRequest (

    @field:NotBlank
    val name: String,

    @field:NotBlank
    var nickName: String,

    @field:Email
    val email: String,

    @field:NotBlank
    var password: String,

    @field:NotBlank
    var birthday: String,

    @field:NotBlank
    var phoneNumber: String,

    @field:NotBlank
    var address: String,
){

    fun toEntity(passwordEncoder: PasswordEncoder): User {
        return User(
            name,
            nickName,
            email,
            passwordEncoder.encode(password),
            Authority.USER,
            birthday,
            phoneNumber,
            address,
            DefaultProfileImage.URL
        )
    }
}
