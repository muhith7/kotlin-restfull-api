package com.plugin.id.repository

import com.plugin.id.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int> {
    fun findCategoryByIdCategory(id : Int) : Category
}