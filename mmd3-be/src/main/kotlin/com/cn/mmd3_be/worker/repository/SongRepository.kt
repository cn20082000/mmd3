package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.ProducerEntity
import com.cn.mmd3_be.model.entity.SongEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface SongRepository : CrudRepository<SongEntity, String> {

    @Query("SELECT s FROM SongEntity s WHERE s.enabled = true ORDER BY s.name ASC")
    fun getAll(): List<SongEntity>

    @Query("SELECT s FROM SongEntity s WHERE s.enabled = true")
    fun getPage(pageable: Pageable): Page<SongEntity>

    @Query("SELECT s FROM SongEntity s WHERE s.enabled = true AND s.id = ?1")
    fun getById(id: String): SongEntity?

    @Query("SELECT s FROM SongEntity s WHERE s.enabled = true AND s.id IN ?1 ORDER BY s.name ASC")
    fun getByIdList(ids: List<String>): List<SongEntity>

    @Query("SELECT s FROM SongEntity s JOIN s.producers p WHERE s.enabled = true AND p = ?1")
    fun getByProducer(producer: ProducerEntity): List<SongEntity>
}