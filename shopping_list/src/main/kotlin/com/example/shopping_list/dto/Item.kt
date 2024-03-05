package com.example.shopping_list.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Item (
    @Id val _id: String?,
    val name: String,
    val quantity: String
)