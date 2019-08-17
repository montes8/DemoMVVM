package com.example.repository.network.api

import com.example.entity.ProductEntity
import com.example.repository.network.ProductApi
import com.example.repository.network.entity.ProductoNetwork
import com.example.usecases.repository.ProductRepositoryNetwork
import retrofit2.Call
import java.lang.Exception

class ProductNetwork(private val apiConfig: ProductApi) : ProductRepositoryNetwork {
    @Throws(Exception::class)
    override fun getProduct(): ArrayList<ProductEntity>  {

        val callApplicationEntity : Call<ArrayList<ProductoNetwork>> = apiConfig.obtenerProductos("")
        val applicationEntity: ArrayList<ProductoNetwork>? = callApplicationEntity.execute().body()
        if (applicationEntity!!.size>0){
            return ProductoNetwork.toProduct(applicationEntity)
        } else{
            throw Exception()
        }
    }

}