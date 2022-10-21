package com.jjarappappa.imom.domain.user.domain

import com.jjarappappa.imom.domain.user.domain.type.Authority
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class User (
        @Column(length = 50, nullable = false)
        var name: String,

        @Column(length = 15, nullable = false, unique = true)
        var nickname: String,

        @Column(length = 50, nullable = false, unique = true)
        val email: String,

        @Column(nullable = false)
        var password: String,

        @Enumerated(EnumType.STRING)
        @Column(length = 10, nullable = false)
        var authority: Authority,

        @Column(nullable = false)
        var birthday: LocalDate,

        @Column(name = "phone_number", length = 15, nullable = false, unique = true)
        var phoneNumber: String,

        @Column(length = 70, nullable = false, unique = true)
        var address: String,

        @Column(nullable = false)
        var profileImg: String,

        @Column(nullable = false, unique = true)
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
): BaseTimeEntity() {


    fun updateProfileImage(profileImg: String) {
            this.profileImg = profileImg
    }

    fun updateProfile(name: String, nickname: String, birthday: LocalDate, address: String) {
            this.name = name
            this.nickname = nickname
            this.birthday = birthday
            this.address = address
    }
}