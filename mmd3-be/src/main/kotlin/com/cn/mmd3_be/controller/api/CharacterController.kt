package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.CharacterCreateRequest
import com.cn.mmd3_be.model.request.api.CharacterUpdateRequest
import com.cn.mmd3_be.model.request.api.WorldUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.CharacterService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    @PostMapping("/lite")
    fun getAllCharacterLite(): ResponseModel {
        return ResponseModel.ok(characterService.getAllCharacterLite())
    }

    @PostMapping("/paging")
    fun getPagingCharacter(@RequestBody paging: PagingRequestModel<Any>): ResponseModel {
        return ResponseModel.ok(characterService.getPagingCharacter(paging))
    }

    @PostMapping("/paging/by-world")
    fun getPagingCharacterByWorld(@RequestBody paging: PagingRequestModel<WorldUpdateRequest>): ResponseModel {
        return ResponseModel.ok(characterService.getPagingCharacterByWorld(paging))
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