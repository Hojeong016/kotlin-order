package com.example.gccoffee.repository

import com.example.gccoffee.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem?, Long?>
