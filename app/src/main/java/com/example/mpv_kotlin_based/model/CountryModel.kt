package com.example.mpv_kotlin_based.model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("id")
    val countryID: Int,
    @SerializedName("market")
    val countryMarket: String,
    @SerializedName("price")
    val countryPrice: String
)
