package com.cn.mmd3_be.worker.handler

import com.cn.mmd3_be.common.Constant
import com.cn.mmd3_be.common.exception.ApiException
import com.cn.mmd3_be.model.response.base.ErrorResponseModel
import com.cn.mmd3_be.model.response.base.ResponseModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(ApiException::class)
    fun apiException(ex: ApiException): ResponseEntity<ResponseModel> {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }

        return ResponseEntity
            .status(ex.httpStatus)
            .body(ResponseModel.error(ErrorResponseModel(ex)))
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun noHandlerFoundException(ex: NoHandlerFoundException): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun httpRequestMethodNotSupportedException(ex: HttpRequestMethodNotSupportedException): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun httpRequestMethodNotSupportedException(ex: HttpMessageNotReadableException): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun missingServletRequestParameterException(ex: MissingServletRequestParameterException): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentTypeMismatchException(ex: MethodArgumentTypeMismatchException): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun unknownException(ex: Exception): ResponseModel {
        if (Constant.IS_DEBUG) {
            ex.printStackTrace()
        }
        return ResponseModel.error(ErrorResponseModel(ex))
    }
}