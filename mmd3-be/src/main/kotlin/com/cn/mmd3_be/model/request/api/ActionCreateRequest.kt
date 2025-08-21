package com.cn.mmd3_be.model.request.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ActionCreateRequest(
    val name: String,
    val description: String? = null,
)
