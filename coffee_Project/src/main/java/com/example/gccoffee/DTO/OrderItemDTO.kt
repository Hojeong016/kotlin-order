package com.example.gccoffee.DTO

import com.example.gccoffee.entity.Category

data class OrderItemDTO(
    val ordersId: Long,
    val productId: Long ,
    val category: Category,
    val price: Long,
    val quantity: Long,
)
