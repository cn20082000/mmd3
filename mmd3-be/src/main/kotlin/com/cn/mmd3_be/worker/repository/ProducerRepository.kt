package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.ProducerEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ProducerRepository : CrudRepository<ProducerEntity, String> {

    @Query("SELECT p FROM ProducerEntity p WHERE p.enabled = true ORDER BY p.name ASC")
    fun getAll(): List<ProducerEntity>

    @Query("SELECT p FROM ProducerEntity p WHERE p.enabled = true")
    fun getPage(pageable: Pageable): Page<ProducerEntity>

    @Query("SELECT p FROM ProducerEntity p WHERE p.enabled = true AND p.id = ?1")
    fun getById(id: String): ProducerEntity?

    @Query("SELECT p FROM ProducerEntity p WHERE p.enabled = true AND p.id IN ?1 ORDER BY p.name ASC")
    fun getByIdList(ids: List<String>): List<ProducerEntity>
}