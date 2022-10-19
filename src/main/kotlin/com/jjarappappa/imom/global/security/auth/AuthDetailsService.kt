package com.jjarappappa.imom.global.security.auth

import com.jjarappappa.imom.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService (
    val userFacade: UserFacade,
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
         return AuthDetails(userFacade.findUserByEmail(username))
    }
}