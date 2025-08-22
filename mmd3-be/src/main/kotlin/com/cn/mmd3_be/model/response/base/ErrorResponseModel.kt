package com.cn.mmd3_be.model.response.base

import com.cn.mmd3_be.common.Constant
import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.enumi.EError
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponseModel private constructor(
    val statusCode: Int,
    val error: EError,
    val message: String,
    val stacktrace: String? = null,
) {

    constructor(ex: ApiException) : this(
        ex.httpStatus.value(),
        ex.errorType,
        ex.mess ?: ex.errorType.message(),
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: NoHandlerFoundException) : this(
        HttpStatus.NOT_FOUND.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: HttpRequestMethodNotSupportedException) : this(
        HttpStatus.METHOD_NOT_ALLOWED.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: HttpMessageNotReadableException) : this(
        HttpStatus.BAD_REQUEST.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: MissingServletRequestParameterException) : this(
        HttpStatus.BAD_REQUEST.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: MethodArgumentTypeMismatchException) : this(
        HttpStatus.BAD_REQUEST.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )

    constructor(ex: Exception) : this(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        EError.UNKNOWN_ERROR,
        ex.localizedMessage,
        if (Constant.IS_DEBUG) ex.stackTraceToString() else null,
    )
}