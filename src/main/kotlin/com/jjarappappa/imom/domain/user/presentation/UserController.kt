package com.jjarappappa.imom.domain.user.presentation

import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import com.jjarappappa.imom.domain.user.presentation.dto.request.UserUpdateRequest
import com.jjarappappa.imom.domain.user.presentation.dto.response.UserProfileResponse
import com.jjarappappa.imom.domain.user.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController (
    private val userService: UserService,
){

    @PostMapping
    fun joinUser(@RequestBody @Valid request: UserJoinRequest) {
        userService.createUser(request);
    }

    @GetMapping
    fun getProfile(): UserProfileResponse {
        return userService.getProfile();
    }

    @PutMapping
    fun updateProfile(@RequestBody @Valid request: UserUpdateRequest) {
        userService.updateProfile(request);
    }
}