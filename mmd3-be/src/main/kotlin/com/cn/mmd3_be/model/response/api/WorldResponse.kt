package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.model.entity.WorldEntity
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class WorldResponse(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
) {

    constructor(entity: WorldEntity) : this(
        entity.id,
        entity.name,
        entity.description,
    )

    companion object {
        fun lite(entity: WorldEntity) = WorldResponse(
            entity.id,
            entity.name,
            null,
        )
    }
}

