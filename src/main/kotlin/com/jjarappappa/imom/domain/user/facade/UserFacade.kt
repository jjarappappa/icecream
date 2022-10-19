package com.jjarappappa.imom.domain.user.facade

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.domain.repository.UserRepository
import com.jjarappappa.imom.domain.user.exception.*
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import com.jjarappappa.imom.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserFacade (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
){

    fun validateCreateUser(request: UserJoinRequest) {

        if(userRepository.existsByEmail(request.email)) {
            throw EmailAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw PhoneNumberAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByNickName(request.nickName)) {
            throw NickNameAlreadyExists.EXCEPTION
        }
    }

    fun findUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun checkPassword(actual: String, expected: String) {
        if (passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION
        }
    }

    fun getCurrentUser(): User {
        val auth: AuthDetails =
            SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return findUserByEmail(auth.username)
    }
}
