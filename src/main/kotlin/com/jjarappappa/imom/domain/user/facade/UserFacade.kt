package com.jjarappappa.imom.domain.user.facade

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.domain.repository.UserRepository
import com.jjarappappa.imom.domain.user.exception.*
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import com.jjarappappa.imom.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade (
    private val userRepository: UserRepository,
){

    fun validateCreateUser(request: UserJoinRequest) {

        if(userRepository.existsByEmail(request.email)) {
            throw EmailAlreadyExistsException.EXCEPTION
        }

        if(userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw PhoneNumberAlreadyExistsException.EXCEPTION
        }

        if(userRepository.existsByNickname(request.nickname)) {
            throw NickNameAlreadyExistsException.EXCEPTION
        }
    }

    fun findUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val auth: AuthDetails =
            SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return findUserByEmail(auth.username)
    }
}
