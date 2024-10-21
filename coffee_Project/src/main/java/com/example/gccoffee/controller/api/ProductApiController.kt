package com.example.gccoffee.controller.api

import com.example.gccoffee.entity.Category
import com.example.gccoffee.entity.Product
import com.example.gccoffee.service.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequiredArgsConstructor
@Transactional
open class ProductApiController(private val productService: ProductService) {


    //만약 ?category 로 카테고리의 값이 들어오면 해당 카테고리에 속한 상품을 리스트 / 아니면 전체 리스트
    @GetMapping("/api/v1/products")
    fun productList(@RequestParam category: Optional<Category?>): List<Product?>? {

        return if (category.isEmpty) {
            productService.products() // 카테고리가 없으면 전체 리스트 반환
        } else {
           productService.getProductsByCategory(category) // 카테고리가 있으면 해당 카테고리 상품 리스트 반환
        }

    }

}
