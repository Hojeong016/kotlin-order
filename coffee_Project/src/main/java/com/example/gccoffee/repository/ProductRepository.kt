package com.example.gccoffee.repository

import com.example.gccoffee.entity.Category
import com.example.gccoffee.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p")
    fun findAlls(): List<Product?>?

    @Query("SELECT p FROM Product p WHERE p.category=:category")
    fun findByCategory(@Param("category") category: Optional<Category?>): List<Product?>?
}
