package com.plugin.id.controller

import com.plugin.id.helper.BaseResponse
import com.plugin.id.model.CreateShowcaseRequest
import com.plugin.id.model.ShowcaseResponse
import com.plugin.id.service.ShowcaseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ShowcaseController(val showcaseService: ShowcaseService) {
    @PostMapping(
        value = ["/api/showcase"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun createShowcase(@RequestBody createShowcaseRequest: CreateShowcaseRequest): BaseResponse<ShowcaseResponse> {
        val showcaseResponse = showcaseService.create(createShowcaseRequest)
        return BaseResponse(
            code = 200,
            message = "Data berhasil di buat",
            data = showcaseResponse
        )
    }

    @GetMapping(
        value = ["api/showcase/{idShowcase}"],
        produces = ["application/json"]
    )
    fun getShowcase(@PathVariable("idShowcase") id : Int) : BaseResponse<ShowcaseResponse>{
        val showcaseResponse = showcaseService.get(id)
        return BaseResponse(
            code = 200,
            message = "Data berhasil di buat",
            data = showcaseResponse
        )
    }
}