package com.cn.mmd3_be.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "tbl_character")
open class CharacterEntity : BaseEntity() {

    @Column(name = "_name")
    @Nationalized
    open var name: String? = null

    @Column(name = "url", length = 1024)
    @Nationalized
    open var url: String? = null

    @Column(name = "description", length = 1024)
    @Nationalized
    open var description: String? = null

    @ManyToOne
    @JoinColumn(name = "world_id")
    open var world: WorldEntity? = null
}