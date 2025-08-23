package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.request.api.AuthorCreateRequest
import com.cn.mmd3_be.model.request.api.AuthorUpdateRequest
import com.cn.mmd3_be.model.request.base.PagingRequestModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import com.cn.mmd3_be.worker.service.AuthorService
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
@RequestMapping("/author")
class AuthorController(
    private val authorService: AuthorService,
) {

    @PostMapping
    fun createAuthor(@RequestBody request: AuthorCreateRequest): ResponseModel {
        return ResponseModel.ok(authorService.createAuthor(request))
    }

    @GetMapping("/lite")
    fun getAllAuthorLite(): ResponseModel {
        return ResponseModel.ok(authorService.getAllAuthorLite())
    }

    @GetMapping("/paging")
    fun getPagingAuthor(@RequestParam pageIndex: Int, @RequestParam pageSize: Int): ResponseModel {
        val paging = PagingRequestModel<Any>(pageIndex, pageSize, null)
        return ResponseModel.ok(authorService.getPagingAuthor(paging))
    }

    @GetMapping("/preview/{username}")
    fun getPreviewAuthor(@PathVariable username: String): ResponseModel {
        val request = AuthorCreateRequest(username)
        return ResponseModel.ok(authorService.getPreviewAuthor(request))
    }

    @PutMapping
    fun updateAuthor(@RequestBody request: AuthorUpdateRequest): ResponseModel {
        return ResponseModel.ok(authorService.updateAuthor(request))
    }

    @DeleteMapping
    fun deleteAuthor(@RequestBody request: AuthorUpdateRequest): ResponseModel {
        authorService.deleteAuthor(request)
        return ResponseModel.ok(true)
    }

    @PostMapping("/sync")
    fun syncVideo(@RequestBody request: AuthorUpdateRequest): ResponseModel {
        return ResponseModel.ok(authorService.syncVideo(request))
    }
}