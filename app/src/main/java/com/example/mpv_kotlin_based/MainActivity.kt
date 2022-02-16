package com.example.mpv_kotlin_based

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mpv_kotlin_based.adapter.CountriesAdapter
import com.example.mpv_kotlin_based.model.CountryModel
import com.example.mpv_kotlin_based.presenter.CountryPresenter

class MainActivity : AppCompatActivity(), CountryPresenter.View, CountriesAdapter.CountriesViewHolderListener {

    private lateinit var rvCountries: RecyclerView
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var listOfCountriesModel: ArrayList<CountryModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCountries = findViewById(R.id.rv_CountriesView)
        listOfCountriesModel = ArrayList<CountryModel>()

        CountryPresenter(this)

        countriesAdapter = CountriesAdapter(listOfCountriesModel, this)
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
        Log.e("onError", "" + error.toString())
    }

    override fun onItemClick(
        countriesViewHolder: CountriesAdapter.CountriesViewHolder
    ) {
        val position: Int = countriesViewHolder.adapterPosition
        val countriesID: String = listOfCountriesModel[position].countryCode
        val countryName: String = listOfCountriesModel[position].countryName
        val countryDate: String = listOfCountriesModel[position].countryDate
        Toast.makeText(
            this,
            "Item clicked\n"+
                    "Country ID: $countriesID\n"+
                    "Country Name: $countryName\n"+
                    "Country Date: $countryDate", Toast.LENGTH_SHORT
        ).show()
    }

}