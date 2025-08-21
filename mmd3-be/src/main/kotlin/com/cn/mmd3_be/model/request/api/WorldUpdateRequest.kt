package com.cn.mmd3_be.model.request.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class WorldUpdateRequest(
    val id: String,
    val name: String? = null,
    val description: String? = null,
)