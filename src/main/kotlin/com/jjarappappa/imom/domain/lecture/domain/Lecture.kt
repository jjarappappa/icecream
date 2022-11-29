package com.jjarappappa.imom.domain.lecture.domain

import com.jjarappappa.imom.domain.lecture.presentation.dto.request.UpdateLectureRequest
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tbl_lecture")
class Lecture(

    @Column(length = 30, nullable = false)
    var title: String,

    @Column(length = 2000, nullable = false)
    var content: String,

    @Column(length = 50, nullable = false)
    var place: String,

    @Column(length = 50, nullable = false)
    var target: String,

    @Column(nullable = false)
    var period: LocalDate,

    @Column(nullable = false)
    var date: LocalDate,

    ) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateLecture(request: UpdateLectureRequest) {
        this.title = request.title
        this.content = request.content
        this.place = request.place
        this.target = request.target
        this.period = request.period
        this.date = request.date
    }
}