package com.example.gccoffee.entity

import jakarta.persistence.*
import lombok.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Entity
@EntityListeners(AuditingEntityListener::class)
 // Date를 등록, 수정 일시 자동 반영 중요!!
data class OrderItem (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var orderItemId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    var orders: Orders? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product? = null,

    @Enumerated(EnumType.STRING)
    var category: Category? = null, //밸류값으로 맵핑
    var price: Long? = null,
    var quantity: Long? = null,

    @CreatedDate
    var createdAt: Date? = null,

    @LastModifiedDate
    var updatedAt: Date? = null
)
