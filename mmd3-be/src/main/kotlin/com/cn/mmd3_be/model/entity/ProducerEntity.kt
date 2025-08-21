package com.cn.mmd3_be.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "tbl_producer")
open class ProducerEntity : BaseEntity() {

    @Column(name = "_name")
    @Nationalized
    open var name: String? = null

    @Column(name = "description", length = 1024)
    @Nationalized
    open var description: String? = null
}