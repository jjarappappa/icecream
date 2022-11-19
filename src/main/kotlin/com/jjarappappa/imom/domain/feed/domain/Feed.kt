package com.jjarappappa.imom.domain.feed.domain

import com.jjarappappa.imom.domain.feed.domain.type.FeedType
import com.jjarappappa.imom.domain.feed.presentation.dto.reqeust.UpdateFeedRequest
import com.jjarappappa.imom.domain.user.domain.User
import com.jjarappappa.imom.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_feed")
class Feed(
    @Column(length = 30, nullable = false)
    var title: String,

    @Column(length = 2000, nullable = false)
    var content: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var type: FeedType,

    @ManyToOne(fetch = FetchType.LAZY)
    var user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
): BaseTimeEntity() {

    fun updateFeed(request: UpdateFeedRequest) {
        this.title = request.title
        this.content = request.content
        this.type = request.type
    }
}