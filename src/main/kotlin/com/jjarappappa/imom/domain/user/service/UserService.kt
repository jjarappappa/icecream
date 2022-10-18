package com.jjarappappa.imom.domain.user.service

import com.jjarappappa.imom.domain.user.domain.repository.UserRepository
import com.jjarappappa.imom.domain.user.facade.UserFacade
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun createUser(request: UserJoinRequest) {

        userFacade.validateCreateUser(request);
        userRepository.save(request.toEntity());
    }
}
