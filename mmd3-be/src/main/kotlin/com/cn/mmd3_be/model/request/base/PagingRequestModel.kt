package com.cn.mmd3_be.model.request.base

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PagingRequestModel<T>(
    val pageIndex: Int = 0,
    val pageSize: Int = 20,
    val data: T? = null,
)