package com.jjarappappa.imom.domain.lecture.domain

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

    @Column(length = 50, nullable = false)
    var teacher: String,

    @Column(nullable = false)
    var luckyDate: LocalDate,

    @Column(nullable = false)
    var date: LocalDate

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateLecture(title: String, content: String, place: String, target: String, period: LocalDate, teacher: String, luckyDate: LocalDate, date: LocalDate) {
        this.title = title
        this.content = content
        this.place = place
        this.target = target
        this.period = period
        this.teacher = teacher
        this.luckyDate = luckyDate
        this.date = date
    }
}