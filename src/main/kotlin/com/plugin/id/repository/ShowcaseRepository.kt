package com.plugin.id.repository

import com.plugin.id.entity.Showcase
import org.springframework.data.jpa.repository.JpaRepository

interface ShowcaseRepository : JpaRepository<Showcase, Int> {
}