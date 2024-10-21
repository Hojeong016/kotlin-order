package com.example.gccoffee.service

import com.example.gccoffee.DTO.OrderDTO

interface OrderService {
    fun registerOrder(orderDTO: OrderDTO): OrderDTO
}
