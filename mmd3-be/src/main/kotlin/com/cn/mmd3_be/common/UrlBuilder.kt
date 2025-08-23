package com.cn.mmd3_be.common

import com.cn.mmd3_be.model.entity.AuthorEntity
import com.cn.mmd3_be.model.entity.AuthorResourceEntity

class UrlBuilder {

    companion object {

        fun profileUrl(entity: AuthorEntity): String? {
            if (entity.username != null) {
                return "${Constant.BASE_URL}profile/${entity.username}"
            }
            return null
        }

        fun avatarUrl(entity: AuthorResourceEntity): String? {
            if (entity.resourceId != null && entity.name != null) {
                return "${Constant.BASE_RESOURCE_URL}image/avatar/${entity.resourceId}/${entity.name}"
            }
            return null
        }

        fun headerUrl(entity: AuthorResourceEntity): String? {
            if (entity.resourceId != null && entity.name != null) {
                return "${Constant.BASE_RESOURCE_URL}image/profileHeader/${entity.resourceId}/${entity.name}"
            }
            return null
        }
    }
}