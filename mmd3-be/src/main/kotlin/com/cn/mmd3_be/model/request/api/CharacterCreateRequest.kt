package com.cn.mmd3_be.model.request.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CharacterCreateRequest(
    val name: String,
    val url: String? = null,
    val description: String? = null,
    val world: WorldUpdateRequest? = null,
)
