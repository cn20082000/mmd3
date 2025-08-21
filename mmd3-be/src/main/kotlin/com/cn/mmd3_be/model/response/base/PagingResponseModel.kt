package com.cn.mmd3_be.model.response.base

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PagingResponseModel(
    val data: Any,
    val pageIndex: Int,
    val pageSize: Int,
    val elements: Int,
    val totalPages: Int,
    val totalElements: Long,
)
