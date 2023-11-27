package com.plugin.id.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "showcase")
data class Showcase(
    @Id
    @GeneratedValue
    val id : Int = 0,
    @Column(name = "title")
    val title : String,
    @Column(name = "image")
    val image : String,
    @Column(name = "description")
    val description : String,
    @Column(name = "created_at")
    val createdAt : Date,
    @Column(name = "updated_at")
    val updatedAt : Date
)
