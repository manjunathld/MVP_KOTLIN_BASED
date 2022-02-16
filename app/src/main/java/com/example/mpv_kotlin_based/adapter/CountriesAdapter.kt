package com.example.mpv_kotlin_based.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mpv_kotlin_based.R
import com.example.mpv_kotlin_based.model.CountryModel

class CountriesAdapter(listCountriesModel: List<CountryModel>, countriesViewHolderListener: CountriesViewHolderListener) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private lateinit var localListCountriesModel : List<CountryModel>
    private lateinit var countriesViewHolderListener: CountriesViewHolderListener

    init {
        this.countriesViewHolderListener = countriesViewHolderListener
        this.localListCountriesModel = listCountriesModel
    }

    class CountriesViewHolder(countryItemView: View) : RecyclerView.ViewHolder(countryItemView) {
        private val tvCountryCode: TextView = countryItemView.findViewById(R.id.tv_CountryCode)
        private val tvCountryName: TextView = countryItemView.findViewById(R.id.tv_CountryName)
        private val tvCountryDate: TextView = countryItemView.findViewById(R.id.tv_CountryDate)

        fun bindData(countryModel: CountryModel) {
            tvCountryCode.text = countryModel.countryCode
            tvCountryName.text = countryModel.countryName
            tvCountryDate.text = countryModel.countryDate
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesViewHolder {
        val countryRowItemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_row_item, parent, false)

        return CountriesViewHolder(countryRowItemView)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bindData(localListCountriesModel[position])
        holder.itemView.setOnClickListener(View.OnClickListener {
            countriesViewHolderListener.onItemClick(holder)
        })
    }

    override fun getItemCount(): Int {
        return if (localListCountriesModel.isNotEmpty()) {
            localListCountriesModel.size
        } else { 0 }
    }

    public interface CountriesViewHolderListener {
        fun onItemClick(countriesViewHolder: CountriesViewHolder)
    }
}