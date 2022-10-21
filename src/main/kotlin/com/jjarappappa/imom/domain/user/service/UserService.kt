package com.jjarappappa.imom.domain.user.service

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.domain.user.domain.repository.UserRepository
import com.jjarappappa.imom.domain.user.exception.PasswordMismatchException
import com.jjarappappa.imom.domain.user.facade.UserFacade
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserLoginRequest
import com.jjarappappa.imom.domain.user.presentation.dto.response.TokenResponse
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse
import com.jjarappappa.imom.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
) {

    @Transactional
    fun createUser(request: UserJoinRequest) {

        userFacade.validateCreateUser(request);
        userRepository.save(request.toEntity(passwordEncoder));
    }

    @Transactional(readOnly = true)
    fun login(request: UserLoginRequest): TokenResponse {

        val user = userFacade.findUserByEmail(request.email)
        checkPassword(request.password, user.password)

        val accessToken = jwtProvider.createAccessToken(request.email)

        return TokenResponse(accessToken)
    }

    private fun checkPassword(actual: String, expected: String) {
        if (passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION
        }
    }

    @Transactional(readOnly = true)
    fun getProfile(): UserProfileResponse {
        val user = userFacade.getCurrentUser();
        return UserProfileResponse.of(user)
    }

    @Transactional
    fun updateProfileImage(img: String) {
        val user: User = userFacade.getCurrentUser()
        user.updateProfileImage(img)
    }
}
