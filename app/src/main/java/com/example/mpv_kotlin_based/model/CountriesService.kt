package com.example.mpv_kotlin_based.model

import com.example.mpv_kotlin_based.constants.CONSTANTS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private lateinit var countriesAPI: CountriesAPI

    //CountriesService Constructor
    public constructor() {
        val okHttpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        okHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(okHttpLoggingInterceptor)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(CONSTANTS.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        countriesAPI = retrofit.create(CountriesAPI::class.java)
    }

    public fun getCountries(): Call<List<CountryModel>> {
        return countriesAPI.getCountryModel()
    }

}