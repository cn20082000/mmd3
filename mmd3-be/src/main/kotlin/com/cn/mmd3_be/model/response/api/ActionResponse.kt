package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.model.entity.ActionEntity
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ActionResponse(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
) {

    constructor(entity: ActionEntity) : this(
        entity.id,
        entity.name,
        entity.description,
    )

    companion object {
        fun lite(entity: ActionEntity) = ActionResponse(
            entity.id,
            entity.name,
            null,
        )
    }
}

