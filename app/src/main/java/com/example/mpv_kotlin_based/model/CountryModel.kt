package com.example.mpv_kotlin_based.model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("name")
    val countryName: String,
    @SerializedName("date")
    val countryDate: String
)
