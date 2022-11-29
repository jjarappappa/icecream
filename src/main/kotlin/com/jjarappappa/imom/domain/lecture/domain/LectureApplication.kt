package com.jjarappappa.imom.domain.lecture.domain

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_lecture_application")
class LectureApplication(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    val lecture: Lecture,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}