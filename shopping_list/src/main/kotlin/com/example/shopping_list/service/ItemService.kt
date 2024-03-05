package com.example.shopping_list.service


import com.example.shopping_list.dto.Item
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ItemService(private val mongoTemplate: MongoTemplate) {

    fun findItem(id: String?, name: String?, quantity: String?): List<Item> {
        val query = Query()

        if (!name.isNullOrBlank()) {
            query.addCriteria(Criteria.where("name").`is`(name))
        }

        if (!quantity.isNullOrBlank()) {
            query.addCriteria(Criteria.where("quantity").`is`(quantity))
        }

        return mongoTemplate.find(query, Item::class.java)
    }
}