package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.CharacterCreateRequest
import com.cn.mmd3_be.model.request.api.CharacterUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.CharacterService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/character")
class CharacterController(
    private val characterService: CharacterService,
) {

    @PostMapping
    fun createCharacter(@RequestBody request: CharacterCreateRequest): ResponseModel {
        return ResponseModel.ok(characterService.createCharacter(request))
    }

    @GetMapping("/lite")
    fun getAllCharacterLite(): ResponseModel {
        return ResponseModel.ok(characterService.getAllCharacterLite())
    }

    @GetMapping("/paging")
    fun getPagingCharacter(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
        return ResponseModel.ok(characterService.getPagingCharacter(paging))
    }

    @PutMapping
    fun updateCharacter(@RequestBody request: CharacterUpdateRequest): ResponseModel {
        return ResponseModel.ok(characterService.updateCharacter(request))
    }

    @DeleteMapping
    fun deleteCharacter(@RequestBody request: CharacterUpdateRequest): ResponseModel {
        characterService.deleteCharacter(request)
        return ResponseModel.ok(true)
    }
}