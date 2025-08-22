package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.ProducerCreateRequest
import com.cn.mmd3_be.model.request.api.ProducerUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.ProducerResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface ProducerService {

    fun createProducer(request: ProducerCreateRequest): ProducerResponse

    fun getAllProducerLite(): PagingResponseModel
    fun getPagingProducer(paging: PagingRequestModel<Any>): PagingResponseModel
    fun getSongLite(request: ProducerUpdateRequest): PagingResponseModel

    fun updateProducer(request: ProducerUpdateRequest): ProducerResponse

    fun deleteProducer(request: ProducerUpdateRequest)
}