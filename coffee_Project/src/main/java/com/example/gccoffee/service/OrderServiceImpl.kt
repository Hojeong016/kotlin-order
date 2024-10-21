package com.example.gccoffee.service

import com.example.gccoffee.DTO.OrderDTO
import com.example.gccoffee.DTO.OrderItemDTO
import com.example.gccoffee.entity.OrderItem
import com.example.gccoffee.entity.Orders
import com.example.gccoffee.entity.Product
import com.example.gccoffee.repository.OrderItemRepository
import com.example.gccoffee.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
) : OrderService  {

    override fun registerOrder(orderDTO: OrderDTO): OrderDTO {
        //dto를 엔티티로 변환하기
        val order = Orders().apply {
            this.email = orderDTO.email
            this.address = orderDTO.address
            this.postcode = orderDTO.postCode
        }
        orderRepository.save(order)

        // 리스트 처리
        val orderItemList: List<OrderItemDTO> = orderDTO.orderItemList

        //리스트를 순회하며 각 주문 목록을 저장한다. set이 없으므로 copy를 사용한다.
        orderItemList.forEach { orderItemDTO ->
         /*   val product:Product = Product().apply {
                this.productId = orderItemDTO.productId
            }*/
            // DTO를 엔티티로 변환할 때 apply를 사용하여 필드를 초기화
            val orderItem = OrderItem().apply {
                this.orderItemId = order.ordersId // 주문 ID 설정
                this.product = Product(orderItemDTO.productId)
                this.price = orderItemDTO.price
                this.quantity = orderItemDTO.quantity
            }
            orderItemRepository.save(orderItem)
        }
        return OrderDTO(order.email, order.address,order.postcode, orderItemList)
    }
}
