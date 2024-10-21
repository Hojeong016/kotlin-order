package com.example.gccoffee.controller

import com.example.gccoffee.DTO.ProductDTO
import com.example.gccoffee.entity.Product
import com.example.gccoffee.service.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
@RequiredArgsConstructor
class ProductController (private val productService: ProductService) {

    //전체 상품 조회
    @GetMapping("/products")
    fun productsPage(model: Model): String {
        val products = productService.products()
        model.addAttribute("products", products)
        return "product-list"
    }

    //새로운 상품 등록
    @GetMapping("new-product")
    fun newProductPage(): String =  "new-product"



    @PostMapping("/products")
    fun newProduct(@ModelAttribute product: Product?, productDTO: ProductDTO): String {
        productService.registerProduct(productDTO)
        return "redirect:/products"
    }

    //상품 상세
    @GetMapping("/edit-product/{id}")
    fun editProductForm(@PathVariable("id") id: Long, model: Model): String {
        val product: Product ?= productService.productInfo(id)

        return product?.let {
            model.addAttribute("product", it)
            "edit-product"  // product가 null이 아닌 경우
        } ?: "redirect:/products"  // product가 null인 경우 리다이렉트
    }


    // 상품 수정 (POST 요청)
    @PostMapping("/edit-product/{id}")
    fun updateProduct(@PathVariable("id") id: Long, @ModelAttribute("product") productDTO: ProductDTO): String {
        productService.updateProduct(id,productDTO)
        return "redirect:/products" // 수정 후 목록 페이지로 리디렉션
    }


    //상품정보 삭제
    // 상품 삭제 처리 (POST 요청)
    @PostMapping("/delete-product/{id}")
    fun deleteProduct(@PathVariable("id") id: Long): String? {
        productService.deleteProduct(id)
        return "redirect:/products"
    }

    @GetMapping("/delete-product/{id}")
    fun deleteProductConfirmation(@PathVariable id: Long, model: Model): String {
        val product: Product? = productService.productInfo(id) // nullable로 선언

        return product?.let {
            model.addAttribute("product", it)
            "delete-confirm" // delete-confirm.html 페이지로 이동
        } ?: "redirect:/products" // 상품이 없으면 목록 페이지로 리디렉션
    }
}
