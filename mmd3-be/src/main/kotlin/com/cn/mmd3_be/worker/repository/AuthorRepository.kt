package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.AuthorEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<AuthorEntity, String> {

    @Query("SELECT a FROM AuthorEntity a WHERE a.enabled = true ORDER BY a.name ASC")
    fun getAll(): List<AuthorEntity>

    @Query("SELECT a FROM AuthorEntity a WHERE a.enabled = true")
    fun getPage(pageable: Pageable): Page<AuthorEntity>

    @Query("SELECT a FROM AuthorEntity a WHERE a.enabled = true AND a.id = ?1")
    fun getById(id: String): AuthorEntity?

    @Query("SELECT a FROM AuthorEntity a WHERE a.enabled = true AND a.id IN ?1 ORDER BY a.name ASC")
    fun getByIdList(ids: List<String>): List<AuthorEntity>

    @Query("SELECT a FROM AuthorEntity a WHERE a.enabled = true AND a.username = ?1")
    fun getByUsername(username: String): AuthorEntity?
}