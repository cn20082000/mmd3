package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.ActionEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ActionRepository : CrudRepository<ActionEntity, String> {

    @Query("SELECT a FROM ActionEntity a WHERE a.enabled = true ORDER BY a.name ASC")
    fun getAll(): List<ActionEntity>

    @Query("SELECT a FROM ActionEntity a WHERE a.enabled = true")
    fun getPage(pageable: Pageable): Page<ActionEntity>

    @Query("SELECT a FROM ActionEntity a WHERE a.enabled = true AND a.id = ?1")
    fun getById(id: String): ActionEntity?

    @Query("SELECT a FROM ActionEntity a WHERE a.enabled = true AND a.id IN ?1 ORDER BY a.name ASC")
    fun getByIdList(ids: List<String>): List<ActionEntity>
}