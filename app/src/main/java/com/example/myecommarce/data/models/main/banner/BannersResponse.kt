package com.example.myecommarce.data.models.main.banner

data class BannersResponse(
    val `data`: List<BannersData>,
    val message: String?,
    val status: Boolean
)