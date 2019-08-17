package com.example.repository.network


import com.example.repository.network.entity.ProductoNetwork
import retrofit2.Call
import retrofit2.http.*

interface ProductApi {
    @GET("productos")
    fun obtenerProductos(@Query("buscar") buscarParam: String): Call<ArrayList<ProductoNetwork>>
}