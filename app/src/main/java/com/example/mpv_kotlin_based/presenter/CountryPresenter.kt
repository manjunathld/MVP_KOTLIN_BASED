package com.example.mpv_kotlin_based.presenter

import android.util.Log
import com.example.mpv_kotlin_based.model.CountriesService
import com.example.mpv_kotlin_based.model.CountryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryPresenter {

    private lateinit var countriesAPICallback: CountriesAPICallback
    private val mCountriesService: CountriesService = CountriesService()

    constructor(countriesAPICallback: CountriesAPICallback) {
        this.countriesAPICallback = countriesAPICallback
        fetchCountries()
    }

    private fun fetchCountries() {
        mCountriesService.getCountries().enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                val data: List<CountryModel>? = response.body()
                if (data != null) {
                    countriesAPICallback.onResponse(data)
                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                Log.d("Req onFailure", "")
                countriesAPICallback.onError(t)
            }

        })
    }

    public interface CountriesAPICallback {
        fun onResponse(listCountryModel: List<CountryModel>)
        fun onError(error: Throwable)
    } 

}

