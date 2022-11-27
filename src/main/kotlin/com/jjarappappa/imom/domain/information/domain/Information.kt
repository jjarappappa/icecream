package com.jjarappappa.imom.domain.information.domain

import com.jjarappappa.imom.domain.information.domain.type.Category
import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.*

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