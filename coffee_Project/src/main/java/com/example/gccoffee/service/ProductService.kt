package com.example.gccoffee.service

import com.example.gccoffee.DTO.ProductDTO
import com.example.gccoffee.entity.Category
import com.example.gccoffee.entity.Product
import java.util.*

interface ProductService {

    fun products(): List<Product?>?
    fun registerProduct(productDTO: ProductDTO): Product
    fun getProductsByCategory(category: Optional<Category?>): List<Product?>?
    fun productInfo(productId: Long) : Product
    fun updateProduct(productId: Long,productDTO: ProductDTO)
    fun deleteProduct(productId : Long)
}
