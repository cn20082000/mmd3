package com.cn.mmd3_be.common.exception

import com.cn.mmd3_be.model.enumi.EError
import org.springframework.http.HttpStatus

class ApiException(
    val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    val errorType: EError = EError.UNKNOWN_ERROR,
    val mess: String? = null,
) : Exception("${errorType.name}: $mess") {

    fun httpStatus(status: HttpStatus) = ApiException(status, errorType, mess)

    fun error(er: EError) = ApiException(httpStatus, er, er.message())

    fun message(msg: String) = ApiException(httpStatus, errorType, msg)
}