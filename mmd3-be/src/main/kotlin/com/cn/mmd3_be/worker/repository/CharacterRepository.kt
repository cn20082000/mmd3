package com.cn.mmd3_be.worker.repository

import com.cn.mmd3_be.model.entity.CharacterEntity
import com.cn.mmd3_be.model.entity.WorldEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CharacterRepository : CrudRepository<CharacterEntity, String> {

    @Query("SELECT c FROM CharacterEntity c WHERE c.enabled = true ORDER BY c.name ASC")
    fun getAll(): List<CharacterEntity>

    @Query("SELECT c FROM CharacterEntity c WHERE c.enabled = true")
    fun getPage(pageable: Pageable): Page<CharacterEntity>

    @Query("SELECT c FROM CharacterEntity c WHERE c.enabled = true AND c.world = ?1")
    fun getPageByWorld(world: WorldEntity, pageable: Pageable): Page<CharacterEntity>

    @Query("SELECT c FROM CharacterEntity c WHERE c.enabled = true AND c.id = ?1")
    fun getById(id: String): CharacterEntity?

    @Query("SELECT c FROM CharacterEntity c WHERE c.enabled = true AND c.id IN ?1 ORDER BY c.name ASC")
    fun getByIdList(ids: List<String>): List<CharacterEntity>
}