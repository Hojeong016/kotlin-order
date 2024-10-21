package com.example.gccoffee.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)// Date를 등록, 수정 일시 자동 반영 중요!!
data class Product (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productId: Long? = null,

    var productName: String? = null,

    @Enumerated(EnumType.STRING)
    var category: Category?=null,

    var price: Long? = null,

    var description: String? = null,

    @CreatedDate
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
)
