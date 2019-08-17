package com.example.repository.network.entity

import com.example.entity.ProductEntity

class ProductoNetwork (val id: Int? = null,
                       val nombre: String,
                       val precio: Double,
                       val lote: Int,
                       val stock: Int,
                       val descripcion: String) {
    companion object {
        fun toProduct(productEntity : ArrayList<ProductoNetwork>):ArrayList<ProductEntity>  {
            val lista : ArrayList<ProductEntity> = ArrayList()
            for ( product in productEntity){

                lista.add(ProductEntity(product.id,product.nombre,product.precio,product.lote,product.stock,product.descripcion))
            }
            return lista
        }
    }

}
