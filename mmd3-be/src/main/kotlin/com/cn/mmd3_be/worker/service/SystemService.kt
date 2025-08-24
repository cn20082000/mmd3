package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.model.response.api.SystemResponse

interface SystemService {

    fun getSystem(): SystemResponse
}