package com.example.entity

data class ProductEntity  (val id: Int? = null,
                           val nombre: String,
                           val precio: Double,
                           val lote: Int,
                           val stock: Int,
                           val descripcion: String)

