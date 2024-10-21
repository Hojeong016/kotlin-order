package com.example.gccoffee.service

import com.example.gccoffee.DTO.ProductDTO
import com.example.gccoffee.entity.Category
import com.example.gccoffee.entity.Product
import com.example.gccoffee.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
open class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    //모든 상품 정보 반환
    override fun products(): List<Product?>? = productRepository.findAll()

    //새로운 상품 등록
    override fun registerProduct(productDTO: ProductDTO): Product {
        val products = Product().apply {
            this.productName= productDTO.productName
            this.category= productDTO.category
            this.price = productDTO.price
            this.description =productDTO.description
        }
        return productRepository.save(products)
    }

    override fun getProductsByCategory(category: Optional<Category?>): List<Product?>? {
        return productRepository.findByCategory(category)
    }

    //상세 상품 조회
    override fun productInfo(productId: Long): Product = productRepository.findById(productId).orElse(null)

    //상품 정보 수정
    override fun updateProduct(productId : Long, productDTO: ProductDTO){
       //가존의 상퓸 정보가 맞는지 확인
        val product : Product = productRepository.findById(productId).orElse(null)

        // 존재하면 해당 set
        //save
        product.let {
            it.productName = productDTO.productName
            it.price = productDTO.price
            it.category = productDTO.category
            it.description = productDTO.description
            productRepository.save(it)
        }

    }
    //상퓸 삭제
    override fun deleteProduct(productId: Long) = productRepository.deleteById(productId)
}

//log 클래스 만들어서 찍어보기
