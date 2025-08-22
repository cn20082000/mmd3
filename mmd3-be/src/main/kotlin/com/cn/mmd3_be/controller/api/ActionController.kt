package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.ActionCreateRequest
import com.cn.mmd3_be.model.request.api.ActionUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.ActionService
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/paging")
    fun getPagingAction(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
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