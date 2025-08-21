package com.cn.mmd3_be.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "tbl_song")
open class SongEntity : BaseEntity() {

    @Column(name = "_name")
    @Nationalized
    open var name: String? = null

    @Column(name = "url", length = 1024)
    @Nationalized
    open var url: String? = null

    @Column(name = "description", length = 1024)
    @Nationalized
    open var description: String? = null

    @ManyToMany
    @JoinTable(
        name = "tbl_song_producer",
        joinColumns = [JoinColumn(name = "song_id")],
        inverseJoinColumns = [JoinColumn(name = "producer_id")]
    )
    open var producers = mutableListOf<ProducerEntity>()
}