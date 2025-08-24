package com.cn.mmd3_be.model.response.api

import com.cn.mmd3_be.common.util.UrlBuilder
import com.cn.mmd3_be.model.entity.AuthorEntity
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AuthorResponse(
    val id: String? = null,
    val username: String? = null,
    val name: String? = null,
    val description: String? = null,
    val profileUrl: String? = null,
    val avatarUrl: String? = null,
    val headerUrl: String? = null,

    @field:JsonSerialize(using = LocalDateTimeSerializer::class)
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val lastSync: LocalDateTime? = null,
    val videoCount: Int? = null,
) {

    constructor(entity: AuthorEntity) : this(
        entity.id,
        entity.username,
        entity.name,
        entity.description,
        UrlBuilder.profileUrl(entity),
        entity.avatar?.let { UrlBuilder.avatarUrl(it) },
        entity.header?.let { UrlBuilder.headerUrl(it) },
        entity.lastSync,
        entity.videoCount,
    )

    companion object {
        fun lite(entity: AuthorEntity) = AuthorResponse(
            entity.id,
            entity.username,
            entity.name,
            null,
            null,
            entity.avatar?.let { UrlBuilder.avatarUrl(it) },
            null,
            null,
            null,
        )
    }
}