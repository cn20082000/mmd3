package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.entity.ActionEntity
import com.cn.mmd3_be.model.enumi.EError
import com.cn.mmd3_be.model.request.api.ActionCreateRequest
import com.cn.mmd3_be.model.request.api.ActionUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.ActionResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.ActionRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActionServiceImpl(
    private val actionRepo: ActionRepository
) : ActionService {

    @Transactional
    override fun createAction(request: ActionCreateRequest): ActionResponse {
        val action = ActionEntity().apply {
            name = request.name
            description = request.description
        }
        val entity = actionRepo.save(action)

        return ActionResponse(entity)
    }

    override fun getAllActionLite(): PagingResponseModel {
        val list = actionRepo.getAll()

        return PagingResponseModel(
            list.map { ActionResponse.lite(it) },
            0,
            list.size,
            list.size,
            1,
            list.size.toLong(),
        )
    }

    override fun getPagingAction(paging: PagingRequestModel<Any>): PagingResponseModel {
        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = actionRepo.getPage(pageable)

        return PagingResponseModel(
            page.content.map { ActionResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements,
        )
    }

    @Transactional
    override fun updateAction(request: ActionUpdateRequest): ActionResponse {
        val action = actionRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        action.name = request.name
        action.description = request.description
        val entity = actionRepo.save(action)

        return ActionResponse(entity)
    }

    @Transactional
    override fun deleteAction(request: ActionUpdateRequest) {
        val action = actionRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        action.enabled = false
        actionRepo.save(action)
    }
}