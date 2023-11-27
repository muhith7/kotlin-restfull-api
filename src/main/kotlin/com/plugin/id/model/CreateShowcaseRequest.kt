package com.plugin.id.model

import jakarta.validation.constraints.NotBlank


data class CreateShowcaseRequest(
    @field: NotBlank
    val title : String?,
    @field: NotBlank
    val image : String?,
    @field: NotBlank
    val description : String?
)
