package com.cn.mmd3_be.worker.service

import com.cn.mmd3_be.common.Constant
import com.cn.mmd3_be.model.response.api.SystemResponse
import org.springframework.stereotype.Service

@Service
class SystemServiceImpl : SystemService {

    override fun getSystem(): SystemResponse {
        return SystemResponse(
            additionHeaders = mapOf(
                "Referer" to "${Constant.BASE_URL}/",
            ),
        )
    }
}