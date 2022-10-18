package com.jjarappappa.imom.domain.user.presentation

import com.jjarappappa.imom.domain.user.presentation.dto.request.UserJoinRequest
import com.jjarappappa.imom.domain.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    private val userService: UserService,
){

    @PostMapping
    fun joinUser(@RequestBody request: UserJoinRequest) {
        userService.createUser(request);
    }
}