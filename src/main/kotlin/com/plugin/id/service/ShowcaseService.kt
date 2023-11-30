package com.plugin.id.service

import com.plugin.id.model.CreateShowcaseRequest
import com.plugin.id.model.ListShowcaseRequest
import com.plugin.id.model.ShowcaseResponse

interface ShowcaseService {
    fun create(createShowcaseRequest: CreateShowcaseRequest) : ShowcaseResponse
    fun get(id : Int) : ShowcaseResponse

    fun list(listShowcaseRequest: ListShowcaseRequest) : List<ShowcaseResponse>
}