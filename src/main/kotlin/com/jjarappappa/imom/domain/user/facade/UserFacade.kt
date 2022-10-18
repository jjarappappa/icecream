package com.jjarappappa.imom.domain.user.facade

import com.jjarappappa.imom.domain.user.domain.repository.UserRepository
import com.jjarappappa.imom.domain.user.exception.EmailAlreadyExists
import com.jjarappappa.imom.domain.user.exception.NickNameAlreadyExists
import com.jjarappappa.imom.domain.user.exception.PhoneNumberAlreadyExists
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import org.springframework.stereotype.Component

@Component
class UserFacade (
    private val userRepository: UserRepository,
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
}
