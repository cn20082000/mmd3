package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.entity.SongEntity
import com.cn.mmd3_be.model.enumi.EError
import com.cn.mmd3_be.model.request.api.SongCreateRequest
import com.cn.mmd3_be.model.request.api.SongUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.SongResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel
import com.cn.mmd3_be.worker.repository.ProducerRepository
import com.cn.mmd3_be.worker.repository.SongRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SongServiceImpl(
    private val songRepo: SongRepository,
    private val producerRepo: ProducerRepository,
) : SongService {

    @Transactional
    override fun createSong(request: SongCreateRequest): SongResponse {
        val song = SongEntity().apply {
            name = request.name
            url = request.url
            description = request.description
            producers = producerRepo.getByIdList(request.producers.map { it.id }).toMutableList()
        }
        val entity = songRepo.save(song)

        return SongResponse(entity)
    }

    override fun getAllSongLite(): PagingResponseModel {
        val list = songRepo.getAll()

        return PagingResponseModel(
            list.map { SongResponse.lite(it) },
            0,
            list.size,
            list.size,
            1,
            list.size.toLong(),
        )
    }

    override fun getPagingSong(paging: PagingRequestModel<Any>): PagingResponseModel {
        val pageable = PageRequest.of(paging.pageIndex, paging.pageSize, Sort.by(Sort.Direction.ASC, "name"))
        val page = songRepo.getPage(pageable)

        return PagingResponseModel(
            page.content.map { SongResponse(it) },
            page.pageable.pageNumber,
            page.pageable.pageSize,
            page.content.size,
            page.totalPages,
            page.totalElements
        )
    }

    @Transactional
    override fun updateSong(request: SongUpdateRequest): SongResponse {
        val song = songRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        song.name = request.name
        song.url = request.url
        song.description = request.description
        song.producers = producerRepo.getByIdList(request.producers.map { it.id }).toMutableList()
        val entity = songRepo.save(song)

        return SongResponse(entity)
    }

    @Transactional
    override fun deleteSong(request: SongUpdateRequest) {
        val song = songRepo.getById(request.id) ?: throw ApiException()
            .httpStatus(HttpStatus.NOT_FOUND)
            .error(EError.NOT_FOUND_RECORD)

        song.enabled = false
        songRepo.save(song)
    }
}