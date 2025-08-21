package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.model.entity.SongEntity
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SongResponse(
    val id: String? = null,
    val name: String? = null,
    val url: String? = null,
    val description: String? = null,
    val producers: List<ProducerResponse>? = null,
) {

    constructor(entity: SongEntity) : this(
        entity.id,
        entity.name,
        entity.url,
        entity.description,
        entity.producers.map { ProducerResponse(it) }
    )

    companion object {
        fun lite(entity: SongEntity) = SongResponse(
            entity.id,
            entity.name,
            entity.url,
            null,
            entity.producers.map { ProducerResponse.lite(it) }
        )
    }
}