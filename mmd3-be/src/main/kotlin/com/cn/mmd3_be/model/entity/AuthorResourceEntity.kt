package com.cn.mmd3_be.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_author_resource")
open class AuthorResourceEntity : BaseEntity() {

    @Column(name = "resource_id")
    open var resourceId: String? = null

    @Column(name = "type")
    open var type: String? = null

    @Column(name = "path")
    open var path: String? = null

    @Column(name = "_name")
    open var name: String? = null

    @Column(name = "mine")
    open var mine: String? = null
}