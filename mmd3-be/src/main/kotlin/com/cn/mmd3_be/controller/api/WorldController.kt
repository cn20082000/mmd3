package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.WorldCreateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.WorldService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/world")
class WorldController(
    private val worldService: WorldService
) {

    @PostMapping
    fun createWorld(@RequestBody request: WorldCreateRequest): ResponseModel {
        return ResponseModel.ok(worldService.createWorld(request))
    }

    @GetMapping("/lite")
    fun getAllWorldLite(): ResponseModel {
        return ResponseModel.ok(worldService.getAllWorldLite())
    }

    @GetMapping("/paging")
    fun getPagingWorld(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
        return ResponseModel.ok(worldService.getPagingWorld(paging))
    }

    @GetMapping("{id}/character/lite")
    fun getCharacterLite(@PathVariable id: String): ResponseModel {
        val request = WorldUpdateRequest(id = id)
        return ResponseModel.ok(worldService.getCharacterLite(request))
    }

    @PutMapping
    fun updateWorld(@RequestBody request: WorldUpdateRequest): ResponseModel {
        return ResponseModel.ok(worldService.updateWorld(request))
    }

    @DeleteMapping
    fun deleteWorld(@RequestBody request: WorldUpdateRequest): ResponseModel {
        worldService.deleteWorld(request)
        return ResponseModel.ok(true)
    }
}