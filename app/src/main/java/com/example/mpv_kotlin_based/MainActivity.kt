package com.example.mpv_kotlin_based

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mpv_kotlin_based.adapter.CountriesAdapter
import com.example.mpv_kotlin_based.model.CountriesService
import com.example.mpv_kotlin_based.model.CountryModel
import com.example.mpv_kotlin_based.presenter.CountryPresenter
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CountryPresenter.View {

    private lateinit var rvCountries: RecyclerView
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var listOfCountriesModel: ArrayList<CountryModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCountries = findViewById(R.id.rv_CountriesView)
        listOfCountriesModel = ArrayList<CountryModel>()

        CountryPresenter(this)

        countriesAdapter = CountriesAdapter(listOfCountriesModel)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rvCountries.layoutManager = linearLayoutManager
        rvCountries.adapter = countriesAdapter


    }

    override fun onResponse(listCountryModel: List<CountryModel>) {
        listOfCountriesModel.clear()
        listOfCountriesModel.addAll(listCountryModel)
        countriesAdapter.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        Log.e("onError", ""+error.toString())
    }
}