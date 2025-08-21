package com.cn.mmd3_be.model.enumi

enum class EError(val value: Int) {
    // Tiền tố 10 dùng cho các lỗi chung
    UNKNOWN_ERROR(1001),
    NOT_FOUND_RECORD(1002),
    NOT_FOUND_PROFILE(1003),
    DUPLICATE_RECORD(1004),
    ;

    fun message(): String {
        return when (this) {
            UNKNOWN_ERROR -> "Lỗi không xác định"
            NOT_FOUND_RECORD -> "Không tìm thấy bản ghi"
            NOT_FOUND_PROFILE -> "Không tìm thấy người dùng"
            DUPLICATE_RECORD -> "Bản ghi đã tồn tại"
        }
    }
}