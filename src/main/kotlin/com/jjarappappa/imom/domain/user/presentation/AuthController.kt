package com.jjarappappa.imom.domain.user.presentation

import com.jjarappappa.imom.domain.user.presentation.dto.request.UserLoginRequest
import com.jjarappappa.imom.domain.user.presentation.dto.response.TokenResponse
import com.jjarappappa.imom.domain.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController (
   val userService: UserService,
) {

    @PostMapping
    fun login(@RequestBody @Valid request: UserLoginRequest): TokenResponse {
        return userService.login(request);
    }
}