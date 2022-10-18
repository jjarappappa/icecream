package com.jjarappappa.imom.domain.user.domain

import com.jjarappappa.imom.domain.user.domain.type.Authority
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User (
        val name: String,

        var nickName: String,

        val email: String,

        var password: String,

        @Enumerated(EnumType.STRING)
        var authority: Authority,

        var birthday: String,

        var phoneNumber: String,

        var address: String,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
): BaseTimeEntity() {}