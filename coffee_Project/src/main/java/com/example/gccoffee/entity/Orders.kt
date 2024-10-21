package com.example.gccoffee.entity

import jakarta.persistence.*
import lombok.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)// Date를 등록, 수정 일시 자동 반영 중요!!
data class Orders (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ordersId: Long? = null,
    var email: String? = null,
    var address: String? = null,
    var postcode: String? = null,
    var oderStatus: OderStatus? = null,

    @CreatedDate
    var createAt: LocalDateTime? = null,

    @LastModifiedDate
    var updateAt: LocalDateTime? = null //OneToMany 양방향 관계 지정
    //이점 - order를 입력했을 때 orderItem 한번에 가져 올 수 있다
)
