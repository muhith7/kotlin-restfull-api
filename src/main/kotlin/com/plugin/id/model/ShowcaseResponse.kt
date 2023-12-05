package com.plugin.id.model

import java.util.Date

data class ShowcaseResponse (
    val id : Int,
    val title : String,
    val image : String,
    val description : String,
    val createdAt : Date,
    val updatedAt : Date

)