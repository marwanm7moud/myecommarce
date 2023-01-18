package com.example.myecommarce.data.models.main.Products

data class ProductResponse(
    val `data`: ProductResponseData,
    val message: String?,
    val status: Boolean
)