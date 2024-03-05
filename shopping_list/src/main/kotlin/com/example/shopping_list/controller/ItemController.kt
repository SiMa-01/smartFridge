package com.example.shopping_list.controller


import com.example.shopping_list.dto.Item
import com.example.shopping_list.repository.ItemRepository
import com.example.shopping_list.service.ItemService
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ItemController (private val itemRepository: ItemRepository, private val itemService: ItemService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "all good",
                content = [Content(mediaType = "application")]
            )
        ]
    )

    @GetMapping("/items")
    fun getItems(@RequestParam(required = false) id: String?,
                 @RequestParam(required = false) name: String?,
                 @RequestParam(required = false) quantity: String?): ResponseEntity<out List<Any>> {
        if(!id.isNullOrBlank()) {
            return ResponseEntity.ok(listOf(itemRepository.findById(id)))
        }
        return ResponseEntity.ok(itemService.findItem(id, name, quantity))
    }

    @PostMapping("/items")
    fun createItem(@RequestBody item: Item): ResponseEntity<Item>{
        val savedItem = itemRepository.save(item)
        return ResponseEntity.ok(savedItem)
    }

    @DeleteMapping("/items")
    fun deleteItem(@RequestParam id: String): ResponseEntity<Unit>{
        itemRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
