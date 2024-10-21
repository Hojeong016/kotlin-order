package com.example.gccoffee.controller.api

import com.example.gccoffee.DTO.OrderDTO
import com.example.gccoffee.service.OrderService
import lombok.RequiredArgsConstructor
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderController(private val orderService: OrderService) {

    @PostMapping("/api/v1/orders")
    fun createOrder(@Validated @RequestBody orderDTO: OrderDTO?): OrderDTO? = orderDTO?.let { orderService.registerOrder(orderDTO) }

}
