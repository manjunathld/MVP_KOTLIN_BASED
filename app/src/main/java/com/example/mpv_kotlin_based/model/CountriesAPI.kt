package com.example.mpv_kotlin_based.model

import com.example.mpv_kotlin_based.constants.CONSTANTS
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountriesAPI {

    @GET(CONSTANTS.PATH_COUNTRIES)
    fun getCountryModel(): Observable<List<CountryModel>>

}