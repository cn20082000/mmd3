package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.model.entity.ProducerEntity
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProducerResponse(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
) {

    constructor(entity: ProducerEntity) : this(
        entity.id,
        entity.name,
        entity.description,
    )

    companion object {
        fun lite(entity: ProducerEntity) = ProducerResponse(
            entity.id,
            entity.name,
            null,
        )
    }
}
