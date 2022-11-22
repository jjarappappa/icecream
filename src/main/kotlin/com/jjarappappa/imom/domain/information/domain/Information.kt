package com.jjarappappa.imom.domain.information

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
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
    val title: String,
    val content: String,

    @Enumerated(EnumType.STRING)
    val category: Category,

    @ElementCollection(fetch = FetchType.LAZY)
    val images: MutableList<String>,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val user: User,
) : BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}

enum class Category {
    MATERNITY,
    PARENTING,
}