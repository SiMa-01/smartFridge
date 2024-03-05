package com.example.shopping_list.repository

import com.example.shopping_list.dto.Item
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository: MongoRepository<Item, String> {


}