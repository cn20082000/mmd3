package com.cn.mmd3_be.model.response.base

data class ResponseModel(
    val data: Any? = null,
    val error: ErrorResponseModel? = null,
) {

    companion object {

        fun ok(data: Any?) = ResponseModel(data, null)

        fun error(er: ErrorResponseModel?) = ResponseModel(null, er)
    }
}
