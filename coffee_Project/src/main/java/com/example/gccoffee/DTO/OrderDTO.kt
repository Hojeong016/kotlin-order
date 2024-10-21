package com.example.gccoffee.DTO

import com.example.gccoffee.entity.OderStatus
import com.example.gccoffee.entity.Orders
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import lombok.Data
import lombok.NoArgsConstructor


data class OrderDTO(

    @field:Email(message = "이메일 형식에 맞지 않습니다.")
    @field:NotBlank(message = "이메일은 필수 입력 값입니다.")
    val email: String? = null,

    @field:NotBlank(message = "주소는 필수 입력 값입니다.")
    val address: String? = null,

    @field:NotBlank(message = "우편 번호는 필수 입력 값입니다.")
    val postCode: String? = null,

    val orderItemList: List<OrderItemDTO> = emptyList() // 기본값으로 빈 리스트(emptyList())로 초기화
)
