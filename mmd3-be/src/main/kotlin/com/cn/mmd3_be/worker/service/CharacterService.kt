package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.CharacterCreateRequest
import com.cn.mmd3_be.model.request.api.CharacterUpdateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.CharacterResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface CharacterService {

    fun createCharacter(request: CharacterCreateRequest): CharacterResponse

    fun getAllCharacterLite(): PagingResponseModel
    fun getPagingCharacter(paging: PagingRequestModel<Any>): PagingResponseModel
    fun getPagingCharacterByWorld(paging: PagingRequestModel<WorldUpdateRequest>): PagingResponseModel

    fun updateCharacter(request: CharacterUpdateRequest): CharacterResponse

    fun deleteCharacter(request: CharacterUpdateRequest)
}