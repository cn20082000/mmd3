package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.request.api.SongCreateRequest
import com.cn.mmd3_be.model.request.api.SongUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.api.SongResponse
import com.cn.mmd3_be.model.response.base.PagingResponseModel

interface SongService {

    fun createSong(request: SongCreateRequest): SongResponse

    fun getAllSongLite(): PagingResponseModel
    fun getPagingSong(paging: PagingRequestModel<Any>): PagingResponseModel

    fun updateSong(request: SongUpdateRequest): SongResponse

    fun deleteSong(request: SongUpdateRequest)
}