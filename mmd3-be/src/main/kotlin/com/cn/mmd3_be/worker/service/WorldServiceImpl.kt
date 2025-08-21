package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.entity.WorldEntity
import com.cn.mmd3_be.model.enumi.EError
import com.cn.mmd3_be.model.request.api.WorldCreateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.WorldResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.WorldRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WorldServiceImpl(
    private val worldRepo: WorldRepository
) : WorldService {

    @Transactional
    override fun createWorld(request: WorldCreateRequest): WorldResponse {
        val world = WorldEntity().apply {
            name = request.name
            description = request.description
        }
        val entity = worldRepo.save(world)

        return WorldResponse(entity)
    }

    override fun getAllWorldLite(): PagingResponseModel {
        val list = worldRepo.getAll()

        return PagingResponseModel(
            list.map { WorldResponse.lite(it) },
            0,
            list.size,
            list.size,
            1,
            list.size.toLong(),
        )
    }

    override fun getPagingWorld(paging: PagingRequestModel<Any>): PagingResponseModel {
        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = worldRepo.getPage(pageable)

        return PagingResponseModel(
            page.content.map { WorldResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements
        )
    }

    @Transactional
    override fun updateWorld(request: WorldUpdateRequest): WorldResponse {
        val world = worldRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        world.name = request.name
        world.description = request.description
        val entity = worldRepo.save(world)

        return WorldResponse(entity)
    }

    @Transactional
    override fun deleteWorld(request: WorldUpdateRequest) {
        val world = worldRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        world.enabled = false
        worldRepo.save(world)
    }
}