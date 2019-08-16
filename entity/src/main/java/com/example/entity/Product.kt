package com.example.entity

data class Product (
    var storeId: Int,
    var storeName: String,
    var categoryName: String,
    var brand: String,
    var productName: String,
    var priceRegularCurrent: Double,
    var priceRegularBefore: Double,
    var priceOhCard: Double,
    var offer: String


)
{

}
