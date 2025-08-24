package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.SystemService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/system")
class SystemController(
    private val systemService: SystemService
) {

    @GetMapping
    fun getSystem(): ResponseModel {
        return ResponseModel.ok(systemService.getSystem())
    }
}