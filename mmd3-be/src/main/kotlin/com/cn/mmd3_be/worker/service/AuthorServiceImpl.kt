package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.AuthorCreateRequest
import com.cn.mmd3_be.model.request.api.AuthorUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.AuthorResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorServiceImpl(
    private val authorRepo: AuthorRepository,
) : AuthorService {

    @Transactional
    override fun createAuthor(request: AuthorCreateRequest): AuthorResponse {
        TODO("Not yet implemented")
    }

    override fun getAllAuthorLite(): PagingResponseModel {
        TODO("Not yet implemented")
    }

    override fun getPagingAuthor(paging: PagingRequestModel<Any>): PagingResponseModel {
        TODO("Not yet implemented")
    }

    override fun getPreviewAuthor(request: AuthorCreateRequest): AuthorResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateAuthor(request: AuthorUpdateRequest): AuthorResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteAuthor(request: AuthorUpdateRequest) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun syncVideo(request: AuthorUpdateRequest): AuthorResponse {
        TODO("Not yet implemented")
    }
}