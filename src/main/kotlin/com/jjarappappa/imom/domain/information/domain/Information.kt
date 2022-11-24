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
import javax.persistence.ElementCollection
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue

@Entity
@Table(name = "tbl_information")
class Information(
    @Length(min = 3, max = 20)
    var title: String,
    @Length(min = 1, max = 1500)
    var content: String,

    @Enumerated(EnumType.STRING)
    var category: Category,

    @ElementCollection(fetch = FetchType.LAZY)
    var images: MutableList<String>,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val user: User,
) : BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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