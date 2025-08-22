package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.SongCreateRequest
import com.cn.mmd3_be.model.request.api.SongUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.SongService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/song")
class SongController(
    private val songService: SongService,
) {

    @PostMapping
    fun createSong(@RequestBody request: SongCreateRequest): ResponseModel {
        return ResponseModel.ok(songService.createSong(request))
    }

    @GetMapping("/lite")
    fun getAllSongLite(): ResponseModel {
        return ResponseModel.ok(songService.getAllSongLite())
    }

    @GetMapping("/paging")
    fun getPagingSong(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
        return ResponseModel.ok(songService.getPagingSong(paging))
    }

    @PutMapping
    fun updateSong(@RequestBody request: SongUpdateRequest): ResponseModel {
        return ResponseModel.ok(songService.updateSong(request))
    }

    @DeleteMapping
    fun deleteSong(@RequestBody request: SongUpdateRequest): ResponseModel {
        songService.deleteSong(request)
        return ResponseModel.ok(true)
    }
}