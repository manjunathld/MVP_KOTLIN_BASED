package com.example.mpv_kotlin_based

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mpv_kotlin_based.model.CountriesService
import com.example.mpv_kotlin_based.model.CountryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CountriesService().getCountries().enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                val list: List<CountryModel>? = response.body()
                for (index in 0..(list!!.size - 1)) {
                    Log.d("Req onResponse", ""+list[index].countryDate)
                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                Log.d("Req onFailure", "")
            }

        })

    }
}