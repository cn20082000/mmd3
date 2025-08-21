package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.ProducerCreateRequest
import com.cn.mmd3_be.model.request.api.ProducerUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.ProducerService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    @PostMapping("/lite")
    fun getAllProducerLite(): ResponseModel {
        return ResponseModel.ok(producerService.getAllProducerLite())
    }

    @PostMapping("/paging")
    fun getPagingProducer(@RequestBody paging: PagingRequestModel<Any>): ResponseModel {
        return ResponseModel.ok(producerService.getPagingProducer(paging))
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