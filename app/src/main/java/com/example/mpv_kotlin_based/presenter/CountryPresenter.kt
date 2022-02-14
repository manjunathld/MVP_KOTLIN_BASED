package com.example.mpv_kotlin_based.presenter

import android.util.Log
import android.view.View
import com.example.mpv_kotlin_based.MainActivity
import com.example.mpv_kotlin_based.model.CountriesService
import com.example.mpv_kotlin_based.model.CountryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CountryPresenter {

    private lateinit var view: View
    private val mCountriesService: CountriesService = CountriesService()

    constructor(view: View) {
        this.view = view
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
                    view.onResponse(data)
                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                Log.d("Req onFailure", "")
                view.onError(t)
            }

        })
    }

    public interface View {
        fun onResponse(listCountryModel: List<CountryModel>)
        fun onError(error: Throwable)
    } 

}

