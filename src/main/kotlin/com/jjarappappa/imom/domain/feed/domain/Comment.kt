package com.jjarappappa.imom.domain.feed.domain

import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_comment")
class Comment(
    @Column(length = 200, nullable = false)
    var comment: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    var feed: Feed

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}