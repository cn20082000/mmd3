package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.ActionCreateRequest
import com.cn.mmd3_be.model.request.api.ActionUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.ActionResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface ActionService {

    fun createAction(request: ActionCreateRequest): ActionResponse

    fun getAllActionLite(): PagingResponseModel
    fun getPagingAction(paging: PagingRequestModel<Any>): PagingResponseModel

    fun updateAction(request: ActionUpdateRequest): ActionResponse

    fun deleteAction(request: ActionUpdateRequest)
}