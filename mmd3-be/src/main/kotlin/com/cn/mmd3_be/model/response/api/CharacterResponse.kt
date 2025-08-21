package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.model.entity.CharacterEntity
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CharacterResponse(
    val id: String? = null,
    val name: String? = null,
    val url: String? = null,
    val description: String? = null,
    val world: WorldResponse? = null,
) {

    constructor(entity: CharacterEntity) : this(
        entity.id,
        entity.name,
        entity.url,
        entity.description,
        entity.world?.let { WorldResponse(it) }
    )

    companion object {
        fun lite(entity: CharacterEntity) = CharacterResponse(
            entity.id,
            entity.name,
            null,
            null,
            entity.world?.let { WorldResponse.lite(it) },
        )
    }
}

