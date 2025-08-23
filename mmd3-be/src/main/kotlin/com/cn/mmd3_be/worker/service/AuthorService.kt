package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.AuthorCreateRequest
import com.cn.mmd3_be.model.request.api.AuthorUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.AuthorResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface AuthorService {

    fun createAuthor(request: AuthorCreateRequest): AuthorResponse

    fun getAllAuthorLite(): PagingResponseModel
    fun getPagingAuthor(paging: PagingRequestModel<Any>): PagingResponseModel
    fun getPreviewAuthor(request: AuthorCreateRequest): AuthorResponse

    fun updateAuthor(request: AuthorUpdateRequest): AuthorResponse

    fun deleteAuthor(request: AuthorUpdateRequest)

    fun syncVideo(request: AuthorUpdateRequest): AuthorResponse
}