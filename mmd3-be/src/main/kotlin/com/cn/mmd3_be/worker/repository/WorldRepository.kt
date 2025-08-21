package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.WorldEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface WorldRepository : CrudRepository<WorldEntity, String> {

    @Query("SELECT w FROM WorldEntity w WHERE w.enabled = true ORDER BY w.name ASC")
    fun getAll(): List<WorldEntity>

    @Query("SELECT w FROM WorldEntity w WHERE w.enabled = true")
    fun getPage(pageable: Pageable): Page<WorldEntity>

    @Query("SELECT w FROM WorldEntity w WHERE w.enabled = true AND w.id = ?1")
    fun getById(id: String): WorldEntity?
}