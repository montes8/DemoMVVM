package com.example.usecases.repository
import com.example.entity.ProductEntity
import java.lang.Exception


interface ProductRepositoryNetwork {
    @Throws(Exception::class)
    fun getProduct(): ArrayList<ProductEntity>
}