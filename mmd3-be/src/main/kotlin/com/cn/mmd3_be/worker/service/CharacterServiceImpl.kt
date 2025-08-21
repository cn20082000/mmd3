package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.entity.CharacterEntity
import com.cn.mmd3_be.model.enumi.EError
import com.cn.mmd3_be.model.request.api.CharacterCreateRequest
import com.cn.mmd3_be.model.request.api.CharacterUpdateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.CharacterResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.CharacterRepository
import com.cn.mmd3_be.worker.repository.WorldRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CharacterServiceImpl(
    private val characterRepo: CharacterRepository,
    private val worldRepo: WorldRepository,
) : CharacterService {

    @Transactional
    override fun createCharacter(request: CharacterCreateRequest): CharacterResponse {
        val character = CharacterEntity().apply {
            name = request.name
            url = request.url
            description = request.description
            world = request.world?.let { worldRepo.getById(it.id) }
        }
        val entity = characterRepo.save(character)

        return CharacterResponse(entity)
    }

    override fun getAllCharacterLite(): PagingResponseModel {
        val list = characterRepo.getAll()

        return PagingResponseModel(
            list.map { CharacterResponse.lite(it) },
            0,
            list.size,
            list.size,
            1,
            list.size.toLong(),
        )
    }

    override fun getPagingCharacter(paging: PagingRequestModel<Any>): PagingResponseModel {
        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = characterRepo.getPage(pageable)

        return PagingResponseModel(
            page.content.map { CharacterResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements
        )
    }

    override fun getPagingCharacterByWorld(paging: PagingRequestModel<WorldUpdateRequest>): PagingResponseModel {
        val world = paging.data?.id?.let { worldRepo.getById(it) } ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = characterRepo.getPageByWorld(world, pageable)

        return PagingResponseModel(
            page.content.map { CharacterResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements
        )
    }

    @Transactional
    override fun updateCharacter(request: CharacterUpdateRequest): CharacterResponse {
        val character = characterRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        character.name = request.name
        character.url = request.url
        character.description = request.description
        character.world = request.world?.id?.let { worldRepo.getById(it) }
        val entity = characterRepo.save(character)

        return CharacterResponse(entity)
    }

    override fun deleteCharacter(request: CharacterUpdateRequest) {
        val character = characterRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        character.enabled = false
        characterRepo.save(character)
    }
}