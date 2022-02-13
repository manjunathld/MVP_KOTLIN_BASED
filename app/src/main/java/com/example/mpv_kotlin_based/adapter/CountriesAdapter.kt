package com.example.mpv_kotlin_based.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mpv_kotlin_based.R
import com.example.mpv_kotlin_based.model.CountryModel

class CountriesAdapter(listCountriesModel: List<CountryModel>) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private val localListCountriesModel : List<CountryModel> = listCountriesModel

    class CountriesViewHolder(countryItemView: View) : RecyclerView.ViewHolder(countryItemView) {
        private lateinit var tvCountryCode: TextView
        private lateinit var tvCountryName: TextView
        private lateinit var tvCountryDate: TextView

        public fun bindData(countryModel: CountryModel) {
            tvCountryCode.text = countryModel.countryCode
            tvCountryName.text = countryModel.countryName
            tvCountryDate.text = countryModel.countryDate
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesAdapter.CountriesViewHolder {
        val countryRowItemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_row_item, parent, false)

        return CountriesViewHolder(countryRowItemView)
    }

    override fun onBindViewHolder(holder: CountriesAdapter.CountriesViewHolder, position: Int) {
        holder.bindData(localListCountriesModel[position])
    }

    override fun getItemCount(): Int {
        return localListCountriesModel.size
    }
}