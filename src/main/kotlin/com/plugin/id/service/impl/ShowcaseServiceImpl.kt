package com.plugin.id.service.impl

import com.cloudinary.utils.ObjectUtils
import com.plugin.id.config.CloudinaryConfig
import com.plugin.id.entity.Showcase
import com.plugin.id.helper.NotFoundException
import com.plugin.id.model.CreateShowcaseRequest
import com.plugin.id.model.ListShowcaseRequest
import com.plugin.id.model.ShowcaseResponse
import com.plugin.id.repository.CategoryRepository
import com.plugin.id.repository.ShowcaseRepository
import com.plugin.id.service.ShowcaseService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.stream.Collectors
import kotlin.math.log

@Service
class ShowcaseServiceImpl (val showcaseRepository: ShowcaseRepository, val categoryRepository: CategoryRepository)
    : ShowcaseService {
    override fun create(createShowcaseRequest: CreateShowcaseRequest): ShowcaseResponse {
        val kategori = categoryRepository.findCategoryByIdCategory(createShowcaseRequest.idCategory)
        val cloudinary = CloudinaryConfig()
        val uploadResponse = cloudinary.cloudinaryAccount().uploader()
            .upload(createShowcaseRequest.image.bytes, ObjectUtils.asMap())

        val showcase = Showcase(
            title = createShowcaseRequest.title!!,
            image = uploadResponse.get("url").toString(),
            description = createShowcaseRequest.description!!,
            createdAt = Date(),
            updatedAt = Date()
        )
        showcase.category = kategori
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

    override fun list(listShowcaseRequest: ListShowcaseRequest): List<ShowcaseResponse> {
        val page  =  showcaseRepository.findAll(
            PageRequest.of(
                listShowcaseRequest.page,
                listShowcaseRequest.size
            )
        )
        val showcase : List<Showcase> = page.get().collect(Collectors.toList())
        return showcase.map { convertShowcaseToShowcaseResponse(it) }
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