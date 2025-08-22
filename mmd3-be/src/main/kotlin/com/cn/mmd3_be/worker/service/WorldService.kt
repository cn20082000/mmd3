package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.WorldCreateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.WorldResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface WorldService {

    fun createWorld(request: WorldCreateRequest): WorldResponse

    fun getAllWorldLite(): PagingResponseModel
    fun getPagingWorld(paging: PagingRequestModel<Any>): PagingResponseModel
    fun getCharacterLite(request: WorldUpdateRequest): PagingResponseModel

    fun updateWorld(request: WorldUpdateRequest): WorldResponse

    fun deleteWorld(request: WorldUpdateRequest)
}