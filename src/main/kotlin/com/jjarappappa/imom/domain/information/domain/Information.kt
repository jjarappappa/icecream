package com.jjarappappa.imom.domain.information.domain

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.JoinColumn
import javax.persistence.EnumType
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue

@Entity
@Table(name = "tbl_information")
class Information(
    @Column(nullable = false, length = 15)
    var title: String,

    @Column(nullable = false, length = 1500)
    var content: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var category: Category,

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    var images: MutableList<String>,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
) : BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0
}

fun Information.update(
    title: String,
    content: String,
    category: Category,
    images: MutableList<String>
) {
    this.title = title
    this.content = content
    this.category = category
    this.images = images
}

enum class Category {
    MATERNITY,
    PARENTING,
}