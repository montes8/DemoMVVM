package com.example.usecases.usecases

import com.example.entity.ProductEntity
import com.example.usecases.repository.ProductRepositoryNetwork


class ProductUseCase(var productNetworkRepository: ProductRepositoryNetwork) {

    fun getProduct(): ArrayList<ProductEntity> {
        return productNetworkRepository.getProduct()
    }
}