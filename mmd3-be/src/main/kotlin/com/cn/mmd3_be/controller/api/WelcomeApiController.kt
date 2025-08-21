package com.cn.mmd3_be.controller.api

import com.cn.mmd3_be.model.response.base.ResponseModel
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/welcome")
class WelcomeApiController {

    @GetMapping
    fun welcome(): ResponseModel {
        return ResponseModel.ok("You're welcome!")
    }
}