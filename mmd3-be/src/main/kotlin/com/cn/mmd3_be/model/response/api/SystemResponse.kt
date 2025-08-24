package com.cn.mmd3_be.model.response.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SystemResponse(
    val additionHeaders: Map<String, String>?
)
