package com.example.shoppingList.repository

import com.example.shoppingList.dto.Item
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository: MongoRepository<Item, String> {


}