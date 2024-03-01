package com.example.cocktailapi.repository

import com.example.cocktailapi.dto.Item
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository: MongoRepository<Item, String> {


}