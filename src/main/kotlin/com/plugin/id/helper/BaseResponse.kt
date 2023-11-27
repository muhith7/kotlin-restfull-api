package com.plugin.id.helper

data class BaseResponse<T>(
    val code : Int,
    val message : String,
    val data : T
)
