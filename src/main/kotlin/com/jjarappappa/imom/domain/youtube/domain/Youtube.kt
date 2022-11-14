package com.jjarappappa.imom.domain.youtube.domain

import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Id

class Youtube(
    @Column(length = 50, nullable = false)
    var title: String,

    @Id
    @Column(length = 10, nullable = false, unique = true)
    var id: String
): BaseTimeEntity() {
    fun updateYoutube(title: String) {
        this.title = title
    }
}