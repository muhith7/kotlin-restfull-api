package com.plugin.id.service.impl

import com.plugin.id.entity.Showcase
import com.plugin.id.helper.NotFoundException
import com.plugin.id.model.CreateShowcaseRequest
import com.plugin.id.model.ShowcaseResponse
import com.plugin.id.repository.ShowcaseRepository
import com.plugin.id.service.ShowcaseService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import kotlin.math.log

@Service
class ShowcaseServiceImpl (val showcaseRepository: ShowcaseRepository) : ShowcaseService {
    override fun create(createShowcaseRequest: CreateShowcaseRequest): ShowcaseResponse {
        val showcase = Showcase(
            title = createShowcaseRequest.title!!,
            image = createShowcaseRequest.image!!,
            description = createShowcaseRequest.description!!,
            createdAt = Date(),
            updatedAt = Date()
        )
        showcaseRepository.save(showcase)
        return convertShowcaseToShowcaseResponse(showcase)
    }

    override fun get(id: Int): ShowcaseResponse {
        val showcase = showcaseRepository.findByIdOrNull(id)
        if (showcase === null) {
            throw Exception()
        } else {
            return convertShowcaseToShowcaseResponse(showcase)
        }
    }

    private fun convertShowcaseToShowcaseResponse
                (showcase: Showcase): ShowcaseResponse {
        return ShowcaseResponse(
            id = showcase.id,
            title = showcase.title,
            image = showcase.image,
            description = showcase.description,
            createdAt = showcase.createdAt,
            updatedAt = showcase.updatedAt
        )
    }
}