package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.entity.ProducerEntity
import com.cn.mmd3_be.model.enumi.EError
import com.cn.mmd3_be.model.request.api.ProducerCreateRequest
import com.cn.mmd3_be.model.request.api.ProducerUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.ProducerResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.ProducerRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProducerServiceImpl(
    private val producerRepo: ProducerRepository
) : ProducerService {

    @Transactional
    override fun createProducer(request: ProducerCreateRequest): ProducerResponse {
        val producer = ProducerEntity().apply {
            name = request.name
            description = request.description
        }
        val entity = producerRepo.save(producer)

        return ProducerResponse(entity)
    }

    override fun getAllProducerLite(): PagingResponseModel {
        val list = producerRepo.getAll()

        return PagingResponseModel(
            list.map { ProducerResponse.lite(it) },
            0,
            list.size,
            list.size,
            1,
            list.size.toLong(),
        )
    }

    override fun getPagingProducer(paging: PagingRequestModel<Any>): PagingResponseModel {
        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = producerRepo.getPage(pageable)

        return PagingResponseModel(
            page.content.map { ProducerResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements
        )
    }

    @Transactional
    override fun updateProducer(request: ProducerUpdateRequest): ProducerResponse {
        val producer = producerRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        producer.name = request.name
        producer.description = request.description
        val entity = producerRepo.save(producer)

        return ProducerResponse(entity)
    }

    @Transactional
    override fun deleteProducer(request: ProducerUpdateRequest) {
        val producer = producerRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        producer.enabled = false
        producerRepo.save(producer)
    }
}