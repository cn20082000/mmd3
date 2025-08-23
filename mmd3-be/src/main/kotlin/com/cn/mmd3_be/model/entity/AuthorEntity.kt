package com.cn.mmd3_be.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_author")
open class AuthorEntity : BaseEntity() {

    @Column(name = "username")
    @Nationalized
    open var username: String? = null

    @Column(name = "_name")
    @Nationalized
    open var name: String? = null

    @Column(name = "description", length = 1024)
    @Nationalized
    open var description: String? = null

    @ManyToOne
    @JoinColumn(name = "avatar_resource_id")
    open var avatar: AuthorResourceEntity? = null

    @ManyToOne
    @JoinColumn(name = "header_resource_id")
    open var header: AuthorResourceEntity? = null

    @Column(name = "last_sync")
    open var lastSync: LocalDateTime? = null

    @Column(name = "video_count")
    open var videoCount: Int? = null
}