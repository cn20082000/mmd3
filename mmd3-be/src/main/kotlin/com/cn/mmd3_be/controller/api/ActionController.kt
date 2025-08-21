package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.ActionCreateRequest
import com.cn.mmd3_be.model.request.api.ActionUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.ActionService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/action")
class ActionController(
    private val actionService: ActionService
) {

    @PostMapping
    fun createAction(@RequestBody request: ActionCreateRequest): ResponseModel {
        return ResponseModel.ok(actionService.createAction(request))
    }

    @GetMapping("/lite")
    fun getAllActionLite(): ResponseModel {
        return ResponseModel.ok(actionService.getAllActionLite())
    }

    @PostMapping("/paging")
    fun getPagingAction(@RequestBody paging: PagingRequestModel<Any>): ResponseModel {
        return ResponseModel.ok(actionService.getPagingAction(paging))
    }

    @PutMapping
    fun updateAction(@RequestBody request: ActionUpdateRequest): ResponseModel {
        return ResponseModel.ok(actionService.updateAction(request))
    }

    @DeleteMapping
    fun deleteAction(@RequestBody request: ActionUpdateRequest): ResponseModel {
        actionService.deleteAction(request)
        return ResponseModel.ok(true)
    }

}