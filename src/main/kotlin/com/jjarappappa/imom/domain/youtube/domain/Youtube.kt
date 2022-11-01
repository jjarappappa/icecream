package com.jjarappappa.imom.domain.youtube.domain

import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Youtube(
    @Column(nullable = false, length = 120)
    var url: String,

    @Column(nullable = false, length = 50)
    var title: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
): BaseTimeEntity() {
}