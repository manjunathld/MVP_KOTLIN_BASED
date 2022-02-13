package com.example.mpv_kotlin_based.model

import com.example.mpv_kotlin_based.constants.CONSTANTS
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {

    @GET(CONSTANTS.PATH_COUNTRIES)
    fun getCountryModel(): Call<List<CountryModel>>

}