package com.cn.mmd3_be.model.request.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SongCreateRequest(
    val name: String,
    val url: String? = null,
    val description: String? = null,
    val producers: List<ProducerUpdateRequest>,
)
