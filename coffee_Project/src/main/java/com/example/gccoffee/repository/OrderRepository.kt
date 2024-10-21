package com.example.gccoffee.repository

import com.example.gccoffee.entity.Orders
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Orders?, Long?>
