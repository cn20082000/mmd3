package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.ProducerCreateRequest
import com.cn.mmd3_be.model.request.api.ProducerUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.ProducerService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/producer")
class ProducerController(
    private val producerService: ProducerService,
) {

    @PostMapping
    fun createProducer(@RequestBody request: ProducerCreateRequest): ResponseModel {
        return ResponseModel.ok(producerService.createProducer(request))
    }

    @GetMapping("/lite")
    fun getAllProducerLite(): ResponseModel {
        return ResponseModel.ok(producerService.getAllProducerLite())
    }

    @GetMapping("/paging")
    fun getPagingProducer(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
        return ResponseModel.ok(producerService.getPagingProducer(paging))
    }

    @GetMapping("{id}/song/lite")
    fun getSongLite(@PathVariable id: String): ResponseModel {
        val request = ProducerUpdateRequest(id = id)
        return ResponseModel.ok(producerService.getSongLite(request))
    }

    @PutMapping
    fun updateProducer(@RequestBody request: ProducerUpdateRequest): ResponseModel {
        return ResponseModel.ok(producerService.updateProducer(request))
    }

    @DeleteMapping
    fun deleteProducer(@RequestBody request: ProducerUpdateRequest): ResponseModel {
        producerService.deleteProducer(request)
        return ResponseModel.ok(true)
    }
}