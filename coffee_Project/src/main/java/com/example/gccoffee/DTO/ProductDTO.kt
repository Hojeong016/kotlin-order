package com.example.gccoffee.DTO

import com.example.gccoffee.entity.Category


data class ProductDTO(
    val productId: Long?,
    val productName: String,
    val category: Category ,
    val price: Long ,
    val description: String ,
)
